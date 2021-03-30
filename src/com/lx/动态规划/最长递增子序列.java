package com.lx.动态规划;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2020-12-10 14:14:49
 */
public class 最长递增子序列 {

    public static int lengthOfLIS(int[] nums) {
        // 表示第 i 个位置处的最长递增子序列
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }
}
