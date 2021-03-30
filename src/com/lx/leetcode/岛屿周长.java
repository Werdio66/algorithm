package com.lx.leetcode;

/**
 * @author Werdio丶
 * @since 2021-03-09 13:43:29
 */
public class 岛屿周长 {

    public int islandPerimeter(int[][] grid) {
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
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 1;
        }
        if (grid[row][col] == 0){
            return 1;
        }
        if (grid[row][col] != 1){
            return 0;
        }
        grid[row][col] = 2;
        return dfs(grid, row - 1, col)
                + dfs(grid, row + 1, col)
                + dfs(grid, row, col - 1)
                + dfs(grid, row, col + 1);
    }
}
