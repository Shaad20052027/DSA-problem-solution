class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    dfs(i,j,vis,grid,drow,dcol,n,m);
                }
            }
        }
        return cnt;
    }

    public void dfs(int ro, int co, int[][] vis,char[][] grid, int[] drow, int[] dcol,int n, int m){
        vis[ro][co] = 1;
        for(int i = 0; i < 4; i++){
            int nrow = drow[i] + ro;
            int ncol = dcol[i] + co;
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                dfs(nrow,ncol,vis,grid,drow,dcol,n,m);
            }
        }
    }
}