package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 *
 * 45. Jump Game II
 * Medium
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 */

public class LIS_JumpGameII {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if(nums.length == 1) return dp[0];
        dp[1] = 1;
        for(int i = 2;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(j+nums[j] >= i) dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }
}
