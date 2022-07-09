package com.company.sorting;

import java.util.*;

/**
 * 15. 3Sum
 * Medium
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     0 <= nums.length <= 3000
 *     -105 <= nums[i] <= 105
 */
public class Sum_3 {
    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if(l < 3) return ans;
        Set<String> set = new HashSet<>();
        for(int i=0;i<l;i++){
            for(int j = i+1;j<l;j++){
                int idx = search(nums, j+1, l-1, (0 - (nums[i]+nums[j])));
                if(idx != -1 && !set.contains(nums[i]+"#"+nums[j]+"#"+nums[idx])){
                    set.add(nums[i]+"#"+nums[j]+"#"+nums[idx]);
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(nums[idx]);
                    ans.add(t);
                }
            }
        }
        return ans;
    }

    int search(int[] a, int l, int h, int t){
        // System.out.println(l+" "+h+" "+t);
        int ans = -1;
        while(l<=h){
            int mid = (l+h)/2;
            if(a[mid] > t){
                h = mid - 1;
            }else if(a[mid] < t){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return ans;
    }
}
