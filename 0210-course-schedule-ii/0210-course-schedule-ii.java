class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : prerequisites){
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int[] topo = new int[numCourses];
        int i = 0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            topo[i++] = node;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.add(it);
                }
            }
        }
        if(i == numCourses){
            return topo;
        }
        int[] ans = {};
        return ans;
    }
}