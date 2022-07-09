package com.company.knapsack;

import java.util.Arrays;

public class Google_MinDiffBetweenServerLoad {
    // exact same as 1049. Last Stone Weight II OR Google_LastStoneWeight
    public  int serverLoad(int[] loads){
        int sum = Arrays.stream(loads).sum();
        int  l = loads.length;

        // in this instead of cloning the dp i will use 2dp DP
        boolean[][] dp = new boolean[l+1][(sum/2)+1];
        for(int i=0;i<l;i++) Arrays.fill(dp[i], false);

        // if we have to make 0 weight we dont need any stones
        for(int i=0;i<=l;i++) dp[i][0] = true;
        // we dont have stones we can never make any weight except 0
        for(int i=1;i<=sum/2;i++) dp[0][i] = false;
        int maxLoadReached = 0;
        // here I is index till which we have loaded the process
        for(int i=1;i<=l;i++){
            // here J is the server load
            for(int j = 1; j<=sum/2;j++){
                if(loads[i-1] > j){
                    // we cannot form the load J so what best we did earlier is the answer
                    dp[i][j] = dp[i-1][j];
                }else{
                    // load[i-1] is equal or smaller
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - loads[i-1]];
                }
                if(dp[i][j]){
                    maxLoadReached = Math.max(maxLoadReached, j);
                }
            }
        }
        return sum - 2*maxLoadReached;
    }


    // same as Google_LastStoneWeight
    public  int serverLoadDP(int[] loads){
        int sum = Arrays.stream(loads).sum();
        int  l = loads.length;

        // in this instead of cloning the dp i will use 2dp DP
        boolean[] dp = new boolean[(sum/2)+1];
        dp[0] = true;
        int maxLoadReached = 0;
        // here I is index till which we have loaded the process
        for(int load : loads){
            boolean[] temp = dp.clone();
            for(int j = load; j<=sum/2;j++){
                if(dp[j-load]){
                    temp[j] = true;
                    maxLoadReached = Math.max(j, maxLoadReached);
                }
            }
            dp = temp;
        }
        return sum - 2*maxLoadReached;
    }
}
