package com.company.arrays;

import java.util.Arrays;

/**
 *55. Jump Game
 * Medium
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 104
 *     0 <= nums[i] <= 105
 *
 *
 */

public class JumpGameIII {
    /**
     * In this we dont have to find min jumps ect
     * we just need if we can reach the end or not
     * so from i hum jaha tak jaa sakte hai uska dp[i] true kar do
     *
     * @param n
     * @return
     */
    public boolean canJump(int[] n) {
        int l = n.length;
        boolean[] dp = new boolean[l];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i =0;i<l;i++){
            if(dp[i]){
                for(int j=i;j<l && j<=i+n[i];j++){
                    dp[j] = true;
                }
            }
        }
        return dp[l-1];
    }

    public boolean canJumpFaster(int[] n) {
        int l = n.length;
        int farthest = 0;
        for(int i =0;i<l;i++){
            // we always 1st update how far we can reach and if i catches up to farthest it means we cannot go any further
            if(i+n[i] > farthest) farthest = i+n[i];
            if(i == farthest) break;
        }
        return farthest >= l-1;
    }

}
