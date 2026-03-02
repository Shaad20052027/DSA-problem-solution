class Pair {
    long dist;
    int node;
    Pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : roads) {
            int u = e[0], v = e[1];
            long wt = e[2];
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        int mod = (int)1e9 + 7;

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long dis = curr.dist;
            int node = curr.node;

            // 🔥 skip outdated entries
            if (dis > dist[node]) continue;

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                long edgeWt = it.dist;

                if (dis + edgeWt < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWt;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
                else if (dis + edgeWt == dist[adjNode]) {
                    ways[adjNode] =
                        (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}