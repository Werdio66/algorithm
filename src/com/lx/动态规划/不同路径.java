package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2020-12-09 22:36:15
 */
public class 不同路径 {

    public static int uniquePaths(int m, int n) {
        map = new int[m][n];
        return dfs(1, 1, m, n);
    }
    static int[][] map;
    private static int dfs(int i, int j, int m, int n) {
        if (i < 0 || i > m || j < 0 || j > n){
            return 0;
        }
        if (i == m && j == n){
            return 1;
        }
        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }

    public static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths1(3, 7));
        System.out.println(uniquePaths2(3, 7));
    }
}
