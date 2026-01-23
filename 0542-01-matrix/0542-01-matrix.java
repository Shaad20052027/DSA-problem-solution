class Pair{
    int first;
    int second;
    int third;
    Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            int step = queue.peek().third;
            queue.remove();
            dis[row][col] = step;
            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    queue.add(new Pair(nrow,ncol,step+1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return dis;
    }
}