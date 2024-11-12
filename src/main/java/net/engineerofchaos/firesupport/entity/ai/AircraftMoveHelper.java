package net.engineerofchaos.firesupport.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;

public class AircraftMoveHelper extends EntityMoveHelper {
    private final EntityLiving parentEntity;
    public boolean stopping = false;

    public AircraftMoveHelper(EntityLiving heli)
    {
        super(heli);
        this.parentEntity = heli;
    }

//    public void setMoveToStop(double x, double y, double z, double speedIn) {
//        this.setMoveTo(x, y, z, speedIn);
//        stopping = true;
//    }

    public void onUpdateMoveHelper()
    {
        if (this.action == EntityMoveHelper.Action.MOVE_TO)
        {

            double dx = this.posX - this.parentEntity.posX;
            double dy = this.posY - this.parentEntity.posY;
            double dz = this.posZ - this.parentEntity.posZ;
            double dtotal = MathHelper.sqrt(dx * dx + dy * dy + dz * dz);

//            if (dtotal < 1)
//            {
//                this.entity.setMoveForward(0.0F);
//                this.action = Action.WAIT;
//                return;
//            }

            // Speed of 0.2 is ~5.5 m/s 0r 1.1 m/t
            double totalSpeed = this.speed * this.parentEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();

            if (this.isNotColliding(this.posX, this.posY, this.posZ, dtotal))
            //if (true)
            {
                if (dtotal <= 0.5) {
                    if (stopping) {
                        this.parentEntity.move(MoverType.SELF, this.posX, this.posY, this.posZ);
                        this.parentEntity.motionX = 0;
                        this.parentEntity.motionY = 0;
                        this.parentEntity.motionZ = 0;
                    }
                    this.action = Action.WAIT;
                } else {
                    this.parentEntity.motionX += dx / dtotal * totalSpeed * 0.1;
                    this.parentEntity.motionY += dy / dtotal * totalSpeed * 0.1;
                    this.parentEntity.motionZ += dz / dtotal * totalSpeed * 0.1;
                }
            }
            else
            {
                this.action = EntityMoveHelper.Action.WAIT;
            }
        }
    }

    private boolean isNotColliding(double x, double y, double z, double dtotal)
    {
        double d0 = (x - this.parentEntity.posX) / dtotal;
        double d1 = (y - this.parentEntity.posY) / dtotal;
        double d2 = (z - this.parentEntity.posZ) / dtotal;
        AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();

        for (int i = 1; (double)i < dtotal; ++i)
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
