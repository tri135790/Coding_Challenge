package leetcode75.level1;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = -1;
        int totalCost = 0;
        while (n < cost.length - 3) {
            if (cost[n+2] <= cost[n+1]) {
                n =n + 2;
                totalCost = cost[n];
            } else {
                n = n + 1;
                totalCost = cost[n];
            }
        }
        return totalCost;
    }
}
