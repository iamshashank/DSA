package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * 576. Out of Boundary Paths
 * Medium
 *
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 *
 * Example 2:
 *
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 *
 *
 *
 * Constraints:
 *
 *     1 <= m, n <= 50
 *     0 <= maxMove <= 50
 *     0 <= startRow < m
 *     0 <= startColumn < n
 */

public class OutOfBoundaryPath {
    int maxMoves, m, n;
    long[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        this.maxMoves = maxMove;
        dp = new long[m][n][maxMove+1];
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++) Arrays.fill(dp[i][j], -1);
        }
        // return dfs(startRow, startColumn, 0);
        return (int)dfs(startRow, startColumn, 0);
    }

    long dfs(int i, int j, int moves){
        if((i<0 || i>=m || j>=n || j<0) && moves <= maxMoves){
            return 1;
        }

        if(i<0 || i>=m || j>=n || j<0 || moves > maxMoves) return 0;
        if(dp[i][j][moves] != -1) return dp[i][j][moves];
        return dp[i][j][moves] = (dfs(i+1, j, moves+1) + dfs(i-1, j, moves+1) + dfs(i, j+1, moves+1) + dfs(i, j-1, moves+1))%1000000007;
    }
}
