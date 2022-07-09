package com.company.slidingwindow;

/**
 *
 * 713. Subarray Product Less Than K
 * Medium
 *
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 */

public class SubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] n, int k) {
        int l = n.length;
        int p = 1;
        int ans = 0;
        int low = 0;
        for(int i=0;i<l;i++){
            p *= n[i];
            while(low < i && p >= k ){
                p = p/n[low++];
            }
            if(p < k){
                // this is the trick the number of new sub array that are added to the answer is i-low+1
                ans += (i-low+1);
            }
        }
        return ans;
    }
}
