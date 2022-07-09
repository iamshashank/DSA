package com.company.dynamicprogramming;

/**
 *
 *
 *
 * 329. Longest Increasing Path in a Matrix
 * Hard
 *
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 * [ 9, 9, 4]
 * [ 6, 6, 8]
 * [ 2, 1, 1]
 *
 * Example 1:
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 *
 *
 */


public class LongestIncreasingPathInmatrix {
    int r, c; // row, column
    int[][] dp;
    public int longestIncreasingPath(int[][] a) {
        r = a.length;
        if(r == 0) return 0;
        c = a[0].length;
        dp = new int[r][c];
        int ans = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans = Math.max(ans, longestPath(a, i, j));
            }
        }
        return ans;
    }

    public int longestPath(int[][] a, int i, int j){
        if(dp[i][j] != 0 ) return dp[i][j];

        int left = 0, right =0, top = 0, bottom = 0;
        if(valid(i,j-1) && a[i][j] < a[i][j-1])
            left = longestPath(a, i, j-1);
        if(valid(i,j+1) && a[i][j] < a[i][j+1])
            right = longestPath(a, i, j+1);
        if(valid(i-1,j) && a[i][j] < a[i-1][j])
            top = longestPath(a, i-1, j);
        if(valid(i+1,j) && a[i][j] < a[i+1][j])
            bottom = longestPath(a, i+1, j);

        dp[i][j] = Math.max(left, Math.max(right, Math.max(top, bottom))) + 1;
        return dp[i][j];
    }

    public boolean valid(int i, int j){
        return (i < r && i>=0 && j<c && j >= 0);
    }
}
