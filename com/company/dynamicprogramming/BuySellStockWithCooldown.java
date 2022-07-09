package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 *
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * Medium
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 *     After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * Example 2:
 *
 * Input: prices = [1]
 * Output: 0
 */

public class BuySellStockWithCooldown {
    int[][] dp;
    int l;
    int[] p;
    public int maxProfit(int[] prices) {
        p = prices;
        l = p.length;
        dp = new int[l][2];
        for(int i =0;i<l;i++) Arrays.fill(dp[i], -1);
        return profit(0, 0);
    }

    // b = 1 is bought
    int profit(int i, int b){
        if(i >= l) return 0;
        if(dp[i][b] != -1) return dp[i][b];
        int ans = 0;
        // skip
        ans = profit(i+1, b);
        if(b == 1){
            // sell
            ans = Math.max(ans, profit(i+2, 0) + p[i]); // +1 extra for cooldown
        }else{
            ans = Math.max(ans, profit(i+1, 1) - p[i]);
        }
        return dp[i][b] = ans;
    }
}
