
class Solution {
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] atlanticvis = new boolean[n][m];
        boolean[][] pacificcvis = new boolean[n][m];

        // Pacific: top and left borders
        for (int j = 0; j < m; j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pacificcvis);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacificcvis);
        }

        // Atlantic: bottom and right borders
        for (int j = 0; j < m; j++) {
            dfs(heights, n - 1, j, Integer.MIN_VALUE, atlanticvis);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, i, m - 1, Integer.MIN_VALUE, atlanticvis);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (atlanticvis[i][j] && pacificcvis[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }

        return res;
    }

    public void dfs(int[][] heights, int i, int j,
                    int prevval, boolean[][] visited) {

        if (i < 0 || i >= heights.length ||
            j < 0 || j >= heights[0].length) {
            return;
        }

        if (heights[i][j] < prevval || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        for (int r = 0; r < 4; r++) {
            int nrow = i + drow[r];
            int ncol = j + dcol[r];

            dfs(heights, nrow, ncol, heights[i][j], visited);
        }
    }
}
