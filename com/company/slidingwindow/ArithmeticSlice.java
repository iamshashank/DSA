package com.company.slidingwindow;

import java.util.Arrays;

/**
 * 413. Arithmetic Slices
 * Medium
 *
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 *     For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 *
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 *
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 5000
 *     -1000 <= nums[i] <= 1000
 */
public class ArithmeticSlice {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] diff = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++) diff[i] = nums[i+1]-nums[i];
//        System.out.println(Arrays.toString(diff));
        int i =1, l = 1;
        int ans = 0;

        /**
         *
         * The math here is if we get a window size = N
         * Since we are doing sliding window on diff array so if N = 2 then total elements are n = 3 (N+1)
         * n = is the length of subarray which form the slice (N+1)
         * n = 3 => 1
         * n = 4 => 2 + 1
         * n = 5 => 3 + 2 + 1
         * n = 6 => 4 + 3 + 2 + 1
         *
         * Its a Arithmetic Progression of from 1 to (n-3+1)
         *
         */

        while(i<diff.length){
            if(diff[i] == diff[i-1]){
                l++;
            }else{
                if(l+1 >= 3){
                    int n = (l+1)-3+1;
                    ans += n*(2 + (n-1))/2;
                }
                l = 1;
            }
            i++;
        }
        if(l+1 >= 3){
            int n = (l+1)-3+1;
            ans += n*(2 + (n-1))/2;
        }
        return ans;
    }
}
