import java.util.*;

class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        for (char[] row : grid) {
            Arrays.fill(row, '#');
        }
        Arrays.fill(grid[0], '.');      // top row
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';       // last column
        }
        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            ans[i] = new String(grid[i]);
        }
        return ans;
    }
}