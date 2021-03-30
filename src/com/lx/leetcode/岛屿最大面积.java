package com.lx.leetcode;

/**
 * @author Werdio丶
 * @since 2021-03-09 14:01:22
 */
public class 岛屿最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }
        grid[row][col] = 0;
        int res = 1;
        res += dfs(grid, row - 1, col)
                + dfs(grid, row + 1, col)
                + dfs(grid, row, col - 1)
                + dfs(grid, row, col + 1);
        return res;
    }
}
