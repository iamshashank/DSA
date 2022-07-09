package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * 887. Super Egg Drop
 * Hard
 *
 * You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
 *
 * You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.
 *
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
 *
 * Return the minimum number of moves that you need to determine with certainty what the value of f is.
 *
 *
 *
 * Example 1:
 *
 * Input: k = 1, n = 2
 * Output: 2
 * Explanation:
 * Drop the egg from floor 1. If it breaks, we know that f = 0.
 * Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
 * If it does not break, then we know f = 2.
 * Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
 *
 * Example 2:
 *
 * Input: k = 2, n = 6
 * Output: 3
 *
 * Example 3:
 *
 * Input: k = 3, n = 14
 * Output: 4
 */

public class Hard_SuperEggDrop {
    int[][] dp;
    public int superEggDrop(int egg, int n) {
        dp = new int[n+1][egg+1]; // to avoid zero index nonsense
        for(int i=0;i<n+1;i++) Arrays.fill(dp[i], -1);
        int ans = solve(n, egg);
        return ans;
    }

    int solve(int n, int e){
        if(e == 1 || n == 1 || n == 0) return n;

        if(dp[n][e] != -1) return dp[n][e];
        int min = Integer.MAX_VALUE;
        int l = 1, r = n; // we will choose a floor using binary search to drop the egg
        while(l<=r){
            int mid = (l+r)/2;
            int eggBroken = solve(mid-1, e-1); // look on lower floors
            int eggNotBroken = solve(n-mid, e); //look on upper floors
            if(eggBroken < eggNotBroken){
                // we need to move toward the worse/higher solution
                l = mid+1;
            }else{
                // we need to move toward the worse/higher solution
                r = mid -1;
            }
            min = Math.min(min, 1 + Math.max(eggBroken, eggNotBroken)); // best among the worse
        }
        return dp[n][e] = min;
    }
}
