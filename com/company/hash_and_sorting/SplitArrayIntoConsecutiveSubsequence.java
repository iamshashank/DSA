package com.company.hash_and_sorting;

import java.util.HashMap;

/**
 * https://www.youtube.com/watch?v=uJ8BAQ8lASE
 *
 * 659. Split Array into Consecutive Subsequences
 * Medium
 *
 * You are given an integer array nums that is sorted in non-decreasing order.
 *
 * Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:
 *
 *     Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
 *     All subsequences have a length of 3 or more.
 *
 * Return true if you can split nums according to the above conditions, or false otherwise.
 *
 * A subsequence of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without disturbing the relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,3,4,5]
 * Output: true
 * Explanation: nums can be split into the following subsequences:
 * [1,2,3,3,4,5] --> 1, 2, 3
 * [1,2,3,3,4,5] --> 3, 4, 5
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,3,4,4,5,5]
 * Output: true
 * Explanation: nums can be split into the following subsequences:
 * [1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
 * [1,2,3,3,4,4,5,5] --> 3, 4, 5
 *
 * Example 3:
 *
 * Input: nums = [1,2,3,4,4,5]
 * Output: false
 * Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
 *
 */

public class SplitArrayIntoConsecutiveSubsequence {
    public boolean isPossible(int[] n) {
        int l = n.length;
        // tells us how count of each number we encounter
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        // there store valid subset which are atleast length 3 and ready to accept more numbers if they are left
        // we will look at these after we know we cannot form a new subsequence starting from this number
        HashMap<Integer, Integer> futureMap = new HashMap<>();
        // store freq of each number
        for(int i = 0;i<l;i++){
            int t = freqMap.getOrDefault(n[i], 0);
            freqMap.put(n[i], t+1);
        }


        for(int i=0;i<l;i++){
            // we start at i and try to form subsequence of len 3
            int a = freqMap.getOrDefault(n[i], 0);
            if(a == 0) continue; // since this element is already taken up by a subsequence we dont need to worry about it
            int b = freqMap.getOrDefault(n[i]+1, 0);
            int c = freqMap.getOrDefault(n[i]+2, 0);

            // we try to find a existing group
            if(futureMap.getOrDefault(n[i], 0) > 0){
                int t = futureMap.get(n[i]);
                futureMap.put(n[i], t-1);
                // reduce count form freq map
                t = freqMap.get(n[i]);
                freqMap.put(n[i], t-1);
                // but now this future map can accept a new value n[i]+1
                t = futureMap.getOrDefault(n[i]+1, 0);
                futureMap.put(n[i]+1, t+1);
            }else if(a > 0 && b > 0 && c > 0){
                // now we attempt to form a subsequence of len 3 now the decrement the freqMap
                freqMap.put(n[i], a-1);
                freqMap.put(n[i]+1, b-1);
                freqMap.put(n[i]+2, c-1);
                // now we add a entry into the futureMap telling we can accept n[i]+3 if needed in future
                int t = futureMap.getOrDefault(n[i]+3, 0);
                // these many subsequence are ready to take n[i]+3 in future if it cant form its own sub sequence
                futureMap.put(n[i]+3, t+1);
            }else{
                return false;
            }
        }
        return true;
    }
}
