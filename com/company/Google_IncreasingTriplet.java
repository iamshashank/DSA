package com.company;

/**
 *
 *https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * 334. Increasing Triplet Subsequence
 * Medium
 *
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 */

public class Google_IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        boolean c = false;
        int[] ans = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        for(int n : nums){
            for(int j =0;j< 3;j++){
                if(n <= ans[j]){
                    if(j == 2) c = true; // even if we write to 3rd index once we have the answer
                    ans[j] = n;
                    break;
                }
            }
        }
        return c;
    }
}