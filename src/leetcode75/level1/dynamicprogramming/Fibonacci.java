package leetcode75.level1.dynamicprogramming;

public class Fibonacci {

    public int CalculateFibonacci(int n) {
        int[] dp = new int[n + 1];
        return calculateFibo(dp, n);
    }

    private int calculateFibo(int[] dp, int n) {
        if (n < 2) {
            return n;
        }
        if (dp[n] == 0) {
            dp[n] = calculateFibo(dp, n -1) + calculateFibo(dp, n-2);
        }

        return dp[n];
    }
}
