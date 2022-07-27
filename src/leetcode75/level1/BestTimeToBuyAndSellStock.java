package leetcode75.level1;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for ( int i = 0 ; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max,prices[i] - min);
            }
        }

        return max;
    }

    public static void main (String[] args) {
        int[] prices = new int[] {7,5,3,6,2,6};
        System.out.println(maxProfit(prices));
    }
}
