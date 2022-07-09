package com.company.arrays;

/**
 *
 * 665. Non-decreasing Array
 * Medium
 *
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 *
 * Example 2:
 *
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 *
 */

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int c = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] > nums[i]){
                c++;

                if(c == 2) return false;

                // our options are to raise nums[i] to nums[i-1] or lower nums[i-1] to nums[i]
                // we try to lower the value of nums[i-1] to n[i]
                // this way we have a comparitively smaller value at nums[i]
                if(i > 1){
                    if(nums[i-2] <= nums[i]){
                        // ok its possible to lower the value of nums[i-1]
                        nums[i-1] = nums[i];
                    }else{
                        // no choice we need to increase nums[i] to nums[i-1]
                        nums[i] = nums[i-1];
                    }
                }else{
                    // no worries checking nums[i-2] since its not present we can directly lower the value of nums[i-1]
                    nums[i-1] = nums[i];
                }
            }
        }
        return true;
    }

}
