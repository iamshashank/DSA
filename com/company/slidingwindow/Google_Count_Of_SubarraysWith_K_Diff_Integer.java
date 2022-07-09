package com.company.slidingwindow;

import java.util.HashMap;

/**
 * 992. Subarrays with K Different Integers
 * Hard
 *
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 *
 * A good array is an array where the number of different integers in that array is exactly k.
 *
 *     For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 *
 * Example 2:
 *
 * Input: nums = [1,2,1,3,4], k = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 */
public class Google_Count_Of_SubarraysWith_K_Diff_Integer {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // we cannot directly find out how many subarray possible with K distinct digits' by we can find out how manu sun-array upto K digits
        // number of subarrays that have distinct num <= k
        // MINUS
        // number of subarrays that have distinct num < K

        // when we subtract we are left with number of windows with exactly K distinct digits
        return helper(nums, k) - helper(nums, k-1);
    }

    private int helper(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int low = 0, high = 0;
        int count = 0;
        while(high < nums.length){
            int c = map.getOrDefault(nums[high], 0);
            map.put(nums[high], c+1);

            while(map.size() > k){
                int t = map.getOrDefault(nums[low], 0);
                if(t > 1){
                    map.put(nums[low], t-1);
                }else{
                    map.remove(nums[low]);
                }
                low++;
            }

            // THIS IS THE MAIN TRICK
            // With his we are counting how many subarray are possible of size 1 to len(window)
            // This way we are finding out number of windows of size <= K
            count += (high - low + 1);
            high++;
        }
        return count;
    }
}
