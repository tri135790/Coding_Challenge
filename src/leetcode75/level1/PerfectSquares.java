package leetcode75.level1;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public int numSquares(int n) {
        List<Integer> squareList = new ArrayList<>();

        int i = 1;
        while (i * i <= n) {
            squareList.add(i * i);
            i++;
        }
        int[] dp = new int[n + 1];

        for (int j = 1; j <= n; j++) {
            int leastCount = Integer.MAX_VALUE;
            for (int m = squareList.size() - 1; m >= 0; m--) {
                if (j >= squareList.get(m)) {
                    leastCount = Math.min(leastCount, 1 + dp[j - squareList.get(m)]);
                }
            }
            dp[j] = leastCount;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares ob = new PerfectSquares();
        ob.numSquares(12);
    }
}
