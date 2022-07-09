package com.company.arrays;

/**
 *
 * 845. Longest Mountain in Array
 * Medium
 *
 * You may recall that an array arr is a mountain array if and only if:
 *
 *     arr.length >= 3
 *     There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 *         arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *         arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 *
 * Example 2:
 *
 * Input: arr = [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 */

public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        if(arr.length < 3) return 0;
        int ans = 0;
        // find the peak first then loop back and forward to find its size
        for(int i =1;i<=arr.length-2;i++){
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                // we found a peak
                int c = 1;
                int j = i;
                // go backward
                while(j>0 && arr[j] > arr[j-1]){
                    c++;
                    j--;
                }
                // go forward
                while(i < arr.length-1 && arr[i] > arr[i+1]){
                    c++;
                    i++;
                }
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }
}
