class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count++;
                dfs(i,isConnected,vis);
            }
        }
        return count;
    }

    public void dfs(int node, int[][] adj, boolean[] vis){
        vis[node] = true;
        for(int i = 0; i < vis.length; i++){
            if(adj[node][i] == 1 && !vis[i]){
                dfs(i,adj,vis);
            }
        }
    }
}