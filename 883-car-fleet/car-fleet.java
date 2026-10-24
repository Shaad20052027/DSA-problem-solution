import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // closest to the target first
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double fleetTime = 0;

        for (int[] car : cars) {
            double time = (double) (target - car[0]) / car[1];

            if (time > fleetTime) {   // can't catch the fleet ahead
                fleets++;
                fleetTime = time;
            }
            // else: joins the fleet ahead, fleetTime stays the same
        }

        return fleets;
    }
}