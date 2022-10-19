package leetcode75.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : nums) {
            heap.add(i);
        }
        int result = 0;
        while (!heap.isEmpty() && k >  0) {
            result = heap.poll();
            k--;
        }

        return result;
    }
}
