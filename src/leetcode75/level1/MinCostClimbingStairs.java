package leetcode75.level1;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        for (int i = 0; i < cost.length; i ++) {
            if (i == 0 || i == 1) {
                minCost[i] = cost[i];
            } else {
                minCost[i] = Integer.min(minCost[i-1], minCost[i-2]) + cost[i];
            }
        }
        return Integer.min(minCost[minCost.length-1], minCost[minCost.length-2]);
    }
}
