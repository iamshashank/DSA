package com.company.dbs_bfs_combined;

import java.util.LinkedList;
import java.util.Queue;

/**
 *https://leetcode.com/problems/rotting-oranges/
 *
 * 994. Rotting Oranges
 * Medium
 *
 * You are given an m x n grid where each cell can have one of three values:
 *
 *     0 representing an empty cell,
 *     1 representing a fresh orange, or
 *     2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 *
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 */

public class AmazonRottenTomato {
    int row, col;
    public int orangesRotting(int[][] g) {
        row = g.length;
        col = g[0].length;
        int numberOfGoodOrange = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int  i = 0;i<row;i++){
            for(int j =0;j<col;j++){
                // find all rotten
                if(g[i][j] == 2){
                    q.add(new Pair(i,j));
                    g[i][j] = 3;//visited
                }
                if(g[i][j] == 1) numberOfGoodOrange++;
            }
        }
        if(q.size() == 0 && numberOfGoodOrange != 0) return -1; // these are the trickly edge cases
        if(q.size() == 0 && numberOfGoodOrange == 0) return 0; // these are the trickly edge cases

        // BFS
        int ans = 0;
        int[] di = {1,-1,0,0};
        int[] dj = {0,0,1,-1};
        while(q.size()>0){
            int l = q.size();
            for(int i=0;i<l;i++){
                Pair t = q.remove();
                for(int v = 0;v<4;v++){
                    int x = t.i + di[v];
                    int y = t.j + dj[v];
                    if(x>=0 && x <row && y >=0 && y<col && g[x][y] == 1){
                        q.add(new Pair(x,y)); // its rottern
                        numberOfGoodOrange--;
                        g[x][y] = 3; // visited
                    }
                    if(x>=0 && x <row && y >=0 && y<col && g[x][y] == 0){
                        g[x][y] = 3; // visited
                    }
                }
            }
            ans++;
        }
        if(numberOfGoodOrange != 0) return -1;
        return ans-1;
    }

    class Pair{
        int i,j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}