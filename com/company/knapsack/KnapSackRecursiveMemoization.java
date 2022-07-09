package com.company.knapsack;

import java.util.Arrays;

// 0/1 Knapsack
// in this at each item we have 2 choices
// 1. include the item then we are left with N-1 items & W = W - w[item]
// 2. dont include the item then we are left with N-1 items and W weight
// base conditions if W = 0 then return 0 as we cannot include item anymore
// if w[item] > W then you cannot include that item so call f(v, w, i-1, W)
public class KnapSackRecursiveMemoization {
    int[][] dp;

    public int knapsack(int[] v, int[] w, int i, int W){
        if(i < 0)
            return 0;
        if(W == 0)
            return 0;
        if(dp[i][W] != -1)
            return dp[i][W];
        if(w[i] > W )
            return dp[i][W] = process(v, w, i-1, W); // exclude this item
        int includeThisItem = v[i] + process(v, w, i-1, W-w[i]);
        int excludeThisItem = process(v, w, i-1, W);
        return dp[i][W] = Math.max(includeThisItem, excludeThisItem);
    }

    public int process(int[] v, int[] w, int x, int W){
        dp = new int[v.length][W+1];
        for(int i=0; i< v.length; i++){
            for(int j=0; j< W+1; j++){
                dp[i][j] = -1;
            }
        }
        return knapsack(v, w, x, W);
    }
}
