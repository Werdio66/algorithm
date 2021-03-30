package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2021-02-27 09:37:40
 */
public class 买卖股票最佳时机含冷冻期 {

    public int maxProfit(int[] prices) {
        // 当前持有股票
        int dp0 = -prices[0];
        // 当前不持有且处于冷冻期
        int dp1 = 0;
        // 当前不持有
        int dp2 = 0;

        for (int i = 1; i < prices.length; i++) {
            int ndp0 = Math.max(dp0, dp2 - prices[i]);
            int ndp1 = dp0 + prices[i];
            int ndp2 = Math.max(dp2, dp1);
            dp0 = ndp0;
            dp1 = ndp1;
            dp2 = ndp2;
        }
        return Math.max(dp1, dp2);
    }
}
