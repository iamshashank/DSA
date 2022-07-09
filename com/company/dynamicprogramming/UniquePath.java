package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 *
 * 62. Unique Paths
 * Medium
 *
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 *
 *
 *
 * Example 1:
 *
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 */

public class UniquePath {
    int c = 0;
    int x,y;
    int[][] dp;
    public int uniquePaths(int m, int n) {
        x = m;
        y = n;
        dp = new int[101][101];
        for(int i=0;i< 101;i++) Arrays.fill(dp[i], -1);
        dp[0][0] = dfs(0,0);
        return dp[0][0];
    }

    int dfs(int i, int j){
        if(i == x || j == y) return 0;
        if(i == x-1 && j == y-1){
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = dfs(i, j+1) + dfs(i+1, j);
    }
}
