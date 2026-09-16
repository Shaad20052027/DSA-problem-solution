class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    maxArea = Math.max(maxArea, bfs(i, j, vis, grid));
                }
            }
        }
        return maxArea;
    }
    int bfs(int row, int col, int[][] vis, int[][] grid){
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        int area = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            area++;
            for(int i = 0; i < 4; i++){
                int nrow = drow[i] + r;
                int ncol = dcol[i] + c;
                if(nrow >= 0 && ncol >= 0 && ncol < m && nrow < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
        return area;
    }
}