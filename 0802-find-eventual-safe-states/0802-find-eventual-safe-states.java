class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int V = graph.length;
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int u = 0; u < V; u++){
            for(int v : graph[u]){
                adj.get(v).add(u);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.add(it);
                }
            }
        }
        Collections.sort(topo);
        return topo;
    }
}