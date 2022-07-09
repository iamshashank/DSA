package com.company.dfs;

import java.util.Arrays;

/**
 *
 * 1306. Jump Game III
 * Medium
 *
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 *
 * Example 2:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 *
 * Example 3:
 *
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *
 */

public class JumpGameIII {
    int[] dp;
    boolean[] v;
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        dp = new int[n];
        v = new boolean[n];
        Arrays.fill(dp, -1);
        Arrays.fill(v, false);

        dp[start] = process(arr, start);
        return dp[start] == 1;
    }

    int process(int[] a, int i){
        if(i < 0 || i > a.length-1 || v[i]) return 0;
        if(a[i] == 0) return 1;
        if(dp[i] != -1) return dp[i];

        v[i] = true; // this is necessary to avoid cycle
        // go back
        int l = process(a, i - a[i]);
        // forward
        int r = process(a, i + a[i]);
        return dp[i] = (l == 1 || r == 1) ? 1 : 0;
    }
}
