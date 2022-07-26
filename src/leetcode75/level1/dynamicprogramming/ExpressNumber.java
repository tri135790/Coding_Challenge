package leetcode75.level1.dynamicprogramming;

public class ExpressNumber {

    public int CountWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-4] + dp[i-3] + dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ExpressNumber en = new ExpressNumber();
        System.out.println(en.CountWays(4));
        System.out.println(en.CountWays(5));
        System.out.println(en.CountWays(6));
    }
}
