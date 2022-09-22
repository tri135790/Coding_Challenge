package leetcode75.level1.twopointers;

import java.util.Arrays;

public class PairWithTargetSum {

    public static int[] search(int[] nums, int target) {
        Arrays.sort(nums);
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            int sum = nums[head] + nums[tail];
            if (sum == target) {
                return new int[] {head, tail};
            }
            if (sum > target) {
                tail--;
            } else {
                head++;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 3, 2, 4 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
