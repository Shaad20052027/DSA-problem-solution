class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        int[][] ans = image;

        int incolor = image[sr][sc];

        // Important edge case
        if (incolor == color) {
            return ans;
        }

        bfs(sr, sc, image, ans, incolor, color, n, m);

        return ans;
    }

    public void bfs(int row, int col,
                    int[][] image,
                    int[][] ans,
                    int incolor,
                    int newcolor,
                    int n,
                    int m) {

        ans[row][col] = newcolor;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            Pair p = queue.poll();

            int r = p.row;
            int c = p.col;

            for (int i = 0; i < 4; i++) {

                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if (nrow >= 0 &&
                    ncol >= 0 &&
                    nrow < n &&
                    ncol < m &&
                    ans[nrow][ncol] == incolor) {

                    ans[nrow][ncol] = newcolor;

                    queue.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
}