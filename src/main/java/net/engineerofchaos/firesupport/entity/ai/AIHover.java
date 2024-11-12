package net.engineerofchaos.firesupport.entity.ai;

import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.pathfinding.Waypoint;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.util.math.MathHelper;

public class AIHover extends EntityAIBase {

    private final EntityBigHeli parentEntity;

    public AIHover(EntityBigHeli heli) {
        this.parentEntity = heli;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        // Must be flying
        if (this.parentEntity.getCurrentAction() != 0) { return false; }

        EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();

//        if (!entitymovehelper.isUpdating())
//        {
//            // If move helper is waiting, execute
//            return true;
//        }

        Waypoint target = this.parentEntity.nextWP;
        if (target == null) {
            return false;
        }

        double d0 = target.x - this.parentEntity.posX;
        double d1 = target.y - this.parentEntity.posY;
        double d2 = target.z - this.parentEntity.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;

        // If we are more than 1m from target, execute
        return d3 > 3.0D;
    }
    public boolean shouldContinueExecuting()
    {
        return false;
    }

    public void startExecuting() {
        Waypoint target = this.parentEntity.nextWP;
        if (target != null) {
            this.parentEntity.getMoveHelper().setMoveTo(target.x, target.y, target.z, 1);
            double d0 = target.x - this.parentEntity.posX;
            double d2 = target.z - this.parentEntity.posZ;
            this.parentEntity.setYawTarget(-((float) MathHelper.atan2(d0, d2)) * (180F / (float) Math.PI));
        }

    }
}
