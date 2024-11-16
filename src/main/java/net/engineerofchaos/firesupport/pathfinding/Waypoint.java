package net.engineerofchaos.firesupport.pathfinding;

import javax.annotation.Nullable;

public class Waypoint {
    public final int x;
    public final int y;
    public final int z;
    public boolean strictYaw = false;
    public float requiredYaw;
    public boolean strictRoll = false;
    public float requiredRoll;
    public float distanceFromLast;
    public float yawAtLast;

    public Waypoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public Waypoint(int x, int y, int z, float roll) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.strictRoll = true;
        this.requiredRoll = roll;
    }

    public Waypoint curveStarter(float yaw) {
        this.requiredYaw = yaw;
        this.strictYaw = false;
        return this;
    }

    public Waypoint requireYaw(float yaw) {
        this.requiredYaw = yaw;
        this.strictYaw = true;
        return this;
    }

    public Waypoint requireRoll(float roll) {
        this.requiredRoll = roll;
        this.strictRoll = true;
        return this;
    }
}
