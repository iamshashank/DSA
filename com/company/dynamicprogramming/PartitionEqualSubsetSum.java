package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * Medium
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 200
 *     1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int l = nums.length;
        dp = new int[l+1][((100*200)/2)+1];
        for(int i =0;i<l+1;i++) Arrays.fill(dp[i], -1);
        int sum = 0;
        for(int i=0;i<l;i++) sum += nums[i];

        if(sum%2 !=0) return false;
        return process(0, sum/2, nums) == 1;
    }

    int process(int i, int sum, int[] nums){
        if(sum == 0) return 1;
        if(sum < 0 || i >= nums.length) return 0;
        if(dp[i][sum] != -1) return dp[i][sum];

        int ans = process(i+1, sum - nums[i], nums);
        if(ans != 1) ans = process(i+1, sum, nums);
        return dp[i][sum] = ans;
    }

}
