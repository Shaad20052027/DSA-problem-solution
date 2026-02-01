class Pair {
    int dist, row, col;
    Pair(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if (n == 1) return 1;

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)1e9);
        }

        Queue<Pair> queue = new LinkedList<>();
        dist[0][0] = 1;
        queue.add(new Pair(1, 0, 0));

        int[] drow = {-1,-1,-1,0,0,1,1,1};
        int[] dcol = {-1,0,1,-1,1,-1,0,1};

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nr = cur.row + drow[i];
                int nc = cur.col + dcol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 &&
                    cur.dist + 1 < dist[nr][nc]) {

                    dist[nr][nc] = cur.dist + 1;

                    if (nr == n-1 && nc == n-1) {
                        return dist[nr][nc];
                    }

                    queue.add(new Pair(dist[nr][nc], nr, nc));
                }
            }
        }
        return -1;
    }
}
