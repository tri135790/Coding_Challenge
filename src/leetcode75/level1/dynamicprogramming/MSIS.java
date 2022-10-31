package leetcode75.level1.dynamicprogramming;

public class MSIS {

    public int findMSIS(int[] nums) {
        return recursive(nums, 0,-1, 0);
    }

    private int recursive(int[] nums, int currentIndex, int previousIndex, int sum) {
        if (currentIndex == nums.length) {
            return sum;
        }
        int c1 = sum;
        if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
            c1 = recursive(nums, currentIndex + 1, currentIndex, sum + nums[currentIndex]);
        }

        int c2 = recursive(nums, currentIndex + 1, previousIndex, sum);

        return Math.max(c1,c2);
    }

    public int findMSISBottomUp(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = nums[i];
        }

        for (int end = 1; end < nums.length; end++) {
            for (int start = 0; start <= end; start ++) {
                if (nums[end] > nums[start]) {
                    dp[end] = Math.max(dp[end], nums[end] + dp[start]);
                }
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        MSIS msis = new MSIS();
        int[] nums = {4,1,2,6,10,1,12};
        System.out.println(msis.findMSISBottomUp(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(msis.findMSISBottomUp(nums));
    }
}
