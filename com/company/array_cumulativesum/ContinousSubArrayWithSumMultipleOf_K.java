package com.company.array_cumulativesum;

import java.util.HashMap;

/**
 *
 * 523. Continuous Subarray Sum
 * Medium
 *
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
 *
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 *
 * Example 2:
 *
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 *
 * Example 3:
 *
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 */
public class ContinousSubArrayWithSumMultipleOf_K {
    public boolean checkSubarraySum(int[] n, int k) {
        int sum = 0, rem = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // this is base condition to cover cases where first time % is 0
        map.put(0, -1);
        for(int i=0;i<n.length;i++){
            // this is a mathematics trick
            sum += n[i];
            rem = sum%k;
            if(map.containsKey(rem)){
                if(i-map.get(rem) > 1) return true;
            }else{
                map.put(rem, i);
            }
        }

        return false;
    }
}
