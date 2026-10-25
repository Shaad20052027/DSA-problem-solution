class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : stones) {
            pq.offer(num);
        }
        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if (stone1 != stone2) {
                pq.offer(stone1 - stone2); // stone1 >= stone2 with a max-heap
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}