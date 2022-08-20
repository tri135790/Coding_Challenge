package leetcode75.level1;


//DP
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] minPath = new int[grid.length][grid[0].length];
        minPath[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            minPath[i][0] = grid[i][0] + minPath[i-1][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            minPath[0][j] = grid[0][j] + minPath[0][j-1];
        }

        for (int i = 1; i < minPath.length; i++) {
            for (int j = 1; j <minPath[0].length; j++) {
                minPath[i][j] = grid[i][j] + Integer.min(minPath[i][j-1], minPath[i-1][j]);
            }
        }
        return minPath[minPath.length -1][minPath[0].length-1];
    }

    public int minPathSum2(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i][0] + grid[i-1][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] = grid[0][j] + grid[0][j-1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j <grid[0].length; j++) {
                grid[i][j] = grid[i][j] + Integer.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[grid.length -1][grid[0].length-1];
    }





}
