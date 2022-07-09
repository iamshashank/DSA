package com.company.dynamicprogramming;


//https://www.youtube.com/watch?v=td8JCnqt-JI

public class NumberOfLongestIncreasingSubsequence {
    public int process(int[] nums){
        int maxi = 1; // store max subsequence length
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];

        for(int i =0;i< dp.length; i++){
            // initially count at every index is 1 which represent that if we take that index by itself as subsequence of length 1 we have count 1
            count[i] = 1;
            dp[i] = 1;
        }

        dp[0] = 1;
        int max = 1;
        for(int i = 1; i< nums.length; i++){
            for(int j = 0; j< i; j++){
                if(nums[i] > nums[j]){
                    if( dp[j] + 1 > dp[i]){
                        dp[i] = 1 + dp[j];
                        // this means we are not seeing this length for the first time at this index so
                        // however many times count[j] occure count[i] will also occure
                        count[i] = count[j];
                    }else{
                        // no need to update dp[i]
                    }
                }else if(nums[i] > nums[j] && dp[j] + 1 == dp[i]) {
                    // if dp[j] + 1 == dp[i] what this means is we have we are seeing a new path to reach this sub-sequence of length dp[i]
                    count[i] += count[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int x = 0;
        for(int i = 0; i< dp.length; i++){
            if(dp[i] == maxi)
                x += count[i];
        }
        return x;
    }
}
