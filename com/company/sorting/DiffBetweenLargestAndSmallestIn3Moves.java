package com.company.sorting;

import java.util.Arrays;

/**
 *
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * Medium
 *
 * You are given an integer array nums. In one move, you can choose one element of nums and change it by any value.
 *
 * Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,3,2,4]
 * Output: 0
 * Explanation: Change the array [5,3,2,4] to [2,2,2,2].
 * The difference between the maximum and minimum is 2-2 = 0.
 *
 * Example 2:
 *
 * Input: nums = [1,5,0,10,14]
 * Output: 1
 * Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1].
 * The difference between the maximum and minimum is 1-0 = 1.
 *
 */

public class DiffBetweenLargestAndSmallestIn3Moves {
    public int minDifference(int[] n) {
        // in the question we have to remove/change atmost 3 digits and after that find MAX - MIN
        // we find out the 4 smallest and 4 largest we will eliminate the 3 pair which have the largest diff

        // we can remove (3 largest) in this case our ans is 4th largest - smallest                  -> b[0] - a[0]
        // we can remove 2 largest & 1 smallest in this case our ans is 3th largest - 2nd smallest -> b[1] - a[1]
        // we can remove 1 largest & 2 smallest in this case our ans is 2th largest - 3rd smallest -> b[2] - a[2]
        // we can remove 0 largest & 3 smallest in this case our ans is largest - 4th smallest     -> b[3] - a[3]

        int l = n.length;
        Arrays.sort(n);
        if(l < 4) return 0;
        int[] a = new int[]{n[0], n[1], n[2], n[3]}; // smallest 4 in ASC
        int[] b = new int[]{n[l-4], n[l-3], n[l-2], n[l-1]}; // largest 4 IN ASC
        int ans = Integer.MAX_VALUE;
        for(int i =0;i<4;i++){
            if(a[i] >= b[i]) return 0;
            ans = Math.min(ans, b[i]-a[i]);
        }
        return ans;
    }
}
