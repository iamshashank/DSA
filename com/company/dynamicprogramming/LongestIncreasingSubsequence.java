package com.company.dynamicprogramming;

//https://leetcode.com/problems/longest-increasing-subsequence/
//        Given an integer array nums, return the length of the longest strictly increasing subsequence.
//
//        A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
//        For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int process(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        for(int i =0;i<nums.length; i++){
            dp[i] = 1; // each index will at be a increasing subsequence of length 1
        }
        for(int i =1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                // its similar loop to insertio sort
                // j starts from 0 to i

                // we need increasing subsequence so array so in ascending order
                // so value on left should be smaller
                // dp[i] stores max length of subsequence till that index
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }


        return max;
    }

    public int fasterLIS(int[] nums){
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i =0;i<nums.length;i++){
            for(int j =0; j < dp.length;j++ ){
                // instead of looping we convert this to binary search to find if we can insert in between or need to add it to end
                // this will bring down it to O(nlog(n))
                if(nums[i] <= dp[j]){
                    dp[j] = nums[i];
                    max = Math.max(max, j+1);
                    break;
                }
            }
        }
        return max;
    }

}
