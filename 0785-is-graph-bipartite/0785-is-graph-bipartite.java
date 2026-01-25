class Solution {
    public boolean check(int start, int V, int[][] graph ,int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            for(int it : graph[node]){
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    queue.add(it);
                }
                else if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for(int i = 0; i < V; i++){
            color[i] = -1;
        }
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(check(i,V,graph,color) == false){
                    return false;
                }
            }
        }
        return true;
    }
}