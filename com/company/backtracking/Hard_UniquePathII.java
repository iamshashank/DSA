package com.company.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 980. Unique Paths III
 * Hard
 *
 * You are given an m x n integer array grid where grid[i][j] could be:
 *
 *     1 representing the starting square. There is exactly one starting square.
 *     2 representing the ending square. There is exactly one ending square.
 *     0 representing empty squares we can walk over.
 *     -1 representing obstacles that we cannot walk over.
 *
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 *
 */

public class Hard_UniquePathII {
    int l,m;
    int[][] grid;
    int ans = 0;
    Set<String> s;
    int count = 0;
    public int uniquePathsIII(int[][] g) {
        grid = g;
        l = g.length;
        m = g[0].length;
        s = new HashSet<>();
        int a = 0,b = 0;
        for(int i=0;i<l;i++){
            for(int j=0; j<m;j++){
                if(g[i][j] == 1) {
                    a = i;
                    b = j;
                }
                if(g[i][j] == 0 || g[i][j] == 1) count++; // we have to walk over these many blocks
            }
        }

        ans = f(a,b);
        return ans;
    }

    int f(int i, int j){
        if(i < 0 || i >= l || j < 0 || j >= m || grid[i][j] == -1 || s.contains(i+"#"+j)) return 0;
        if(grid[i][j] == 2 && s.size() == count){
            return 1;
        }
        s.add(i+"#"+j);
        int top = f(i-1, j);
        int btm = f(i+1, j);
        int left = f(i, j-1);
        int right = f(i, j+1);
        s.remove(i+"#"+j);
        return top + btm + right + left;
    }
}
