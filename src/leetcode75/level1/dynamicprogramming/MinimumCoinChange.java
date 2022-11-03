package leetcode75.level1.dynamicprogramming;

public class MinimumCoinChange {

    public int countChangeBottomUp(int[] denominations, int total) {
        int[] dp = new int[total+1];

        for (int i = 1; i <= total; i++) {
            int min = Integer.MAX_VALUE;
            for (int deno : denominations) {
                if (i >= deno && dp[i-deno] != -1) {
                    min = Math.min(min, 1 + dp[i-deno]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return dp[total];

    }

    public int countChange(int[] denominations, int total) {
        int[] dp = new int[total + 1];
        return recursive(dp, denominations, total);
    }

    private int recursive(int[] dp,int[] denominations, int total) {
        if (total < 0) {
            return  -1;
        }

        if (total == 0) {
            return 0;
        }

        if (dp[total] == 0) {
            int min = Integer.MAX_VALUE;
            for (int deno : denominations) {
                int c = recursive(dp, denominations, total - deno);
                if (c != -1) {
                    min = Math.min(min, 1 + c);
                }
            }

            dp[total] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[total];
    }

    public static void main(String[] args) {
        MinimumCoinChange cc = new MinimumCoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChangeBottomUp(denominations, 5));
        System.out.println(cc.countChangeBottomUp(denominations, 11));
        System.out.println(cc.countChangeBottomUp(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChangeBottomUp(denominations, 7));
    }
}
