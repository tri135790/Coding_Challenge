package leetcode75.level1;

public class HouseRobber2 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        return Math.max(robHelper(nums,0, nums.length -2), robHelper(nums, 1, nums.length -1));
    }

    private int robHelper(int[] nums, int start, int end) {
        if (start == end) return 0;
        int[] dp = new int [nums.length];
        dp[0] = 0;
        dp[1] = nums[start];

        for (int i = 1; i < nums.length - 1; i ++) {
            start = start + 1;
            dp[i + 1] = Math.max(dp[i], nums[start] + dp[i-1]);
        }
        return dp[nums.length - 1];
    }
}
