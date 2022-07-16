package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * 198. House Robber
 * Medium
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 100
 *     0 <= nums[i] <= 400
 */

public class HouseRobber {
    int[][] dp;
    public int rob(int[] nums) {
        // for each house we need max money we can loot in both scenarios (looted/not-looted)
        dp = new int[2][nums.length+1];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);

        return dfs(0, 0, nums);
    }

    int dfs(int i, int lastHouseBrokenIn, int[] nums){
        if(i >= nums.length) return 0;
        if(dp[lastHouseBrokenIn][i] != -1) return dp[lastHouseBrokenIn][i];
        int steal = 0, notSteal = 0;
        // not steal
        notSteal = dfs(i+1, 0, nums);
        // steal
        if(lastHouseBrokenIn == 0){
            // since last house was not broken in, we have option of either break in
            steal = nums[i] + dfs(i+1, 1, nums);// break in
        }

        return dp[lastHouseBrokenIn][i] = Math.max(steal, notSteal);
    }
}
