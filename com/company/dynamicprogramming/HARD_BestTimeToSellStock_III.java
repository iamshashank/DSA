package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=37s1_xBiqH0
 * 123. Best Time to Buy and Sell Stock III
 * Hard
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 */


public class HARD_BestTimeToSellStock_III {
    int[][][] dp;
    int[] p;
    int l;
    public int maxProfit(int[] prices) {
        l = prices.length;
        p = prices;
        dp = new int[p.length][3][2];
        for(int i=0;i<l;i++){
            for(int j=0;j<3;j++) Arrays.fill(dp[i][j], -1);
        }

        return profit(0, 2, 0); // on-day zero we start by not having bought anything
    }

    int profit(int i, int trans, int bought){
        // we have 3 possible actions a each day  1.Buy  2.Sell  3.Skip
        // and we have 2 possible states
        // 1. bought , if we have previously bought the stock we are bought state
        // 2. Sold  , if we are selling the stock
        // Initially we are on no-state and we can buy stock and move into Bought state or skip and remain in no-state
        // 0 - no-state  1 - bought  2- sold
        if(i>=l) return 0;
        if(trans == 0) return 0;
        if(dp[i][trans][bought] != -1) return dp[i][trans][bought];

        int maxProfit = 0;
        // we can always skip
        maxProfit = profit(i+1, trans, bought); // state will remain as previous

        if(bought == 0){
            // we need to buy
            maxProfit = Math.max(maxProfit, profit(i+1, trans, 1)-p[i]);
        }else{
            // we need to sell
            maxProfit = Math.max(maxProfit, profit(i+1, trans-1, 0)+p[i]);
        }

        dp[i][trans][bought] = maxProfit;
        return maxProfit;
    }
}
