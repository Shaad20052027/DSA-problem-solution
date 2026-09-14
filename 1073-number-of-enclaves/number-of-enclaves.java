class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1){
                vis[0][j] = 1;
                q.offer(new Pair(0,j));
            }
            if(grid[n - 1][j] == 1){
                vis[n - 1][j] = 1;
                q.offer(new Pair(n - 1, j));
            }
        }

        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1){
                vis[i][0] = 1;
                q.offer(new Pair(i,0));
            }
            if(grid[i][m - 1] == 1){
                vis[i][m - 1] = 1;
                q.offer(new Pair(i, m - 1));
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && ncol < m && ncol >= 0 && nrow < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}