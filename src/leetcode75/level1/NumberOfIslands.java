package leetcode75.level1;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count ++;

                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (i > 0) {
                dfs(grid, i-1, j);
            }
            if (j > 0) {
                dfs(grid, i, j-1);
            }
            if (i < grid.length - 1) {
                dfs(grid, i+1, j);
            }
            if (j < grid[i].length - 1) {
                dfs(grid, i, j+1);
            }
        }

    }

}
