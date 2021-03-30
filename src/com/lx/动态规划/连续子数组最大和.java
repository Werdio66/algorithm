package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2020-12-10 18:36:46
 */
public class 连续子数组最大和 {

    public static int maxSubArray(int[] nums) {
        // dp[i] 表示当前位置最大和，所以整个数组的最大和需要重新遍历一遍dp数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int maxSubArray1(int[] nums) {
        int dp1 = nums[0];
        int dp2;
        int res = dp1;
        for (int i = 1; i < nums.length; i++) {
            dp2 = Math.max(dp1 + nums[i], nums[i]);
            res = Math.max(res, dp2);
            dp1 = dp2;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray1(arr));
    }
}
