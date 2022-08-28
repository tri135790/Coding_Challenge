package leetcode75.level1;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> qi = new LinkedList<>();

        for (int i = 0; i < k; i++) {

            while (!qi.isEmpty() && nums[qi.peekLast()] <= nums[i] ) {
                qi.removeLast();
            }

            qi.addLast(i);
        }

        for (int i = k; i < nums.length; i++) {
            result[i-k] = nums[qi.peek()];

            while (!qi.isEmpty() && qi.peek() <= i-k) {
                qi.removeFirst();
            }

            while (!qi.isEmpty() && nums[qi.peekLast()] <= nums[i] ) {
                qi.removeLast();
            }
            qi.addLast(i);
        }

        result[nums.length - k] = nums[qi.peek()];
        return result;

    }
}
