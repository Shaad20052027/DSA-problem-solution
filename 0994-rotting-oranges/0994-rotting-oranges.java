class Pair{
    int first;
    int second ;
    int tm;
    public Pair(int first, int second, int tm){
        this.first = first;
        this.second = second;
        this.tm = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       Queue<Pair> queue = new LinkedList<Pair>();
       int[][] vis = new int[n][m];
       int cntfresh = 0;
       for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(grid[i][j] == 2){
                queue.add(new Pair(i,j,0));
                vis[i][j] = 2;
            }else{
                vis[i][j] = 0;
            }

            if(grid[i][j] == 1){
                cntfresh++;
            }
        }
    }

        int tm = 0;
        int cnt = 0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!queue.isEmpty()){
            int r = queue.peek().first;
            int c = queue.peek().second;
            int t = queue.peek().tm;
            tm = Math.max(t,tm);
            queue.remove();
            for(int i = 0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    queue.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if(cnt != cntfresh){
            return -1;
        } 

        return tm;
    }
}