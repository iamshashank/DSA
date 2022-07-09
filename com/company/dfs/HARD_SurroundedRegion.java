package com.company.dfs;

/**
 *https://leetcode.com/problems/surrounded-regions/
 * 130. Surrounded Regions
 * Medium
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 */

public class HARD_SurroundedRegion {
    char[][] b;
    int l,m;
    public void solve(char[][] board) {
        b = board;
        l = b.length;
        m = b[0].length;
        for(int i =0;i<l;i++){
            for(int j=0;j<m;j++){
                // we run dfs on nodes which are on boundary and 'O'
                if(b[i][j] == 'O' && ( i==0 || j==0 || i==l-1 || j == m-1) ){
                    // System.out.println(i+" "+j);
                    dfs(i,j);
                }
            }
        }

        // for(int i=0;i<l;i++){
        //     System.out.println(Arrays.toString(b[i]));
        // }

        // what we have essentially done is put # on all nodes which were 'O' but can reach the edge so they will not be in soution
        for(int i=0;i<l;i++){
            for(int j=0;j<m;j++){
                if(b[i][j] == '#')
                    b[i][j] = 'O';
                else if(b[i][j] == 'O')
                    b[i][j] = 'X';
            }
        }
        return;
    }

    public void dfs(int i, int j){
        if(i<0 || i>l-1 || j<0 || j>m-1 || b[i][j] == 'X' || b[i][j] == '#') return;
        b[i][j] = '#';
        dfs(i,j-1);
        dfs(i-1,j);
        dfs(i+1,j);
        dfs(i,j+1);
        return;
    }
}
