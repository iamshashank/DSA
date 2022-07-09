package com.company.dbs_bfs_combined;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 *https://leetcode.com/problems/as-far-from-land-as-possible/
 *
 * 1162. As Far from Land as Possible
 * Medium
 *
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.
 *
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
 *
 * Example 2:
 *
 * Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 *
 */

public class AsFarAsFromLandAsPossible {
    int row, col;
    Queue<Pair> q;
    public int maxDistance(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1){
            return -1; // there can only be land or water
        }
        row = grid.length;
        col = grid[0].length;

        // find all land and put them in queue
        // This does not require full DFS to discover the land
        q = new LinkedList<>();
        for(int i =0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i,j));
                    grid[i][j] = 2; //mark it visited
                }
            }
        }
        if(q.size() == 0 || q.size() == row*col){
            // either all 1 or all 0
            return -1;
        }
        // now BFS
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int ans = 0;
        while(q.size()>0){
            int l = q.size();
            for(int i =0;i<l;i++){
                Pair e = q.remove();
                for(int j = 0;j<4;j++){
                    int x = e.i + dx[j];
                    int y = e.j + dy[j];
                    if(x >=0 && y >=0 && x < row && y < col && grid[x][y] == 0){
                        grid[x][y] = 2; // mark visited
                        q.add(new Pair(x,y));
                    }
                }
            }
            ans++; // this means we have check all location whichare are `1` distance away
        }
        return --ans;
    }

    class Pair{
        int i,j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}