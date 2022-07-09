package com.company.bfs_priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1631. Path With Minimum Effort
 * Medium
 *
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 *
 * Example 2:
 *
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
 *
 * Example 3:
 *
 * Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 * Explanation: This route does not require any effort.
 */
public class Google_PathWithMinEffort {
    public int minimumEffortPath(int[][] h) {
        int l = h.length, m = h[0].length;
        boolean[][] v = new boolean[l][m];
        for(int i =0;i<l;i++) Arrays.fill(v[i], false);
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)->{ return a.w-b.w; });
        q.add(new Pair(0, 0 , 0));

        int[] dx = new int[]{-1, 1, 0 ,0};
        int[] dy = new int[]{0, 0, 1 , -1};


        while(!q.isEmpty()){
            Pair p = q.remove();
            if(v[p.i][p.j]) continue;
            v[p.i][p.j] = true;

            if(p.i == l-1 && p.j == m-1) return p.w;
            for(int i = 0; i<4;i++){
                int x = p.i+dx[i];
                int y = p.j+dy[i];
                if(x>=0 && y>=0 && x<l && y<m && !v[x][y]){
                    q.add(new Pair(x,y, Math.max(p.w, Math.abs(h[x][y] - h[p.i][p.j]))));
                }
            }
        }
        return 0;
    }

    private class Pair{
        public int i,j,w;
        Pair(int i, int j, int w){
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }
}
