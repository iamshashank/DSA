package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * 2304. Minimum Path Cost in a Grid
 * Medium
 *
 * You are given a 0-indexed m x n integer matrix grid consisting of distinct integers from 0 to m * n - 1. You can move in this matrix from a cell to any other cell in the next row. That is, if you are in cell (x, y) such that x < m - 1, you can move to any of the cells (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1). Note that it is not possible to move from cells in the last row.
 *
 * Each possible move has a cost given by a 0-indexed 2D array moveCost of size (m * n) x n, where moveCost[i][j] is the cost of moving from a cell with value i to a cell in column j of the next row. The cost of moving from cells in the last row of grid can be ignored.
 *
 * The cost of a path in grid is the sum of all values of cells visited plus the sum of costs of all the moves made. Return the minimum cost of a path that starts from any cell in the first row and ends at any cell in the last row.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
 * Output: 17
 * Explanation: The path with the minimum possible cost is the path 5 -> 0 -> 1.
 * - The sum of the values of cells visited is 5 + 0 + 1 = 6.
 * - The cost of moving from 5 to 0 is 3.
 * - The cost of moving from 0 to 1 is 8.
 * So the total cost of the path is 6 + 3 + 8 = 17.
 */

public class Wierd_MinCostPathInGrid {
    int m,n;
    int[][] grid, moveCost, dp;
    public int minPathCost(int[][] g, int[][] mc) {
        grid = g;
        moveCost = mc;
        m = g.length;
        n = g[0].length;
        dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i], -1);
        int min = Integer.MAX_VALUE;
        // we start from each pos in first row and find the min from that
        for(int j = 0;j<n;j++){
            dp[0][j] = dfs(0, j);
            min = Math.min(min, dp[0][j]);
        }
        return min;
    }

    int dfs(int i, int j){
        if(i > m-1){
            return Integer.MAX_VALUE;
        }
        if(i == m-1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        // we try to go to every column and see what is the minimum we can get
        for(int k=0;k<n;k++){
            int pos = grid[i][j];
            min = Math.min(min, dfs(i+1, k) + grid[i][j] + moveCost[pos][k]);
        }
        return dp[i][j] = min;
    }
}
