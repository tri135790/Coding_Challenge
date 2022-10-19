package leetcode75.level1.twoheaps;

import java.util.PriorityQueue;

public class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];


        for (int i = 0; i < nums.length; i++) {
            insertNum(nums[i], maxHeap, minHeap);

            if (i - k + 1 >= 0) {
                result [i-k+1] = findMedian(maxHeap, minHeap);
                removeNum(nums[i-k + 1], maxHeap, minHeap);
            }

        }

        return result;
    }

    private void insertNum(int num, PriorityQueue<Integer> maxHeap,
                           PriorityQueue<Integer> minHeap) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    private void removeNum(int num, PriorityQueue<Integer> maxHeap,
                           PriorityQueue<Integer> minHeap) {
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }

        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    private double findMedian(PriorityQueue<Integer> maxHeap,
                              PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { -2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648},  3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
