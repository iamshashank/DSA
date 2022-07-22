package com.company.arrays;

/**
 * 238. Product of Array Except Self
 * Medium
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 *
 * Constraints:
 *
 *     2 <= nums.length <= 105
 *     -30 <= nums[i] <= 30
 *     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class ProductOfArray_ExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, freqZero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                freqZero++;
            }else{
                prod *= nums[i];
            }
        }
        if(freqZero == nums.length) prod = 0;

        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(freqZero > 1){
                ans[i] = 0;
            }else if(freqZero == 1){
                if(nums[i] == 0){
                    ans[i] = prod;
                }else{
                    ans[i] = 0;
                }
            }else{
                ans[i] = prod/nums[i];
            }
        }
        return ans;
    }
}
