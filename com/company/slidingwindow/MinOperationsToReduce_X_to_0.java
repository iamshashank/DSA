package com.company.slidingwindow;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * Medium
 *
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 *
 * Example 2:
 *
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 *
 * Example 3:
 *
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 *
 */

public class MinOperationsToReduce_X_to_0 {
    public int minOperations(int[] n, int q) {
        //sliding window of max size with sum sum(nums) - x
        // in this continous elemnts will removed from wither end which will leave the elements in the middle intact as a subarray
        // we need to subtract a total of `q` from this array
        // so this question becomes find max len subarray which has sum of (sum(all el of n[]) - q)
        // since we are finding the max length subarray this will make sure that min no of el are removed from array
        int l = n.length;
        int sum = 0;
        for(int i=0;i<l;i++) sum += n[i];

        sum = sum - q;
        //sum of window
        int ws = 0;
        int low = 0;
        int x = -1, y = -1;
        int maxWindowSize = -1;
        // so we need to find max size window where sum of el is (sum - x)
        for(int i=0;i<l;i++){
            ws += n[i];
            while(ws > sum && low <= i){
                ws -= n[low++];
            }
            // System.out.println(ws);
            if(ws == sum){
                int tempWindowSize = i-low+1;
                if(tempWindowSize>maxWindowSize){
                    maxWindowSize = tempWindowSize;
                    x = low;
                    y = i;
                }
            }
        }
        if(x != -1){
            return (l - (y-x+1)); // l - len(window)
        }
        return -1;
    }
}
