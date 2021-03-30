package com.lx.动态规划;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-01-03 10:27:56
 */
public class 子集背包 {

    public static boolean canPartition(int[] nums){
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
