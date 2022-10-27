package leetcode75.level1.dynamicprogramming;

public class HouseThief {

    public int findMaxSteal(int[] wealth) {
        if (wealth.length == 0) return 0;
        int[] dp = new int[wealth.length + 1];
        dp[0] = 0;
        dp[1] = wealth[0];

        for (int i = 1; i < wealth.length; i++) {
            dp[i + 1] = Math.max(wealth[i] + dp[i-1], dp[i]);
        }

        return dp[wealth.length];
    }

    private int recursive(int[] wealth, int currentIndex) {
        if (currentIndex == wealth.length) {
            return 0;
        }

        int stealCurrent = wealth[currentIndex] + recursive(wealth, currentIndex + 2);
        int skipCurrent = recursive(wealth, currentIndex + 1);

        return Math.max(stealCurrent, skipCurrent);
    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }
}
