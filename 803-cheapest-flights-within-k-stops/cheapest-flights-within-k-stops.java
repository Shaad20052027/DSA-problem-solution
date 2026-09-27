class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple{
    int first;
    int second;
    int third;
    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : flights){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new Pair(v,wt));
        }
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0,src,0));
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = (int)(1e9);
        }
        while(!queue.isEmpty()){
            Tuple crr = queue.peek();
            queue.remove();
            int stops = crr.first;
            int node = crr.second;
            int cost = crr.third;
            if(stops > k){
                continue;
            }
            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int ediff = it.second;
                if(cost + ediff < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + ediff;
                    queue.add(new Tuple(stops + 1, adjNode, cost + ediff));
                }
            }
        }
        if(dist[dst] == (int)(1e9)){
            return -1;
        }
        return dist[dst];
    }
}