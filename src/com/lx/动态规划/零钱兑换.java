package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2020-12-11 15:35:27
 */
public class 零钱兑换 {

    public static int coinChange(int[] coins, int amount) {
        int dp = dp(coins, amount);
        return Math.max(dp, -1);
    }

    private static int dp(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = dp(coins, amount - coin);
            if (temp == -1){
                continue;
            }
            res = Math.min(temp + 1, res);
        }
        return res;
    }

    public static int coinChange1(int[] coins, int amount) {
        return 1;
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 1};
        System.out.println(coinChange(arr, 11));
    }
}
