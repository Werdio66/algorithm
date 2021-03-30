package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2021-02-27 10:16:02
 */
public class 买卖股票最佳时机3 {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        // 第一次买入
        int buy1 = -prices[0];
        // 当前状态为第一次卖出
        int sell1 = 0;
        // 第二次买入
        int buy2 = -prices[0];
        // 第二次卖出
        int sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            // 之前买入的没有卖出或者这次买入
            buy1 = Math.max(buy1, -prices[i]);
            // 之前是第一次卖出状态或者这一次卖出
            sell1 = Math.max(sell1, buy1 + prices[i]);
            // 第二次买入,之前就是买入状态或者是第一次卖出的状态
            buy2 = Math.max(buy2, sell1 - prices[i]);
            // 之前就是卖出状态或者这一次卖出
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(arr));
    }
}
