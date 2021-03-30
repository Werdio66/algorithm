package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2020-12-09 09:17:53
 */
public class 最长公共子序列 {

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                if (c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static int longestCommonSubsequence1(String text1, String text2) {
        return dp(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    private static int dp(String text1, String text2, int i, int j) {
        if (i < 0 || j < 0){
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)){
            return dp(text1, text2, i - 1, j - 1) + 1;
        }else {
            return Math.max(dp(text1, text2, i - 1, j), dp(text1, text2, i, j - 1));
        }
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(longestCommonSubsequence(s1, s2));
        System.out.println(longestCommonSubsequence1(s1, s2));
    }
}
