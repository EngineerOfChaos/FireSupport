package net.engineerofchaos.firesupport.pathfinding;

import javax.annotation.Nullable;

public class Waypoint {
    public final int x;
    public final int y;
    public final int z;
    public boolean strictYaw = false;
    public double requiredYaw;
    public boolean strictRoll = false;
    public double requiredRoll;

    public Waypoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public void requireWaypointYaw(double yaw) {
        this.requiredYaw = yaw;
        this.strictYaw = true;
    }

    public void requireWaypointRoll(double roll) {
        this.requiredRoll = roll;
        this.strictRoll = true;
    }
}
