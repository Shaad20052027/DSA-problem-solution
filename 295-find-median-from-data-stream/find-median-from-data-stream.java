import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> lo; // max-heap (smaller half)
    private PriorityQueue<Integer> hi; // min-heap (larger half)

    public MedianFinder() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());          // move the largest of lo into hi
        if (hi.size() > lo.size()) {  // keep lo >= hi in size
            lo.offer(hi.poll());
        }
    }

    public double findMedian() {
        if (lo.size() > hi.size()) return lo.peek();
        return ((double) lo.peek() + hi.peek()) / 2.0;
    }
}