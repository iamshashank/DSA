package com.company.dynamicprogramming;

/**
 * 64. Minimum Path Sum
 * Medium
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 *
 * Constraints:
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m, n <= 200
 *     0 <= grid[i][j] <= 100
 */
public class MinimumPathSum {
     public int minPathSum1(int[][] grid) {
         // in this dp[i][j] = cost[i] + min(do[i-1][j], dp[i][j-1])
       int M = grid.length, N = grid[0].length;
       int[][] dp = new int[M][N];
       dp[0][0] = grid[0][0];
       for(int i=1;i<M; i++){
         dp[i][0] = dp[i-1][0] + grid[i][0];
       }
       for(int i=1;i<N; i++){
         dp[0][i] = dp[0][i-1] + grid[0][i];
       }
       for(int i=1;i<M; i++){
         for(int j =1; j<N;j++){
           dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
         }
       }
       return dp[M-1][N-1];
     }

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
                if(j-1 >= 0) left = grid[i][j-1];
                if(i-1 >= 0) top = grid[i-1][j];

                if(left == Integer.MAX_VALUE && top == Integer.MAX_VALUE){
                    left = 0;
                    top = 0;
                }

                grid[i][j] = grid[i][j] + Math.min(left, top);
            }
        }
        return grid[n-1][m-1];
    }
}
