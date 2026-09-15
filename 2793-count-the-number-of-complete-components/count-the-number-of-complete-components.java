class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] vis = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                int[] nodes = {0};
                int[] edgeCount = {0};
                dfs(i, vis, adj, nodes, edgeCount);

                // edgeCount counted each edge twice (once from each endpoint)
                int actualEdges = edgeCount[0] / 2;
                int requiredEdges = nodes[0] * (nodes[0] - 1) / 2;

                if (actualEdges == requiredEdges) {
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] nodes, int[] edgeCount) {
        vis[node] = 1;
        nodes[0]++;
        edgeCount[0] += adj.get(node).size();

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, nodes, edgeCount);
            }
        }
    }
}