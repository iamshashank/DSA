package com.company.sorting;

import java.util.Arrays;

/**
 *
 *
 * 354. Russian Doll Envelopes
 * Hard
 *
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * Note: You cannot rotate an envelope.
 *
 *
 *
 * Example 1:
 *
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * Example 2:
 *
 * Input: envelopes = [[1,1],[1,1],[1,1]]
 * Output: 1
 *
 */

public class RussianDollEnvelop {
    public int maxEnvelopes(int[][] e) {
        // sort by width ascending and if width same then by height desc
        Arrays.sort(e, (a, b)->{
            if(a[0] == b[0])
                return b[1] - a[1]; // this is part of the trick
            return a[0] - b[0];
        });

        // Apply LIS on hight part or index 1
        int max = 0;
        int[] dp = new int[e.length+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // doing this so that elements after this
        // our binary search returns the index from 1 so we making dp[0] to ensure that any elements which is searched is atleast greater   than dp[0]
        dp[0] = Integer.MIN_VALUE;
        for(int i=0;i<e.length;i++){
            int index = binarySearch(dp, e[i][1]);
            max = Math.max(max, index); // this will give use length of LIS
            if(dp[index] >= e[i][1]){
                dp[index] = e[i][1];
            }
        }
        return max;
    }

    public int binarySearch(int[] dp, int a){
        int low = 0, high = dp.length - 1, ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(a > dp[mid]){ // for this condition we have dp[0] = Integer.MIN_VALUE;
                ans = mid;
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return ans+1;
    }

}
