package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 *
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * Medium
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * Example 2:
 *
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *
 */
public class BuySellStockWithTransactionFee {

    int[][] dp;
    int[] p;
    int l;
    int f;
    public int maxProfit(int[] prices, int fee) {
        p = prices;
        l = p.length;
        f = fee;
        dp = new int[l][2]; // since there no transaction limit we dont need to keep track of it
        if(p.length == 1) return 0;// dont buy if you cant sell

        for(int i=0;i<l;i++){
            Arrays.fill(dp[i], -1);
        }

        return profit(0, 0); // on-day zero we start by not having bought anything
    }

    public int profit(int i, int bought){
        if(i >= l) return 0;
        if(dp[i][bought] != -1) return dp[i][bought];

        int maxProfit = 0;
        // we can always skip
        maxProfit = profit(i+1, bought);

        if(bought == 1){
            // sell
            maxProfit = Math.max(maxProfit, profit(i+1, 0) +p[i] - f);
        }else{
            // buy
            maxProfit = Math.max(maxProfit, profit(i+1, 1)-p[i]);
        }

        return dp[i][bought] = maxProfit;
    }

}
