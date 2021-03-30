package com.lx.动态规划;


/**
 *  计算将字符串 1 变为字符串 2 的次数
 * @author Werdio丶
 * @since 2020-12-14 18:11:30
 */
public class 编辑距离 {

    public static int minDistance(String word1, String word2) {
        map = new int[word1.length()][word2.length()];
        return dp1(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    private static int dp(String word1, int i, String word2, int j) {
        if (i < 0){
            return j + 1;
        }
        if (j < 0){
            return i + 1;
        }
        if (word1.charAt(i) == word2.charAt(j)){
            return dp(word1, i - 1, word2, j - 1);
        }else {
            return minValue(dp(word1, i, word2, j - 1) + 1,
                    dp(word1, i - 1, word2, j - 1) + 1,
                    dp(word1, i - 1, word2, j) + 1);
        }
    }
    static int[][] map;
    private static int dp1(String word1, int i, String word2, int j) {
        if (i < 0){
            return j + 1;
        }
        if (j < 0){
            return i + 1;
        }
        if (map[i][j] != 0){
            return map[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)){
            map[i][j] = dp(word1, i - 1, word2, j - 1);
        }else {
            map[i][j] =  minValue(dp1(word1, i, word2, j - 1) + 1,
                    dp1(word1, i - 1, word2, j - 1) + 1,
                    dp1(word1, i - 1, word2, j) + 1);
        }
        return map[i][j];
    }

    public static int minDistance2(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word1.charAt(j - 1);
                if (c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = minValue(dp[i - 1][j - 1] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j] + 1);
                }
            }
        }
        return dp[l1][l2];
    }
    private static int minValue(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(minDistance(s1, s2));
        System.out.println(minDistance2(s1, s2));
    }
}
