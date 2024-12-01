package net.engineerofchaos.firesupport.entity;

import net.engineerofchaos.firesupport.entity.ai.AIFollowPlayer;
import net.engineerofchaos.firesupport.entity.ai.AircraftMoveHelper;
import net.engineerofchaos.firesupport.pathfinding.FlightPath;
import net.engineerofchaos.firesupport.pathfinding.Waypoint;
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
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.List;

import static java.lang.Math.abs;

public class EntityBigHeli extends EntityLiving {
    private static final DataParameter<Float> ROTOR_SPEED = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.FLOAT);
    private static final DataParameter<BlockPos> LANDING_LOCATION = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.BLOCK_POS);
    // 0 = flying, 1 = landing, 2 = on ground, 3 = taking off
    private static final DataParameter<Integer> ACTION = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.VARINT);
    private static final DataParameter<Float> YAW_TARGET = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.FLOAT);
    private static final DataParameter<Float> ROLL_TARGET = EntityDataManager.createKey(EntityBigHeli.class, DataSerializers.FLOAT);

    private float lastBladeAngle;
    private float bladeAngle;

    private float lastYaw;
    private float newYaw;
    private float yawDelta;
    private float targetYaw;
    private float yawSpeed = 3F; // 3 for fast turns, 0.7 for smooth

    private float lastRoll;
    private float newRoll;
    private float targetRoll;
    private float rollDelta;
    private float rollSpeed = 1F;

    public Vec2f crashDirection;

    public FlightPath currentPath;


    public Waypoint nextWP;

    public EntityBigHeli(World worldIn) {
        super(worldIn);
        setSize(5.0f, 2.0f);
        //this.moveHelper = new HelicopterAI.HeliMoveHelper(this);
        this.moveHelper = new AircraftMoveHelper(this);
    }

    protected void despawnEntity() {
        // Put airspace integration here!
    }

    public void setNextWP(Waypoint nextWP) {
        this.nextWP = null;
        this.currentPath = new FlightPath();
        this.currentPath.addWaypoint(nextWP);
    }
    public void setYawTarget(float yaw) {this.dataManager.set(YAW_TARGET, yaw);}
    public void setRollTarget(float yaw) {this.dataManager.set(ROLL_TARGET, yaw);}

    @Override
    public void onUpdate() {
        super.onUpdate();

        //this.renderYawOffset = this.rotationYaw;

        EntityPlayer nearestPlayer = this.world.<EntityPlayer>getClosestPlayerToEntity(this, 100);

//        if (ticksExisted % 40 == 0) {
//            if (nearestPlayer != null && !world.isRemote) {
//                nearestPlayer.sendMessage(new TextComponentString("Move helper updating: " + this.getMoveHelper().isUpdating()));
//                if (nextWP == null) {
//                    nearestPlayer.sendMessage(new TextComponentString("No target waypoint!"));
//                } else {
//                    nearestPlayer.sendMessage(new TextComponentString("Target waypoint: " + nextWP.x + ", "+ nextWP.y + ", "+ nextWP.z + ", "));
//                }
//            }
//        }

        // Action stored flight path if available (server side only)
        if (!world.isRemote) {
            if (currentPath != null) {
                this.nextWP = currentPath.getTarget();
                List<Float> dump = currentPath.outputWaypoints();
                if (nearestPlayer != null) {
                    nearestPlayer.sendMessage(new TextComponentString(dump.toString()));
                    //nearestPlayer.sendMessage(new TextComponentString(target.x + ", " + target.y + ", " + target.z));
                    //nearestPlayer.sendMessage(new TextComponentString("" + flightPath.counter));
                }
            }

            if (this.nextWP != null) {
                this.getMoveHelper().setMoveTo(this.nextWP.x, this.nextWP.y, this.nextWP.z, 1);
                double d0 = this.nextWP.x - this.posX;
                double d1 = this.nextWP.y - this.posY;
                double d2 = this.nextWP.z - this.posZ;
                float dTotal = (float) Math.sqrt((d0 * d0) + (d1 * d1) + (d2 * d2));
                if (nearestPlayer != null) {
                    //nearestPlayer.sendMessage(new TextComponentString("deltas: " + d0 + ", " + d1 + ", " + d2));
                }

                if (!this.nextWP.strictYaw) {
                    this.setYawTarget(-((float) MathHelper.atan2(d0, d2)) * (180F / (float) Math.PI));
                } else {
                    if (this.nextWP.distanceFromLast != 0) {
                        this.setYawTarget(this.nextWP.yawAtLast + getDelta(this.nextWP.yawAtLast, this.nextWP.requiredYaw) * (1 - (dTotal / this.nextWP.distanceFromLast)));
                    } else {
                        this.setYawTarget(this.nextWP.requiredYaw);
                    }
                }
                // If roll not required, auto determine by yaw delta
                if (!this.nextWP.strictRoll) {
                    float yawToTarget = getDelta(newYaw, this.dataManager.get(YAW_TARGET));
                    if (-yawToTarget > 0) {
                        targetRoll = Math.min(-yawToTarget / 5, 10);
                    } else if (-yawToTarget < 0) {
                        targetRoll = Math.max(-yawToTarget / 5, -10);
                    } else {
                        targetRoll = 0;
                    }
                    this.setRollTarget(targetRoll);
                } else {
                    this.setRollTarget(this.nextWP.requiredRoll);
                }

                if (abs(d0) < 1 && abs(d1) < 1 && abs(d2) < 1) {
                    currentPath.next();
                }
            }
        }

        // -------- Blade angle maths --------
        this.lastBladeAngle = this.bladeAngle;
        this.bladeAngle += 0.05F * getRotorSpeed() * ((float) Math.PI / 30F);
        if (this.bladeAngle >= 2 * Math.PI) {
            this.bladeAngle -= (2F * (float) Math.PI);
            this.lastBladeAngle -= (2F * (float) Math.PI);
        }

        // -------- Yaw angle maths --------
        //this.lastYaw = getYaw();
        //if (!world.isRemote) {
        this.lastYaw = this.newYaw;
        //this.targetYaw = -((float) MathHelper.atan2(this.motionX, this.motionZ)) * (180F / (float) Math.PI);
        this.targetYaw = dataManager.get(YAW_TARGET);
        if (nearestPlayer != null && !world.isRemote && ticksExisted % 2 == 0) {
            //nearestPlayer.sendMessage(new TextComponentString("Raw values: targetYaw: " + targetYaw + ", lastYaw: " + lastYaw));
            //nearestPlayer.sendMessage(new TextComponentString("Raw values: motionX: " + this.motionX + ", motionZ: " + motionZ));
            //nearestPlayer.sendMessage(new TextComponentString("Pos values: posX: " + this.posX + ", posZ: " + posZ));
        }
        //}

        yawDelta = getDelta(lastYaw, targetYaw);
        //if (nearestPlayer != null) {nearestPlayer.sendMessage(new TextComponentString("unclamped delta: " + delta));}



        // clamp yaw delta
        if (Math.abs(yawDelta) <= yawSpeed) {
            newYaw = targetYaw;
        } else if (yawDelta > yawSpeed) {
            newYaw = lastYaw + yawSpeed;
            yawDelta = yawSpeed;
        } else if (yawDelta < yawSpeed){
            newYaw = lastYaw - yawSpeed;
            yawDelta = -yawSpeed;
        }

        // wrap yaw
        if (newYaw >= 180) {
            newYaw -= 360;
            lastYaw -= 360;
        } else if (newYaw < -180 ) {
            newYaw += 360;
            lastYaw += 360;
        }

        // -------- Roll angle maths --------

        this.lastRoll = this.newRoll;
        targetRoll = this.dataManager.get(ROLL_TARGET);
        this.rollDelta = targetRoll - newRoll;

        //if (nearestPlayer != null && world.isRemote && ticksExisted % 3 == 0) {nearestPlayer.sendMessage(new TextComponentString("Raw values: targetRoll: " + targetRoll + ", lastRoll: " + lastRoll));}

        if (Math.abs(rollDelta) <= rollSpeed) {
            newRoll = targetRoll;
        } else if (rollDelta > rollSpeed) {
            newRoll = lastRoll + rollSpeed;
            rollDelta = rollSpeed;
        } else if (rollDelta < rollSpeed){
            newRoll = lastRoll - rollSpeed;
            rollDelta = -rollSpeed;
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
        return this.lastYaw + (this.yawDelta) * partialTicks;
    }
    public float getRenderRoll(float partialTicks) {
        return this.lastRoll + (this.rollDelta) * partialTicks;
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
        this.dataManager.register(YAW_TARGET, 0.0F);
        this.dataManager.register(ROLL_TARGET, 0.0F);

        if (!world.isRemote) {
            // test flight path
//        this.currentPath = new FlightPath();
//        this.currentPath.addWaypoint(new Waypoint(30, 20, 30));
//        this.currentPath.addWaypoint(new Waypoint(30, 20, -30));
//        this.currentPath.addWaypoint(new Waypoint(-30, 20, -30));
//        this.currentPath.addWaypoint(new Waypoint(-30, 20, 30));
//        this.currentPath.addWaypoint(new Waypoint(30, 20, 30));
            // diagonal flight path
//        this.currentPath = new FlightPath();
//        this.currentPath.addWaypoint(new Waypoint(30, 20, 0));
//        this.currentPath.addWaypoint(new Waypoint(0, 20, 30));
//        this.currentPath.addWaypoint(new Waypoint(-30, 20, 0));
//        this.currentPath.addWaypoint(new Waypoint(0, 20, -30));
//        this.currentPath.addWaypoint(new Waypoint(30, 20, 0));
            // test circle path
//            this.currentPath = new FlightPath();
//            this.currentPath.addWaypoint(new Waypoint(30, 20, 0).curveStarter(0));
//            this.currentPath.addWaypoint(new Waypoint(21, 20, 21).requireRoll(-20).requireYaw(45));
//            this.currentPath.addWaypoint(new Waypoint(0, 20, 30).requireRoll(-20).requireYaw(90));
//            this.currentPath.addWaypoint(new Waypoint(-21, 20, 21).requireRoll(-20).requireYaw(135));
//            this.currentPath.addWaypoint(new Waypoint(-30, 20, 0).requireRoll(-20).requireYaw(-180));
//            this.currentPath.addWaypoint(new Waypoint(-21, 20, -21).requireRoll(-20).requireYaw(-135));
//            this.currentPath.addWaypoint(new Waypoint(0, 20, -30).requireRoll(-20).requireYaw(-90));
//            this.currentPath.addWaypoint(new Waypoint(21, 20, -21).requireRoll(-20).requireYaw(-45));
//            this.currentPath.addWaypoint(new Waypoint(30, 20, 0).requireRoll(-20).requireYaw(0));
//            this.currentPath.addWaypoint(new Waypoint(30, 20, 30));
            // flick testing
//        this.currentPath = new FlightPath();
//        this.currentPath.addWaypoint(new Waypoint(0, 20, 0));
//        this.currentPath.addWaypoint(new Waypoint(20, 20, -1));
        }
    }

    protected void initEntityAI() {
        //this.tasks.addTask(1, new HelicopterAI.AILandAtCoords(this));
        //this.tasks.addTask(2, new HelicopterAI.AIRandomFly(this));
        //this.tasks.addTask(3, new HelicopterAI.AILookAround(this));

        this.tasks.addTask(1, new AIFollowPlayer(this, 40, 40));
        //this.tasks.addTask(1, new AIFollowTestPath(this));
    }

    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.7);
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

    public void onDeathUpdate() {
        ++ this.deathTime;

        if (crashDirection == null) {
            crashDirection = new Vec2f(rand.nextFloat() - 0.5F, rand.nextFloat() - 0.5F);
        }

        if (this.deathTime == 60 || !this.isNotColliding() || this.onGround) {
            this.world.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 4.0F, false);
            this.setDead();
        }
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
            // Was 0.91F
            f = 0.95F;

            if (this.onGround)
            {
                BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                IBlockState underState = this.world.getBlockState(underPos);
                f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
            }

            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);


            if (getRotorSpeed() != 200) {
                this.motionY -= 0.02D;
            }

            if (deathTime > 0) {
                this.motionY -= 0.03D;
            } else {
                this.motionX *= (double)f;
                this.motionY *= (double)f;
                this.motionZ *= (double)f;
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

    public void onLivingUpdate() {
        if (this.newPosRotationIncrements > 0 && !this.canPassengerSteer())
        {
            double d0 = this.posX + (this.interpTargetX - this.posX) / (double)this.newPosRotationIncrements;
            double d1 = this.posY + (this.interpTargetY - this.posY) / (double)this.newPosRotationIncrements;
            double d2 = this.posZ + (this.interpTargetZ - this.posZ) / (double)this.newPosRotationIncrements;
            double d3 = MathHelper.wrapDegrees(this.interpTargetYaw - (double)this.rotationYaw);
            this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.newPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.interpTargetPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.setPosition(d0, d1, d2);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        else if (!this.isServerWorld())
        {
            this.motionX *= 0.98D;
            this.motionY *= 0.98D;
            this.motionZ *= 0.98D;
        }
        // values decreased from 0.003
        if (Math.abs(this.motionX) < 0.0003D)
        {
            this.motionX = 0.0D;
        }

        if (Math.abs(this.motionY) < 0.0003D)
        {
            this.motionY = 0.0D;
        }

        if (Math.abs(this.motionZ) < 0.0003D)
        {
            this.motionZ = 0.0D;
        }

        this.world.profiler.startSection("ai");

        if (this.isMovementBlocked())
        {
            this.isJumping = false;
            this.moveStrafing = 0.0F;
            this.moveForward = 0.0F;
            this.randomYawVelocity = 0.0F;
        }
        else if (this.isServerWorld())
        {
            this.world.profiler.startSection("newAi");
            this.updateEntityActionState();
            this.world.profiler.endSection();
        }

        this.world.profiler.endSection();
        this.world.profiler.startSection("jump");
        this.world.profiler.endSection();
        this.world.profiler.startSection("travel");
        this.moveStrafing *= 0.98F;
        this.moveForward *= 0.98F;
        this.randomYawVelocity *= 0.9F;
        this.travel(this.moveStrafing, this.moveVertical, this.moveForward);
        this.world.profiler.endSection();
        this.world.profiler.startSection("push");
        this.collideWithNearbyEntities();
        this.world.profiler.endSection();
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
