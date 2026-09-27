class Tuple{
    int distance;
    int row;
    int col;
    Tuple(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row : dist){
            Arrays.fill(row, (int)(1e9));
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Tuple(0,0,0));
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!pq.isEmpty()){
            int diff = pq.peek().distance;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.poll();
            if(r == n - 1 && c == m - 1){
                return diff;
            }
            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && ncol < m && ncol >= 0 && nrow < n){
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nrow][ncol]), diff);
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Tuple(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}