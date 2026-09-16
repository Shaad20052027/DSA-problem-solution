class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        HashMap<Integer, Integer> areaMap = new HashMap<>();
        int islandId = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int area = bfs(i, j, grid, islandId);
                    areaMap.put(islandId, area);
                    islandId++;
                }
            }
        }

        int ans = 0;
        for(int area : areaMap.values()){
            ans = Math.max(area, ans);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> uniqueId = new HashSet<>();
                    int currentArea = 1;
                    for(int k = 0; k < 4; k++){
                        int nrow = drow[k] + i;
                        int ncol = dcol[k] + j;
                        if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m){
                            int id = grid[nrow][ncol];
                            if(id > 1 && uniqueId.add(id)){
                                currentArea += areaMap.get(id);
                            }
                        }
                    }
                    ans = Math.max(ans, currentArea);
                }
            }
        }
        return ans;

    }
    int bfs(int row, int col, int[][] grid, int islandId){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        grid[row][col] = islandId;
        int n = grid.length;
        int m = grid[0].length;
        int area = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            area++;
            for(int i = 0; i < 4; i++){
                int nrow = drow[i] + r;
                int ncol = dcol[i] + c;
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1){
                    grid[nrow][ncol] = islandId;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
        return area;
    }
}