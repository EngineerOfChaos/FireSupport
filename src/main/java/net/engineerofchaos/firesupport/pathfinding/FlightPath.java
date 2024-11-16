package net.engineerofchaos.firesupport.pathfinding;

import scala.Int;

import java.util.ArrayList;
import java.util.List;

public class FlightPath {
    private Waypoint[] waypoints = new Waypoint[128];
    public int counter = 0;

    public void addWaypoint(Waypoint waypoint) {
        int i = 0;
        while (waypoints[i] != null) {
            ++i;
        }
        if (i >= 1) {
            int dx = waypoint.x - waypoints[i-1].x;
            int dy = waypoint.y - waypoints[i-1].y;
            int dz = waypoint.z - waypoints[i-1].z;
            waypoint.distanceFromLast = (float) Math.sqrt((dx*dx) + (dy*dy) + (dz*dz));
            waypoint.yawAtLast = waypoints[i-1].requiredYaw;
        }
        waypoints[i] = waypoint;
    }

    public Waypoint getTarget() {
        return waypoints[counter];
    }

    public void next() {
        ++counter;
    }

    public List<Integer> outputWaypoints() {
        List<Integer> out = new ArrayList<Integer>();
        int i = 0;
        while (waypoints[i] != null) {
            out.add(waypoints[i].x);
            out.add(waypoints[i].y);
            out.add(waypoints[i].z);
            ++i;
        }
        return out;
    }

}
