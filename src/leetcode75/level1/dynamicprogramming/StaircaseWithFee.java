package leetcode75.level1.dynamicprogramming;

public class StaircaseWithFee {

    public int findMinFee(int[] fee) {
        int[] dp = new int[fee.length];
        dp[0] = fee[0];
        dp[1] = fee[1] + fee[0];
        dp[2] = fee[2] + fee[0];
        dp[3] = fee[3] + fee[0];

        for (int i = 4; i < fee.length; i++) {
            dp[i] = fee[i] + Math.min(dp[i-1], Math.min(dp[i-2], dp[i-3]));
        }
        return Math.min(dp[fee.length-1], Math.min(dp[fee.length -2], dp[fee.length - 3]));
    }

    public static void main(String[] args) {
        StaircaseWithFee sc = new StaircaseWithFee();
        int[] fee = {1,2,5,2,1,2};
        System.out.println(sc.findMinFee(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.findMinFee(fee));
    }
}
