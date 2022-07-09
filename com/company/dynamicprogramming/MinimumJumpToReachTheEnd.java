package com.company.dynamicprogramming;


// Given an array, find minimum number to jumps to reach end of array, given you can jump at max as much as value at position in array.
// https://www.youtube.com/watch?v=cETfFsSTGJI
public class MinimumJumpToReachTheEnd {
    public int process(int[] a){
        int[] dp = new int[a.length];
        //base condition start
        dp[0] = 0;
        if(a[0] != 0){
            dp[1] = 1;
        }else{
            // no solution exists
            return -1;
        }
        //end of base conditions
        for(int i = 2; i < a.length; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                // check if we can reach i from j
                if(j + a[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[a.length-1];
    }
}
