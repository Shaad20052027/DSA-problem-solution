
import java.util.*;

class Solution {
    int mod = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][2];

        for (int[][] plane : dp) {
            for (int[] row : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, -1, grid, dp);
    }

    int solve(int i, int j, int dir, int[][] grid, int[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Memoization
        if (dir != -1 && dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        int right = 0;
        int down = 0;

        if (grid[i][j] == 1) {

            // Entered mirror while moving right
            if (dir == 1) {
                down = solve(i + 1, j, 0, grid, dp);
            }

            // Entered mirror while moving down
            else if (dir == 0) {
                right = solve(i, j + 1, 1, grid, dp);
            }

        } else {

            // Empty cell: both movements possible
            right = solve(i, j + 1, 1, grid, dp);
            down = solve(i + 1, j, 0, grid, dp);
        }

        int ans = (right + down) % mod;

        // Store only valid direction states
        if (dir != -1) {
            dp[i][j][dir] = ans;
        }

        return ans;
    }
}
