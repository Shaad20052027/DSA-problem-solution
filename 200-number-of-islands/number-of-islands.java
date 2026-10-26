class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    bfs(i, j, q, grid, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void bfs(int row, int col, Queue<Pair> q, char[][] grid, int[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};
        q.add(new Pair(row, col));
        vis[row][col] = 1;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for(int i = 0; i < 4; i++){
                int nrow = drow[i] + r;
                int ncol = dcol[i] + c;
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
}