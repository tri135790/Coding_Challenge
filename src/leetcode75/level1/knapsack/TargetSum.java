package leetcode75.level1.knapsack;

public class TargetSum {

    public int findTargetSubsets(int[] num, int s) {

        int totalSum = 0;
        for (int n : num)
            totalSum += n;

        if(totalSum < s || (s + totalSum) % 2 == 1)
            return 0;

        Integer[][] dp = new Integer[num.length][(s + totalSum) / 2 + 1];

        return recursive(dp, num, (s + totalSum) / 2, 0);
    }

    private int recursive(Integer[][] dp, int[] num, int sum, int currentIndex) {

        if (sum == 0) return 1;

        if (currentIndex >= num.length || num.length == 0) {
            return 0;
        }
        int count1 = 0, count2 = 0;

        if (dp[currentIndex][sum] == null) {
            if (num[currentIndex] <= sum) {
                count1 = recursive(dp, num, sum - num[currentIndex], currentIndex + 1);
            }

            count2 = recursive(dp, num, sum, currentIndex + 1);

            dp[currentIndex][sum] = count1 + count2;
        }

        return dp[currentIndex][sum];

    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
