package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 *
 * 63. Unique Paths II
 * Medium
 *
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 *
 *
 *
 * Example 1:
 *
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Example 2:
 *
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 */

public class UniquePathWithObstacle {
    int[][] dp;
    int x,y;
    public int uniquePathsWithObstacles(int[][] g) {
        x = g.length;
        y = g[0].length;
        dp = new int[x][y];
        for(int i =0;i<x;i++) Arrays.fill(dp[i], -1);
        return dp[0][0] = dfs(g, 0, 0);
    }

    int dfs(int[][] g, int i, int j){
        // 1 is obstacle
        if(i == x || j == y || g[i][j] == 1) return 0;

        if(i == x-1 && j == y-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        int down = dfs(g, i+1, j);
        int right = dfs(g, i, j+1);
        return dp[i][j] = down + right;
    }
}
