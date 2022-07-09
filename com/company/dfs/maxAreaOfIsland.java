package com.company.dfs;

/**
 * 695. Max Area of Island
 * Medium
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 *
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 */

public class maxAreaOfIsland {
    int[][] g;
    int l,m;
    int[][] v;
    int ans = 0;
    public int maxAreaOfIsland(int[][] grid) {
        l = grid.length;
        m = grid[0].length;
        g = grid;
        v = new int[l][m];
        for(int i=0;i<l;i++){
            for(int j=0;j<m;j++){
                if(g[i][j] == 1 && v[i][j] == 0){
                    ans = Math.max(ans, dfs(i,j));
                }
            }
        }
        return ans;
    }

    int dfs(int i, int j){
        if(i<0 || i>l-1 || j<0 || j>m-1 || v[i][j] == 1 || g[i][j] == 0){
            return 0;
        }
        v[i][j] = 1;
        return 1 + dfs(i-1,j) + dfs(i+1,j) + dfs(i,j-1) +dfs(i,j+1);
    }
}
