package com.company.dfs;

/**
 *
 * 200. Number of Islands
 * Medium
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 */

public class CountNumberOfIsland {
    int[][] v;
    int l,m;
    int ans = 0;
    char[][] g;
    int cc = 0;
    public int numIslands(char[][] grid) {
        l = grid.length;
        m = grid[0].length;
        g = grid;
        v = new int[l][m];

        for(int i = 0;i<l;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && v[i][j] == 0 ){
                    ans++;
                    dfs(i,j);
                    // System.out.println(cc);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j){
        if(i < 0 || i > l-1 || j <0 || j > m-1 || g[i][j] == '0' || v[i][j] == 1 ) return;
        v[i][j] = 1;
        cc++;
        // right
        dfs(i, j+1);
        // down
        dfs(i+1, j);
        // left
        dfs(i, j-1);
        // up
        dfs(i-1, j);
        return;
    }
}
