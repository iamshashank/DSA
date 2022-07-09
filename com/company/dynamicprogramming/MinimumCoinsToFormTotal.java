package com.company.dynamicprogramming;

// given coins of several denomination of infinite quantity and amount A
// find the min number of coins it will take to form that total
public class MinimumCoinsToFormTotal {
    public int process(int[] coins, int A){
        // d[i] = min number of coins needed to form i
        int[] dp = new int[A+1];
        dp[0] = 0; // it takes 0 coins to form 0

        for(int i =1;i < A+1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<coins.length;i++){
            int coin = coins[i];
            for(int j =1; j<A+1; j++){
                if(coin <= j){
                    // we dp[j] = min(dp[j], dp[j-coin] + 1) min_between(we don't use this coin, we use this coin)
                    // we are doing this nonsense because we cannot do (Integer.MAX_VALUE + 1)
                    if(dp[j-coin] == Integer.MAX_VALUE){
                        dp[j] = Math.min(dp[j], dp[j-coin]);
                    }else {
                        dp[j] = Math.min(dp[j], dp[j-coin] + 1);
                    }
                }
            }
        }
        // this is for edge case where we cannot get A from the coins
        if(dp[A] == Integer.MAX_VALUE)
            return -1;

        return dp[A];
    }
}
