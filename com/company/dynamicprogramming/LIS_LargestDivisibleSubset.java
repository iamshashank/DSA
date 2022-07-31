package com.company.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 * Medium
 *
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 *     answer[i] % answer[j] == 0, or
 *     answer[j] % answer[i] == 0
 *
 * If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 *
 * Example 2:
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 1000
 *     1 <= nums[i] <= 2 * 109
 *     All the integers in nums are unique.
 */


public class LIS_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // same logic as LIS longest increasing subsequence
        Arrays.sort(nums);
        int n = nums.length;
        // reverse to make it descending
        for(int i=0;i<n;i++){
            int t = nums[n-i-1];
            nums[n-i-1] = nums[i];
            nums[i] = t;
        }
        List<Integer> ans = new ArrayList<>();
        int[] dp, idx;
        dp = new int[n];
        idx = new int[n];
        Arrays.fill(idx, -1); // this will store index which will be aprt of the LIS
        int max = 0;
        // O(n^2)
        for(int i=0;i<n;i++){
            dp[i] = 1; // by default the number will be part of the solution so length of ans arrays is 1
            for(int j=0;j<i;j++){
                // since we have sorted the array in DESC we only have to check greater%smaller
                if(nums[i]%nums[j] == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    idx[i] = j;
                }
            }
            max = Math.max(max, dp[i]);
        }

        // now `max` store the length of the `ans` array aka max len of LIS
        // now find out which index has that value
        int k = 0;
        for(int i =0;i<n;i++){
            if(dp[i] == max){
                k = i;
                break;
            }
        }
//         System.out.println(k);
//         System.out.println(Arrays.toString(idx));

        // populate ans
        while(k != -1){
            ans.add(nums[k]);
            k = idx[k];
        }
        return ans;
    }
}
