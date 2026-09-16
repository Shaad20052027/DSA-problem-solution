class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int e : graph[i]){
                adj.get(i).add(e);
            }
        }

        int[] vis = new int[n];
        int[] pathvis = new int[n];
        int[] check = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, vis, pathvis, check, adj);
            }
        }
        ArrayList<Integer> safe = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i] == 1){
                safe.add(i);
            }
        }
        return safe;
    }
    public boolean dfs(int node, int[] vis, int[] pathvis, int[] check, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        pathvis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, vis, pathvis, check, adj)){
                    return true;
                }
            }else if(pathvis[it] == 1){
                return true;
            }
        }
        check[node] = 1;
        pathvis[node] = 0;
        return false;
    }
}