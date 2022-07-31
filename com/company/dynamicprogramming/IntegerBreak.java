package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * 343. Integer Break
 * Medium
 *
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 *
 * Return the maximum product you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 *
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 *
 *
 * Constraints:
 *
 *     2 <= n <= 58
 */

public class IntegerBreak {
    int N =0;
    int[] dp;
    public int integerBreak(int n) {
        N = n;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return process(n);
    }

    int process(int a){
        if(a < 0) return 0;
        if(a == 0){
            return 1;
        }
        if(dp[a] != -1) return dp[a];
        int max = 0;
        // yaha pe i!=N is a edge case to ensure that we are atleast splitting into 2 parts
        for(int i=1;i<=a && i != N;i++){
            max = Math.max(max, i * process(a-i));
        }
        return dp[a] = max;
    }
}
