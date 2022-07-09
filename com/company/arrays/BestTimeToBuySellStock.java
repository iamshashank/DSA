package com.company.arrays;

/**
 * The points of interest are the peaks and valleys in the given graph. We need to find the largest peak following the smallest valley. We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
 *
 */

public class BestTimeToBuySellStock {
    public int maxProfit(int[] p) {

        int maxProfit = 0;
        int minPrice = p[0];
        for(int i =1;i<p.length;i++){
            if(p[i] > minPrice){
                int profit = p[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                minPrice = p[i];
            }
        }
        return maxProfit;
    }
}
