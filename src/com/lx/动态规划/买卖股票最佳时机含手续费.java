package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2021-02-27 09:50:04
 */
public class 买卖股票最佳时机含手续费 {

    public int maxProfit(int[] prices, int fee) {
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            int ndp0 = Math.max(dp0, dp1 + prices[i] - fee);
            int ndp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = ndp0;
            dp1 = ndp1;
        }
        return dp0;
    }
}
