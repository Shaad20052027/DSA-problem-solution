class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> squareDis(b) - squareDis(a));

        for(int[] p  :points){
            pq.add(p);
            while(pq.size() > k){
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
    public int squareDis(int[] p){
        return p[0] * p[0] + p[1] * p[1];
    }
}