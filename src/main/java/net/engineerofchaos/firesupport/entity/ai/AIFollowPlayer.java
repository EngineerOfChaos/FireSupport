package net.engineerofchaos.firesupport.entity.ai;

import net.engineerofchaos.firesupport.entity.EntityBigHeli;
import net.engineerofchaos.firesupport.pathfinding.FlightPath;
import net.engineerofchaos.firesupport.pathfinding.Waypoint;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class AIFollowPlayer extends EntityAIBase {

    private final EntityBigHeli parentEntity;
    protected int movePeriod;
    protected int diameter;
    World world;
    EntityPlayer followTarget;

    public AIFollowPlayer(EntityBigHeli heli, int movePeriod, int diameter) {
        this.movePeriod = movePeriod;
        this.diameter = diameter;
        this.parentEntity = heli;
        //this.world = heli.getServer().getWorld(heli.dimension);
        this.world = heli.getEntityWorld();
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        // Must be flying
        if (this.parentEntity.getCurrentAction() != 0) { return false; }

        if (this.world == null) { return false; }

        Waypoint target = this.parentEntity.nextWP;
        if (target != null) {
            return false;
        }

        if (this.parentEntity.getRNG().nextInt(this.movePeriod) == 0) {
            EntityPlayer nearestPlayer = this.world.<EntityPlayer>getClosestPlayerToEntity(this.parentEntity, -1);
            if (nearestPlayer != null) {
                this.followTarget = nearestPlayer;
                return true;
            }
        }
        return false;
    }
    public boolean shouldContinueExecuting()
    {
        return this.parentEntity.nextWP != null;
    }

    public void startExecuting() {
        FlightPath path = new FlightPath();
        int x = this.followTarget.getPosition().getX() + this.followTarget.getRNG().nextInt(this.diameter) - this.diameter/2;
        int z = this.followTarget.getPosition().getZ() + this.followTarget.getRNG().nextInt(this.diameter) - this.diameter/2;
        path.addWaypoint(new Waypoint(x, 20, z));
        this.parentEntity.currentPath = path;
    }
}
