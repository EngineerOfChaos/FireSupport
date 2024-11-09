package net.engineerofchaos.firesupport.entity;

import net.engineerofchaos.firesupport.entity.ai.HelicopterAI;
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
import net.minecraft.world.World;

public class EntityBigHeli extends EntityLiving {
    private static final DataParameter<Float> ROTOR_SPEED = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.FLOAT);
    private static final DataParameter<BlockPos> LANDING_LOCATION = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.BLOCK_POS);
    // 0 = flying, 1 = landing, 2 = on ground, 3 = taking off
    private static final DataParameter<Integer> ACTION = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.VARINT);

    private float lastBladeAngle;
    private float bladeAngle;

    private float lastYaw;
    private float newYaw;
    private float delta;
    private float targetYaw;

    public EntityBigHeli(World worldIn) {
        super(worldIn);
        setSize(5.0f, 2.0f);
        this.moveHelper = new HelicopterAI.HeliMoveHelper(this);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        //this.renderYawOffset = this.rotationYaw;

        EntityPlayer nearestPlayer = this.world.<EntityPlayer>getClosestPlayerToEntity(this, 100);

        // -------- Blade angle maths --------
        this.lastBladeAngle = this.bladeAngle;
        this.bladeAngle += 0.05F * getRotorSpeed() * ((float) Math.PI / 30F);
        if (this.bladeAngle >= 2 * Math.PI) {
            this.bladeAngle -= (2F * (float) Math.PI);
            this.lastBladeAngle -= (2F * (float) Math.PI);
        }

        // -------- Yaw angle maths --------
        //this.lastYaw = getYaw();
        this.lastYaw = this.newYaw;
        this.targetYaw = -((float) MathHelper.atan2(this.motionX, this.motionZ)) * (180F / (float) Math.PI);
        //if (nearestPlayer != null) {nearestPlayer.sendMessage(new TextComponentString("Raw values: targetYaw: " + targetYaw + ", lastYaw: " + lastYaw));}

        delta = getDelta(lastYaw, targetYaw);
        //if (nearestPlayer != null) {nearestPlayer.sendMessage(new TextComponentString("unclamped delta: " + delta));}

        if (Math.abs(delta) <= 5) {
            newYaw = targetYaw;
        } else if (delta > 5) {
            newYaw = lastYaw + 5;
            delta = 5;
        } else if (delta < 5){
            newYaw = lastYaw - 5;
            delta = -5;
        }

        if (newYaw >= 180) {
            newYaw -= 360;
            lastYaw -= 360;
        } else if (newYaw < -180 ) {
            newYaw += 360;
            lastYaw += 360;
        }


        if (!world.isRemote) {

            if (nearestPlayer != null) {
                //nearestPlayer.sendMessage(new TextComponentString("Action: " + getCurrentAction() + ", RotorSpeed: " + getRotorSpeed()));
                //nearestPlayer.sendMessage(new TextComponentString("Blade angle (entity side): " + bladeAngle));
                //nearestPlayer.sendMessage(new TextComponentString("Blade angle (entity side, function w/ no partial): " + getBladeAngle(0)));
                //nearestPlayer.sendMessage(new TextComponentString("After wrapping: lastYaw: " + lastYaw + ", targetYaw: " + targetYaw));
                //nearestPlayer.sendMessage(new TextComponentString("clamped delta: " + delta));
                if (nearestPlayer.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.STICK && getCurrentAction() == 0) {
                    setAction(1);
                }
            }

            if (getCurrentAction() == 2 && getRotorSpeed() > 0) {
                setRotorSpeed(Math.max(0, getRotorSpeed() - 0.5F));
            }

        }
    }

    public float getBladeAngle(float partialTickTime) {
        return lastBladeAngle + (bladeAngle - lastBladeAngle) * partialTickTime;
    }
    public float getRenderYaw(float partialTicks) {
        return this.lastYaw + (this.delta) * partialTicks;
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
        this.dataManager.register(ROTOR_SPEED, 200F);
        this.dataManager.register(LANDING_LOCATION, new BlockPos(0, 0, 0));
        this.dataManager.register(ACTION, 0);
    }

    protected void initEntityAI() {
        this.tasks.addTask(1, new HelicopterAI.AILandAtCoords(this));
        this.tasks.addTask(2, new HelicopterAI.AIRandomFly(this));
        //this.tasks.addTask(3, new HelicopterAI.AILookAround(this));
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



//    public float getPrevYaw() {
//        return this.dataManager.get(PREV_YAW);
//    }
//    public void setPrevYaw(float yaw) {
//        this.dataManager.set(PREV_YAW, yaw);
//    }

    // Rotor Speed Data
    public float getRotorSpeed() {
        return this.dataManager.get(ROTOR_SPEED);
    }
    public void setRotorSpeed(float speed) {
        this.dataManager.set(ROTOR_SPEED, speed);
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

            if (getRotorSpeed() != 200) {
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

    // bodyHelper supposedly fixes issue but doesn't

//    protected EntityBodyHelper createBodyHelper()
//    {
//        return new EntityBigHeli.BodyHelper(this);
//    }

    class BodyHelper extends EntityBodyHelper
    {
        public BodyHelper(EntityLivingBase theEntity)
        {
            super(theEntity);
        }

        public void updateRenderAngles()
        {
        }
    }

//    // Seems to interface with renderYawOffset, don't know why
//    @Override
//    protected float updateDistance(float f1, float f2) {
//        return f2;
//    }
    private float getDelta(float a, float b) {
        float y = (b - a);
        if (y < -180) {
            y += 360;
        } else if (y > 180) {
            y -= 360;
        }
        return y;
    }
}
