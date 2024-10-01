package net.engineerofchaos.entity;

import net.engineerofchaos.entity.ai.HelicopterAI;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EntityBigHeli extends EntityLiving {
    // 0 = full speed, 1 = spin down, 2 = stationary, 3 = spin up
    private static final DataParameter<Integer> ROTOR_STATE = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.VARINT);
    private static final DataParameter<Float> ROTOR_SPEED = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.FLOAT);
    private static final DataParameter<Float> ROTOR_ANGLE = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.FLOAT);
    private static final DataParameter<BlockPos> LANDING_LOCATION = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.BLOCK_POS);
    // 0 = flying, 1 = landing, 2 = on ground, 3 = taking off
    private static final DataParameter<Integer> ACTION = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.VARINT);

    private int rotorSpinTimer = 300;
    private int rotorSpinCounter = 0;

    private float lastBladeAngle;
    private float bladeAngle;

    public EntityBigHeli(World worldIn) {
        super(worldIn);
        setSize(5.0f, 2.0f);
        this.moveHelper = new HelicopterAI.HeliMoveHelper(this);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        EntityPlayer nearestPlayer = this.world.<EntityPlayer>getClosestPlayerToEntity(this, 100);

        this.lastBladeAngle = this.bladeAngle;
        this.bladeAngle += 0.05F * getRotorSpeed() * ((float) Math.PI / 30F);
        if (this.bladeAngle >= 2 * Math.PI) {
            this.bladeAngle -= (2F * (float) Math.PI);
            this.lastBladeAngle -= (2F * (float) Math.PI);
        }

        if (!world.isRemote) {

            if (nearestPlayer != null) {
                //nearestPlayer.sendMessage(new TextComponentString("Action: " + getCurrentAction() + ", RotorSpeed: " + getRotorSpeed()));
                //nearestPlayer.sendMessage(new TextComponentString("Blade angle (entity side): " + bladeAngle));
                //nearestPlayer.sendMessage(new TextComponentString("Blade angle (entity side, function w/ no partial): " + getBladeAngle(0)));
                if (nearestPlayer.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.STICK && getCurrentAction() == 0) {
                    setAction(1);
                }
            }

            if (getCurrentAction() == 2 && getRotorSpeed() > 0) {
                setRotorSpeed(Math.max(0, getRotorSpeed() - 0.5F));
            }



//            setRotorAngle(getRotorAngle() + getRotorSpeed() * 0.005F);
//            setRotorAngle(getRotorAngle() % (2 * (float) Math.PI));


//            if (getCurrentAction() == 2 && getRotorState() == 0) {
//                //nearestPlayer.sendMessage(new TextComponentString("Landed and rotor spinning: initiating spin down"));
//                setRotorState(1);
//            }
//
//            if (getRotorState() == 0 || getRotorState() == 2) {
//                rotorSpinCounter = 0;
//            } else {
//                rotorSpinCounter += 1;
//            }
//
//            if (rotorSpinCounter >= rotorSpinTimer) {
//                //nearestPlayer.sendMessage(new TextComponentString("Spin down complete, stopping rotors"));
//                setRotorState(2);
//                rotorSpinCounter = 0;
//            }
        }
    }

    public float getBladeAngle(float partialTickTime) {
        return lastBladeAngle + (bladeAngle - lastBladeAngle) * partialTickTime;
    }

    public void fall(float distance, float damageMultiplier)
    {
    }

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(ROTOR_STATE, 0);
        this.dataManager.register(ROTOR_SPEED, 200F);
        this.dataManager.register(LANDING_LOCATION, new BlockPos(0, 0, 0));
        this.dataManager.register(ACTION, 0);
        this.dataManager.register(ROTOR_ANGLE, 0.0F);
    }

    protected void initEntityAI() {
        this.tasks.addTask(1, new HelicopterAI.AILandAtCoords(this));
        this.tasks.addTask(2, new HelicopterAI.AIRandomFly(this));
        this.tasks.addTask(3, new HelicopterAI.AILookAround(this));
    }

    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {

    }

    // Rotor State Data
    public int getRotorState() {
        return this.dataManager.get(ROTOR_STATE);
    }
    public void setRotorState(int state) {
        this.dataManager.set(ROTOR_STATE, state);
    }

    // Rotor Speed Data
    public float getRotorSpeed() {
        return this.dataManager.get(ROTOR_SPEED);
    }
    public void setRotorSpeed(float speed) {
        this.dataManager.set(ROTOR_SPEED, speed);
    }
    // Rotor Angle Data
    public float getRotorAngle() {
        return this.dataManager.get(ROTOR_ANGLE);
    }
    public void setRotorAngle(float angle) {
        this.dataManager.set(ROTOR_ANGLE, angle);
    }

    // Action Data
    public int getCurrentAction() {
        return this.dataManager.get(ACTION);
    }
    public void setAction(int action) {
        this.dataManager.set(ACTION, action);
    }

    // Landing pos data
    public BlockPos getLandingLocation() {
        return this.dataManager.get(LANDING_LOCATION);
    }
    public void setLandingLocation(BlockPos position) {
        this.dataManager.set(LANDING_LOCATION, position);
    }

    public void travel(float strafe, float vertical, float forward)
    {
        if (this.isInWater())
        {
            this.moveRelative(strafe, vertical, forward, 0.02F);
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929D;
            this.motionY *= 0.800000011920929D;
            this.motionZ *= 0.800000011920929D;
        }
        else if (this.isInLava())
        {
            this.moveRelative(strafe, vertical, forward, 0.02F);
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
        }
        else
        {
            float f = 0.91F;

            if (this.onGround)
            {
                BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                IBlockState underState = this.world.getBlockState(underPos);
                f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
            }

            float f1 = 0.16277136F / (f * f * f);
            this.moveRelative(strafe, vertical, forward, this.onGround ? 0.1F * f1 : 0.02F);
            f = 0.91F;

            if (this.onGround)
            {
                BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                IBlockState underState = this.world.getBlockState(underPos);
                f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
            }

            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)f;
            this.motionY *= (double)f;
            this.motionZ *= (double)f;

            if (getRotorState() != 0) {
                this.motionY -= 0.02D;
            }
        }

        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d1 = this.posX - this.prevPosX;
        double d0 = this.posZ - this.prevPosZ;
        float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }
}
