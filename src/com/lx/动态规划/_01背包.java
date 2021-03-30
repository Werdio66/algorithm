package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2021-01-01 10:00:50
 */
public class _01背包 {

    /**
     *  求装进背包的最大价值
     * @param w         背包总容量
     * @param n         物品的数量
     * @param wt        每一件物品的重量
     * @param val       每一件物品的价值
     * @return
     */
    public static int knapsack(int w, int n, int[] wt, int[] val){
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j - wt[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                System.out.print(" " + dp[i][j]);
            }
            System.out.println();
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        System.out.println(knapsack(4, 3, wt, val));
    }
}
