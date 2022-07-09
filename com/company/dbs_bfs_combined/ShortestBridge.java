package com.company.dbs_bfs_combined;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 *https://leetcode.com/problems/shortest-bridge/
 * 934. Shortest Bridge
 * Medium
 *
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 *
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 */


public class ShortestBridge {
    Queue<Pair> q;
    public int process(int[][] a){
        int row = a.length;
        int col = a[0].length;

        q = new LinkedList<>();

        // since we dont know where any of the island are
        // we need to blindly search for any  `1` int the matrix and from there we can applly DFS to
        // push all elements of 1st island into the queue
        // in DFS we use stack to go to bottom of a node and then to next
        boolean oneFound = false;
        for(int i =0;i<row && !oneFound;i++) {
            for (int j = 0; j < col && !oneFound; j++) {
                if (a[i][j] == 1) {
                    oneFound = true;
                    dfs(a, row, col, i, j);
                    break;
                }
            }
        }
        // so till this point we have successfully pushed island 1 into queue
        // now using we will run bfs on each nodes of queue and see if we can hit the island 1
        // BFS's traversal special property is that it goes 1 level at a time instead of DFS which pick 1 node and goes into its depth
        // so we run BFS in pass and in 1st pass we will pop all elements of island 1 and push new nodes
        int[] dx = {1, -1, 0, 0 };
        int[] dy = {0, 0, 1, -1};
        int ans = 0;
        while(q.size() > 0){
            // each pass will represent how far we have moved ahead to look for next island
            // or how many 0 we have flipped
            // intially pass 0 means that we are still checking the nodes which are just next to nodes of the island
            // ideally you will not not find the ans in pass 0 because that will mean that islands were connected
            int len = q.size(); // this local variable is important
            for(int k = 0;k<len;k++){
                Pair t = q.remove();
                for(int l = 0; l<4;l++) {
                    int nx = t.i + dx[l], ny = t.j + dy[l];
                    // if we found 1 then we have hit the next island and found the ans
                    if (nx >= 0 && ny >= 0 && nx < row && ny < col && a[nx][ny] == 1)
                        return ans;
                    if (nx >= 0 && ny >= 0 && nx < row && ny < col && a[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        a[nx][ny] = 2; //mark visited
                    }
                }
            }
            // pass complete so increment `ans` by 1
            ans++;
        }
        return Integer.MAX_VALUE; // no 2nd island exists
    }

    // in this problem the only role is to push all elements of island 1 into queue
    private void dfs(int[][] a, int row, int col, int i, int j) {
        // we are using the parent array as visited array
        // if 2 then visited
        if(a[i][j] == 2)
            return;
        a[i][j] = 2; //mark it visited
        q.add(new Pair(i,j));
        int[] dx = {1, -1, 0, 0 };
        int[] dy = {0, 0, 1, -1};
        for(int k=0;k<4;k++) {
            int nx = i + dx[k], ny = j + dy[k];
            if (nx >= 0 && ny >= 0 && nx < row && ny < col && a[nx][ny] == 1) {
                dfs(a, row, col, nx, ny);
            }
        }
    }


    class Pair{
        int i,j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
