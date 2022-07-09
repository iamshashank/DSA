package com.company.backtracking;

/**
 *
 * 1219. Path with Maximum Gold
 * Medium
 *
 * In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
 *
 * Return the maximum amount of gold you can collect under the conditions:
 *
 *     Every time you are located in a cell you will collect all the gold in that cell.
 *     From your position, you can walk one step to the left, right, up, or down.
 *     You can't visit the same cell more than once.
 *     Never visit a cell with 0 gold.
 *     You can start and stop collecting gold from any position in the grid that has some gold.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 *
 * Example 2:
 *
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 *
 */

public class Google_PathWithMaxGold {
    public int getMaximumGold(int[][] grid) {
        int l = grid.length, m = grid[0].length;
        int ans = 0;
        int[][] v = new int[l][m];
        for(int i =0;i<l;i++){
            for(int j =0;j<m;j++){
                ans = Math.max(ans, backtrack(grid, l, m, i, j, v));
            }
        }
        return ans;
    }

    public int backtrack(int[][] g, int l, int m, int i, int j, int[][] v){
        if(i >=0 && j >=0 && i < l && j< m && v[i][j] == 0 && g[i][j] != 0){
            v[i][j] = 1;
            int max = 0;
            // we can choose 1 direction as we cannot go back so choose max
            int left  = backtrack(g,l,m,i,j-1,v);
            int right = backtrack(g,l,m,i,j+1,v);
            int top  = backtrack(g,l,m,i-1,j,v);
            int down  = backtrack(g,l,m,i+1,j,v);
            max = Math.max(left, right);
            max = Math.max(max, top);
            max = Math.max(max, down);
            // undo visit for other runs
            v[i][j] = 0;
            return g[i][j]+ max;
        }
        return 0;
    }
}
