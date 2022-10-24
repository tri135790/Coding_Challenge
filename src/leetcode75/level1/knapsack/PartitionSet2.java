package leetcode75.level1.knapsack;

public class PartitionSet2 {

    public boolean canPartition(int[] num) {
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        if (sum%2 != 0) {
            return false;
        }
        Boolean[][] dp = new Boolean[num.length][sum/2 + 1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s >= num[i]) {
                    dp[i][s] = dp[i-1][s - num[i]];
                }
            }
        }

        return dp[num.length-1][sum];
    }
}
