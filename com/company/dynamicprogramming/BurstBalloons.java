package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 *https://www.youtube.com/watch?v=uG_MtaCJIrM
 * 312. Burst Balloons
 * Hard
 *
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
 *
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
 *
 * Return the maximum coins you can collect by bursting the balloons wisely.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 *
 * Example 2:
 *
 * Input: nums = [1,5]
 * Output: 10
 *
 */

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] n = new int[nums.length+2]; // padding 1 before start and after end od nums
        n[0] = 1;
        n[n.length-1] = 1;
        for(int i =1;i<n.length-1;i++)
            n[i] = nums[i-1];
        System.out.println(Arrays.toString(n));
        // now onlu use `n` array
        int[][] dp = new int[n.length][n.length];
        // we fill the dp array diagonally
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=nums.length;i++){
            // here `i` represent the size of sub-array we are calculating for
            // so in the starting it will be [1,1] [2,2] which are sub-array of size 1
            // `l` goes from 1 to N-window_size so basically window should reach the end
            for(int l = 1; l< n.length-i;l++){
                // so this `l` is the start or left of sub-array and `r` is the right of sub array
                int r = l+i-1; //sub-array/window of size `i`
                for(int k=l;k<=r;k++){
                    // so we now have a subarray of size `i` starting from `l` to `r`
                    // dp[i] signify that given a window from `l` to `r` if we decide to burst baloon at `k` last what will the max coins
                    int left = (k == l) ? 0 : dp[l][k-1]; // this what we get from left of `k`th baloon in the sub-array/window
                    int current = n[l-1]*n[k]*n[r+1]; // inside the window we have burst all baloons and `k` is the last one so we need to look before ans after the window to multiply
                    int right = (k == r) ? 0 :dp[k+1][r]; // these conditions are when we are talking about the 1st and last element of the window
                    int kTHBaloon = left + current + right;
                    dp[l][r] = Math.max(dp[l][r], kTHBaloon);
                }
                max = Math.max(max, dp[l][r]);
            }
        }
        return max;
    }
}
