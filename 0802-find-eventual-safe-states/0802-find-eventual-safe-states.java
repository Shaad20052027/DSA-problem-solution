class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        // Correct graph construction
        for(int i = 0; i < n; i++){
            for(int v : graph[i]){
                adj.get(i).add(v);
            }
        }

        int[] vis = new int[n];
        int[] pathvis = new int[n];
        int[] check = new int[n];

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, vis, pathvis, adj, check);
            }
        }

        List<Integer> safe = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(check[i] == 1){
                safe.add(i);
            }
        }

        return safe;
    }

    public boolean dfs(int node, int[] vis, int[] pathvis, 
                       ArrayList<ArrayList<Integer>> adj, int[] check){

        vis[node] = 1;
        pathvis[node] = 1;

        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, vis, pathvis, adj, check))
                    return true;
            }
            else if(pathvis[it] == 1){
                return true;
            }
        }

        check[node] = 1;
        pathvis[node] = 0;
        return false;
    }
}