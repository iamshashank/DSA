package com.company.dynamicprogramming;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Example 1:
 *
 * Input: [5, 2, 4, 3, 1, 6]
 * Output: 3
 * Explanation:
 * You can split this array into: [5, 2, 1], [4, 3], [6]. And there are 3 subsequences you get.
 * Or you can split it into [5, 4, 3], [2, 1], [6]. Also 3 subsequences.
 * But [5, 4, 3, 2, 1], [6] is not legal because [5, 4, 3, 2, 1] is not a subsuquence of the original array.
 *
 * Example 2:
 *
 * Input: [2, 9, 12, 13, 4, 7, 6, 5, 10]
 * Output: 4
 * Explanation: [2], [9, 4], [12, 10], [13, 7, 6, 5]
 *
 * Example 3:
 *
 * Input: [1, 1, 1]
 * Output: 3
 * Explanation: Because of the strictly descending order you have to split it into 3 subsequences: [1], [1], [1]
 */

public class Google_NumberOfDecreasingSubsequence {
    public int decreasingSubsequence(int[] a){
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[j] > a[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for(int x : dp) max = Math.max(max, x);

        return max;
    }

    /**
     * Special observation Patience sort
     * https://www.youtube.com/watch?v=K9M6g7BiBX4
     * When we are finding the LIS the number of decks we need is the length of the largest subsequence
     * But when we are finding out LDS (the longest decreasing subsequence) the number of decks required is the
     * (minimum number of strictly decreasing subsequence) we can split the array into a.k.a answer to this question
     * And the longest deck is length of LDS
     */

    public int ldsSplit(int[] a){
        int size = 1;
        int dp[] = new int[a.length];
        dp[0] = a[0];
        for(int i=1;i<a.length;i++){
            int idx = binarySearch(dp, 0, size, a[i]);
            System.out.println(idx);
            if(idx == size) size++; // need new deck
            dp[idx] = a[i];
        }
        System.out.println(Arrays.toString(dp));
        return size;
    }

    /**
     * Lower Bound Binary search
     */
    private int binarySearch(int[] a, int l, int r, int val) {
        while(l<r){
            int mid = (l+r)/2;
            if(a[mid] <= val){
                l = mid +1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
