package leetcode75.level1.knapsack;

public class PartitionSet {

    public boolean canPartition(int[] num) {
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        if (sum%2 != 0) {
            return false;
        }
        Boolean[][] dp = new Boolean[num.length][sum/2 + 1];
        return this.recursive(num,sum/2,0, dp);
    }

    private boolean recursive(int[] num, int sum, int currentIndex, Boolean[][] dp) {
        if (sum == 0) return true;

        if (num.length == 0 || currentIndex >= num.length) {
            return false;
        }

        if (dp[currentIndex][sum] == null) {
            if (num[currentIndex] <= sum) {
                if (recursive(num, sum - num[currentIndex], currentIndex + 1, dp)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }
            dp[currentIndex][sum] = recursive(num, sum, currentIndex + 1, dp);
        }


        return dp[currentIndex][sum];

    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
