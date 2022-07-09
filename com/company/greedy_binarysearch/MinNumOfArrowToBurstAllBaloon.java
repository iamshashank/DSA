package com.company.greedy_binarysearch;

import java.util.Arrays;

/**
 *
 * 452. Minimum Number of Arrows to Burst Balloons
 * Medium
 *
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 *
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 *
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 *
 * Example 2:
 *
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 *
 * Example 3:
 *
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 *
 *
 *
 * Constraints:
 *
 *     1 <= points.length <= 105
 *     points[i].length == 2
 *     -231 <= xstart < xend <= 231 - 1
 *
 */
public class MinNumOfArrowToBurstAllBaloon {

    public int findMinArrowShots(int[][] p) {
        // in this we have find exact opposite of 435. Non-overlapping Intervals
        // we try to burst only the non-overlapping ones and in the process all the overlapping ones wil be auto
        // so we find min number of ballons we need to eliminate to make everything else non-overlapping
        // then we just subtract it from total baloons
        Arrays.sort(p, (a, b)->{
            if(a[0] != b[0]){
                if(a[0] > b[0]) return 1;
                return -1;
            }else{
                if(a[1] > b[1]) return 1;
                return -1;
            }
        });
        // for(int i =0;i<p.length;i++) System.out.println(Arrays.toString(p[i]));
        int maxRight = p[0][1];
        int baloonsToBeBurstToMakeRestNonOverLapping = 0;
        // our aim to is find all non-overlapping balloon
        for(int i =1;i<p.length;i++){
            if(p[i][0] > maxRight){
                maxRight = p[i][1];
            }else{
                // overlapping we keep the update maxRight of the current right of curr baloon
                // if its smaller
                if(p[i][1] < maxRight){
                    maxRight = p[i][1];
                }
                baloonsToBeBurstToMakeRestNonOverLapping++;
            }
        }
        return p.length - baloonsToBeBurstToMakeRestNonOverLapping;
    }

}
