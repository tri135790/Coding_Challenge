package leetcode75.level1.knapsack;

public class CountSubsetSum {

    static int countSubsets(int[] num, int sum) {

        Integer[][] dp = new Integer[num.length][sum + 1];

        return recursive(dp, num, sum, 0);
    }

    private static int recursive(Integer[][] dp, int[] num, int sum, int currentIndex) {

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
        CountSubsetSum ss = new CountSubsetSum();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}
