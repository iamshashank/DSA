package com.company.greedy_binarysearch;

import java.util.Arrays;

/**
 *  https://www.youtube.com/watch?v=DQbfHqzgasU
 *
 * 2054. Two Best Non-Overlapping Events
 * Medium
 *
 * You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei].
 * The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei.
 * You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
 *
 * Return this maximum sum.
 *
 * Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.
 *
 *
 *
 * Example 1:
 *
 * Input: events = [[1,3,2],[4,5,2],[2,4,3]]
 * Output: 4
 * Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
 *
 * Example 2:
 * Example 1 Diagram
 *
 * Input: events = [[1,3,2],[4,5,2],[1,5,5]]
 * Output: 5
 * Explanation: Choose event 2 for a sum of 5.
 *
 * Example 3:
 *
 * Input: events = [[1,5,3],[1,5,1],[6,6,5]]
 * Output: 8
 *
 *
 */

public class TwoBestNonOverlappingEvent {
    // https://www.youtube.com/watch?v=DQbfHqzgasU
    public int maxTwoEvents(int[][] e) {
        int l = e.length;
        // sort by ending time
        Arrays.sort(e, (a, b)->{
            return a[1] - b[1];
        });
        // now we store the max value till `i` in a new array
        int[] maxi = new int[l];
        maxi[0] = e[0][2];
        for(int i =1;i<l;i++) maxi[i] = Math.max(maxi[i-1], e[i][2]);

        // assume the value at first is the answer
        int ans = e[0][2];
        // since we only need to find 2 intervals
        // we use 1 loop to decide the first interval and then since the array is sorted
        // we will look at intervals from 0 to i-1 to find a interval which is not overlapping i.e we will go in reverse ans
        // find the 1st intervals whose endtime is smaleer than starttime of event[i]
        // and gets its maxi value
        for(int i=1;i<l;i++){
            // pata chala ye akela ki max value de dega
            ans = Math.max(ans, e[i][2]);
            int idx = binarySearch(e, 0, i-1, e[i][0]-1); // -1 because end times are inclusive
            if(idx == -1){
                // pecche koi appropriate event nia mila
                continue;
            }else{
                ans = Math.max(ans, e[i][2] + maxi[idx]);
            }
        }
        return ans;
    }

    /**
     *
     * There is a special mdification to this binary search
     * What we actually need to find the upper index (if target is at index 2,3,4) we want to return 4 and not 2
     * the reason being the target is a time componnent and out maxi stores the max upto index `i` so we need to maximize the index `i` along with finding target
     * IN traditional binary search it would have returned 2
     *
     */
    int binarySearch(int[][] e, int i, int j, int target){
        while(i <= j){
            int mid = (j+i)/2;
            // we added a <= instead of only < so that we go to that upper index
            if(e[mid][1] <= target){
                i = mid+1;
            }else if(e[mid][1] > target){
                j = mid-1;
            }else{
                return mid;
            }
        }
        // if the element is not found the Math.abs(i) stores the index at which that value will be inserted in this sorted array
        return Math.abs(i) -1;
    }
}
