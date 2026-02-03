class Tuple{
    int distance;
    int first;
    int second;
    Tuple(int distance, int first, int second){
        this.distance = distance;
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;
        pq.add(new Tuple(0,0,0));
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(pq.size() != 0){
            Tuple it = pq.peek();
            pq.remove();
            int diff = it.distance;
            int row = it.first;
            int col = it.second;
            if(row == n -1 && col == m -1){
                return diff;
            }
            for(int i = 0 ;i < 4; i++){
                int nrow = dr[i] + row;
                int ncol = dc[i] + col;
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int neweffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]),diff);
                    if(neweffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = neweffort;
                        pq.add(new Tuple(neweffort,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}