package com.company.array_cumulativesum;

import java.util.HashMap;

/**
 *
 * 560. Subarray Sum Equals K
 * Medium
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 */

public class SubArraySumEqualsK {
    public int subarraySum(int[] n, int k) {
        int ans = 0;
        int[] a = new int[n.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n.length;i++){
            if(i>0)
                a[i] = a[i-1] + n[i];
            else
                a[i] = n[i];

            // CASE 1
            if(a[i]==k){
                ans++;
            }
            // CASE 2
            if(map.containsKey(a[i]-k)){
                ans += map.get(a[i]-k);
            }
            int t = map.getOrDefault(a[i], 0);
            // we need to store how many times a[i] occurs in the cumulative sum array to figure out number of possible subarrays in CASE 2
            map.put(a[i], t+1);
        }


        return ans;
    }
}
