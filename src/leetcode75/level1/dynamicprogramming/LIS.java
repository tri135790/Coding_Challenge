package leetcode75.level1.dynamicprogramming;

public class LIS {

    public int findLISLength(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLength = 1;
        for (int i=1; i<nums.length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++)
                if (nums[i] > nums[j] && dp[i] <= dp[j] ) {
                    dp[i] = dp[j]+1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
        }
        return maxLength;
    }

    public int findLISLengthTopDown(int[] nums) {
        return recursive(nums, 0, -1);
    }

    private int recursive(int[] nums, int currentIndex, int previousIndex) {
        if(currentIndex == nums.length)
            return 0;

        // include nums[currentIndex] if it is larger than the last included number
        int c1 = 0;
        if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
            c1 = 1 + recursive(nums, currentIndex+1, currentIndex);

        // excluding the number at currentIndex
        int c2 = recursive(nums, currentIndex+1, previousIndex);

        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(lis.findLISLengthTopDown(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(lis.findLISLengthTopDown(nums));
    }
}
