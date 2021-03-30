package com.lx.offer;

/**
 * @author Werdio丶
 * @since 2021-02-03 09:42:32
 */
public class 礼物最大价值 {

    public static int maxValue(int[][] grid) {
        int row = grid.length;
        int colwn = grid[0].length;
        for (int i = 1; i < colwn; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < colwn; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[row - 1][colwn - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(maxValue(arr));
    }
}
