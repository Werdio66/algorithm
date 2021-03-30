package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2021-02-26 18:51:49
 */
public class 买卖股票最佳时机2 {

    public int maxProfit(int[] prices) {
        int res = 0;
        // 贪心，只要有利就会卖出股票
        for (int i = 0; i < prices.length - 1; i++) {
            int val = prices[i + 1] - prices[i];
            if (val > 0){
                res += val;
            }
        }
        return res;
    }

    public int maxProfit1(int[] prices) {
        // 当前状态为未持有股票
        int dp0 = 0;
        // 状态为持有股票，利润为 -prices[0]
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int newdp0 = Math.max(dp0, dp1 + prices[i]);
            int newdp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newdp0;
            dp1 = newdp1;
        }
        return dp0;
    }
}
