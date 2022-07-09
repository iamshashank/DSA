package com.company.slidingwindow;

/**
 *
 * 209. Minimum Size Subarray Sum
 * Medium
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 */

public class MinSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0, high = 0, sum = 0, windowLength = Integer.MAX_VALUE;
        while(high < nums.length){
            sum += nums[high];
            while(sum - nums[low] >= target){
                sum -= nums[low];
                low++;
            }
            if(sum >= target){
                int t = high-low+1;
                windowLength = Math.min(windowLength, t);
            }
            high++;
        }
        return (windowLength == Integer.MAX_VALUE) ? 0 : windowLength;
    }
}
