package leetcode75.level1.knapsack;

public class SubsetSum {

    public boolean canPartition(int[] num, int sum) {

        Boolean[][] dp = new Boolean[num.length][sum + 1];

        return recursive(dp, num, sum, 0);
    }

    private boolean recursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {

        if (sum == 0) return true;

        if (currentIndex >= num.length || num.length == 0) {
            return false;
        }

        if (dp[currentIndex][sum] == null) {
            if (num[currentIndex] <= sum) {
                if (recursive(dp, num, sum - num[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }
            dp[currentIndex][sum] = recursive(dp,num, sum, currentIndex + 1);
        }


        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }

}
