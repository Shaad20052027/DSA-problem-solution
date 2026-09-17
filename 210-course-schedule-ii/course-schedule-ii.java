class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : prerequisites) {
            // e = [a, b]: a needs b first -> edge b -> a
            adj.get(e[1]).add(e[0]);
        }

        int[] vis = new int[numCourses]; // 0 = unvisited, 1 = in path, 2 = done
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (!dfs(i, adj, vis, st)) {
                    return new int[0]; // cycle detected
                }
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;
    }

    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 1) return false; // cycle
            if (vis[it] == 0 && !dfs(it, adj, vis, st)) return false;
        }
        vis[node] = 2;
        st.push(node);
        return true;
    }
}