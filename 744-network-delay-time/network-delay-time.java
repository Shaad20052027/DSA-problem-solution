class Pair{
    int dist;
    int node;
    Pair(int dist,int node){
        this.dist = dist;
        this.node = node;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <=n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : times){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new Pair(wt,v));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] dist = new int[n+1];
        queue.add(new Pair(0,k));
        Arrays.fill(dist,(int)(1e9));
        dist[k] = 0;
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int ds = curr.dist;
            int node = curr.node;
            for(Pair it : adj.get(node)){
                int edgeWeight = it.dist;
                int adjNode = it.node;
                if(edgeWeight + ds < dist[adjNode]){
                    dist[adjNode] = edgeWeight + ds;
                    queue.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(dist[i] == (int)(1e9)){
                return -1;
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
           max = Math.max(max, dist[i]);
        }
        return max;
    }
}