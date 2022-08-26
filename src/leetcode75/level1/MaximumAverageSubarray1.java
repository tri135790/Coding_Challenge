package leetcode75.level1;

public class MaximumAverageSubarray1 {

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        if (nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length; i++) {

            if (i + 1 > k) {
                sum = sum + nums[i] - nums[i - k];
                maxSum = Math.max(maxSum, sum);
            } else {
                sum += nums[i];
                maxSum = sum;
            }

        }
        return (double) maxSum / k;

    }

}
