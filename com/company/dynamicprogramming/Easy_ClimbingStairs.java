package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * 70. Climbing Stairs
 * Easy
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 45
 */
public class Easy_ClimbingStairs {
    int[] dp;
    int N;
    public int climbStairs(int n) {
        N = n;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = dfs(0);
        // System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    int dfs(int i){
        if(i > N ) return 0;
        if(i == N) return 1;
        if(dp[i] != -1) return dp[i];
        return dp[i] = dfs(i+1) + dfs(i+2);
    }
}
