package leetcode75.level1.dynamicprogramming;

public class JumpGame {

    public boolean canJumpBottomUp(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length && end <= start + nums[start]; end++) {
                if (!dp[end]) {
                    dp[end] = dp[start];
                }
            }
        }
        return dp[nums.length- 1];

    }

    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return recursive(dp, nums, 0);
    }

    private boolean recursive(Boolean[] dp, int[] nums, int current) {
        if (current == nums.length - 1) {
            return true;
        }

        if (current > nums.length - 1) {
            return false;
        }
        if (dp[current] == null) {
            boolean result = false;
            for (int i = 1; i <= nums[current]; i++) {
                if (recursive(dp, nums, current + i)) {
                    result = true;
                    break;
                }
            }
            dp[current] = result;
        }

        return dp[current];
    }
}
