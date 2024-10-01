package net.engineerofchaos.entity.ai;

import net.engineerofchaos.entity.EntityBigHeli;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.Objects;
import java.util.Random;

public class HelicopterAI {

    public static class AILandAtCoords extends EntityAIBase {
        private final EntityBigHeli parentEntity;

        public AILandAtCoords(EntityBigHeli heli) {
            this.parentEntity = heli;
            this.setMutexBits(1);
        }

        @Override
        public boolean shouldExecute() {
            return parentEntity.getCurrentAction() == 1;
//            EntityPlayer nearestPlayer = this.parentEntity.world.<EntityPlayer>getClosestPlayerToEntity(parentEntity, 100);
//
//            if (nearestPlayer != null) {
//                return nearestPlayer.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.STICK;
//            } else {
//                return false;
//            }
        }

        public void startExecuting() {
            EntityPlayer nearestPlayer = this.parentEntity.world.<EntityPlayer>getClosestPlayerToEntity(parentEntity, 110);
            parentEntity.setLandingLocation(nearestPlayer.getPosition().add(10, 0, 0));
        }

        @Override
        public boolean shouldContinueExecuting() {
            return this.shouldExecute();
        }

        @Override
        public void updateTask() {
            if (parentEntity.onGround) { parentEntity.setAction(2); }

            EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();
            BlockPos landingLocation = parentEntity.getLandingLocation();

            int dx = parentEntity.getPosition().getX() - landingLocation.getX();
            int dy = parentEntity.getPosition().getY() - landingLocation.getY();
            int dz = parentEntity.getPosition().getZ() - landingLocation.getZ();

            int horizontalDistanceSq = dx * dx + dz * dz;

            if (horizontalDistanceSq > 16) {
                BlockPos hoverLocation = landingLocation.add(0, 10, 0);
                entitymovehelper.setMoveTo(hoverLocation.getX(), hoverLocation.getY(), hoverLocation.getZ(), 1);
            } else {
                entitymovehelper.action = EntityMoveHelper.Action.WAIT;
                parentEntity.moveVertical = -1F;
            }
        }
    }

    public static class AILookAround extends EntityAIBase
    {
        private final EntityBigHeli parentEntity;

        public AILookAround(EntityBigHeli heli)
        {
            this.parentEntity = heli;
            this.setMutexBits(2);
        }

        public boolean shouldExecute()
        {
            return true;
        }

        public void updateTask()
        {
            if (parentEntity.getCurrentAction() == 0) {
                if (this.parentEntity.getAttackTarget() == null) {
                    this.parentEntity.rotationYaw = -((float) MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * (180F / (float) Math.PI);
                    this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                } else {
                    EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
                    double d0 = 64.0D;

                    if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D) {
                        double d1 = entitylivingbase.posX - this.parentEntity.posX;
                        double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
                        this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
                        this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                    }
                }
            } else {
                this.parentEntity.rotationYaw = 0;
                this.parentEntity.renderYawOffset = 0;
            }
        }
    }

    public static class AIRandomFly extends EntityAIBase
    {
        private final EntityBigHeli parentEntity;

        public AIRandomFly(EntityBigHeli heli)
        {
            this.parentEntity = heli;
            this.setMutexBits(1);
        }

        public boolean shouldExecute()
        {
            if (this.parentEntity.getCurrentAction() != 0) { return false; }

            EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();

            if (!entitymovehelper.isUpdating())
            {
                return true;
            }
            else
            {
                double d0 = entitymovehelper.getX() - this.parentEntity.posX;
                double d1 = entitymovehelper.getY() - this.parentEntity.posY;
                double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        public boolean shouldContinueExecuting()
        {
            return false;
        }

        public void startExecuting()
        {
            Random random = this.parentEntity.getRNG();
            double d0 = this.parentEntity.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.parentEntity.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.parentEntity.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
        }
    }

    public static class HeliMoveHelper extends EntityMoveHelper
    {
        private final EntityLiving parentEntity;
        private int courseChangeCooldown;

        public HeliMoveHelper(EntityLiving heli)
        {
            super(heli);
            this.parentEntity = heli;
        }

        public void onUpdateMoveHelper()
        {
            if (this.action == EntityMoveHelper.Action.MOVE_TO)
            {
                double d0 = this.posX - this.parentEntity.posX;
                double d1 = this.posY - this.parentEntity.posY;
                double d2 = this.posZ - this.parentEntity.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                if (this.courseChangeCooldown-- <= 0)
                {
                    this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
                    d3 = (double) MathHelper.sqrt(d3);

                    if (this.isNotColliding(this.posX, this.posY, this.posZ, d3))
                    {
                        this.parentEntity.motionX += d0 / d3 * 0.1D;
                        this.parentEntity.motionY += d1 / d3 * 0.1D;
                        this.parentEntity.motionZ += d2 / d3 * 0.1D;
                    }
                    else
                    {
                        this.action = EntityMoveHelper.Action.WAIT;
                    }
                }
            }
        }

        private boolean isNotColliding(double x, double y, double z, double p_179926_7_)
        {
            double d0 = (x - this.parentEntity.posX) / p_179926_7_;
            double d1 = (y - this.parentEntity.posY) / p_179926_7_;
            double d2 = (z - this.parentEntity.posZ) / p_179926_7_;
            AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();

            for (int i = 1; (double)i < p_179926_7_; ++i)
            {
                axisalignedbb = axisalignedbb.offset(d0, d1, d2);

                if (!this.parentEntity.world.getCollisionBoxes(this.parentEntity, axisalignedbb).isEmpty())
                {
                    return false;
                }
            }

            return true;
        }
    }
}
