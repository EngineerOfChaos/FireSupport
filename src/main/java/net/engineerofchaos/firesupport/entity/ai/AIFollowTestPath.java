package net.engineerofchaos.firesupport.entity.ai;

import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.pathfinding.FlightPath;
import net.engineerofchaos.firesupport.pathfinding.Waypoint;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;

import java.util.List;

import static java.lang.Math.abs;

public class AIFollowTestPath extends EntityAIBase {

    private final EntityBigHeli parentEntity;
    private FlightPath flightPath;
    public AIFollowTestPath(EntityBigHeli heli) {
        this.parentEntity = heli;
        this.setMutexBits(1);
        //this.flightPath = this.parentEntity.currentPath;
        flightPath = new FlightPath();
        boolean cw = false;
        if (cw) {
            flightPath.addWaypoint(new Waypoint(30, 20, 30));
            flightPath.addWaypoint(new Waypoint(30, 20, -30));
            flightPath.addWaypoint(new Waypoint(-30, 20, -30));
            flightPath.addWaypoint(new Waypoint(-30, 20, 30));
            flightPath.addWaypoint(new Waypoint(30, 20, 30));
        } else {
            flightPath.addWaypoint(new Waypoint(30, 20, 30));
            flightPath.addWaypoint(new Waypoint(-30, 20, 30));
            flightPath.addWaypoint(new Waypoint(-30, 20, -30));
            flightPath.addWaypoint(new Waypoint(30, 20, -30));
            flightPath.addWaypoint(new Waypoint(30, 20, 30));
        }
    }

    @Override
    public boolean shouldExecute() {
        // Must be flying
        if (this.parentEntity.getCurrentAction() != 0) { return false; }

        // must have non-null path
        if (flightPath == null) {
            return false;
        }
        // path must not be completed
        return flightPath.getTarget() != null;
    }
    public boolean shouldContinueExecuting()
    {
        return flightPath.getTarget() != null;
    }

    public void startExecuting() {
        Waypoint target = flightPath.getTarget();
        List<Integer> dump = flightPath.outputWaypoints();
        EntityPlayer nearestPlayer = this.parentEntity.world.getClosestPlayerToEntity(parentEntity, 100);
        if (nearestPlayer != null){
            //nearestPlayer.sendMessage(new TextComponentString(dump.toString()));
            //nearestPlayer.sendMessage(new TextComponentString(target.x + ", " + target.y + ", " + target.z));
            //nearestPlayer.sendMessage(new TextComponentString("" + flightPath.counter));
        }
        if (target != null) {
            this.parentEntity.getMoveHelper().setMoveTo(target.x, target.y, target.z, 1);
            double d0 = target.x - this.parentEntity.posX;
            double d1 = target.y - this.parentEntity.posY;
            double d2 = target.z - this.parentEntity.posZ;
            if (nearestPlayer != null) {
                //nearestPlayer.sendMessage(new TextComponentString("deltas: " + d0 + ", " + d1 + ", " + d2));
            }
            this.parentEntity.setYawTarget(-((float) MathHelper.atan2(d0, d2)) * (180F / (float) Math.PI));
            if (abs(d0) < 1 && abs(d1) < 1 && abs(d2) < 1) {
                flightPath.next();
            }
        }
    }

    public void updateTask() {
        startExecuting();
    }
}
