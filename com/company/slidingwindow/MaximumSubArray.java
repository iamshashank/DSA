package com.company.slidingwindow;

/**
 * 53. Maximum Subarray
 * Medium
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     -104 <= nums[i] <= 104
 */
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int l = 0, r = 0;
        int ans = Integer.MIN_VALUE, sum = 0;
        while(r<nums.length){
            // the idea is that jo -ive number hai vo sum ko always decrease hi karega
            // so jab sum < 0 ho to ignore the prev sum till now
            if(sum > 0){
                sum += nums[r];
            }else{
                sum = nums[r];
            }

            ans = Math.max(ans, sum);
            r++;
        }
        return ans;
    }

    public int myAttempt(int[] nums) {
        int l = 0, r = 0;
        int ans = Integer.MIN_VALUE, sum = 0;
        while(r<nums.length){
            sum += nums[r];

            while(l<r && nums[l]<0){
                sum -= nums[l++];
            }

            if(sum <= ans && sum <= 0){
                sum = nums[r];
                l = r;
            }


            ans = Math.max(ans, sum);
            r++;
        }
        return ans;
    }
}
