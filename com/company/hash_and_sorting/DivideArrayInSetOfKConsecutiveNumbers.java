package com.company.hash_and_sorting;

import java.util.Arrays;
import java.util.HashMap;

// EXACTLY SAME PROBLEM AS HandOfStraight

/**
 *
 * 1296. Divide Array in Sets of K Consecutive Numbers
 * Medium
 *
 * Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k consecutive numbers.
 *
 * Return true if it is possible. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * Output: true
 * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
 *
 * Example 3:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * Explanation: Each array should be divided in subarrays of size 3.
 */

public class DivideArrayInSetOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] n, int k) {
        int l = n.length;
        if(l%k != 0) return false;
        Arrays.sort(n);
        // freq map
        HashMap<Integer, Integer> fq = new HashMap<>();

        for(int i=0;i<l;i++) {
            int t = fq.getOrDefault(n[i], 0);
            fq.put(n[i], t+1);
        }

        for(int i = 0; i<l;i++){
            // we try form a k length consicutive array
            if(fq.getOrDefault(n[i],0) == 0) continue;
            for(int j = n[i];j < n[i]+k;j++){
                // we try to see if we have these numbers in our map
                // since the have to be consecutive if we done find any we can return false
                int t = fq.getOrDefault(j, 0);
                if(t == 0){
                    return false;
                }else{
                    // reduce the count
                    fq.put(j, t-1);
                }
            }
        }
        return true;
    }
}
