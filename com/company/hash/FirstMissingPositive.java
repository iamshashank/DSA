package com.company.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. First Missing Positive
 * Hard
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 5 * 105
 *     -231 <= nums[i] <= 231 - 1
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int max = nums.length+1;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int i = 1;
        for(;i<max;i++){
            if(!set.contains(i)) break;
        }
        return i;
    }
}
