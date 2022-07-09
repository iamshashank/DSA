package com.company.priorityqueue_heap;

import java.util.Arrays;

/**
 * GREEDY
 * 435. Non-overlapping Intervals
 * Medium
 *
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 *
 * Example 3:
 *
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 */

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] i) {
        Arrays.sort(i, (a, b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            return a[1] - b[1];
        });
        // we have to count how many intervals we remove to prevent overlapping
        // assume 1st interval is in final solution i.e we dont remove it
        int maxRight = i[0][1];
        int ans = 0;
        for(int curr =1;curr<i.length;curr++){
            if(i[curr][0] >= maxRight){
                // matlab jo naya interval hai uski starting previous wale ke ending ke baad suru hoti hai
                // so no overlapping, so we try and kep it as well
                maxRight = Math.max(maxRight, i[curr][1]);
                continue;
            }else{
                // matlab overlap hai, jo curr interval hai, it lies within the previous
                // now we have to make a decision, kisi ko remove karna hai but kisko (prev wala ya curr)
                // yaha pe hum dekhenge ki rightEdge kiska greater hai
                // if previous wale ka right edge current se bhi aage hai fir to usi ko hatana chaheye kyu ki
                // kya pata current+1 wale ko bhi overlap kar de
                // greedy decision
                if(i[curr][1] < maxRight){
                    maxRight = i[curr][1];
                }
                // since we are removing something
                ans++;
            }
        }
        return ans;
    }
}
