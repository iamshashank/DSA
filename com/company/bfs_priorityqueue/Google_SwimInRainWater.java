package com.company.bfs_priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 778. Swim in Rising Water
 * Hard
 *
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
 *
 * The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 *
 * Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 *
 * Example 2:
 *
 * Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation: The final route is shown.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 *
 *
 *
 * Constraints:
 *
 *     n == grid.length
 *     n == grid[i].length
 *     1 <= n <= 50
 *     0 <= grid[i][j] < n2
 *     Each value grid[i][j] is unique.
 */

public class Google_SwimInRainWater {
    public int swimInWater(int[][] grid) {
        int l = grid.length, m = grid[0].length;

        boolean[][] v = new boolean[grid.length][grid[0].length];
        for(int i =0;i<l;i++) Arrays.fill(v[i], false);

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)->{ return a.t - b.t; }); // ascending order

        q.add(new Pair(0, 0, grid[0][0]));

        int[] dx = new int[]{-1, +1, 0, 0};
        int[] dy = new int[]{0, 0, -1, +1};

        while(!q.isEmpty()){
            Pair p = q.remove();
            // if visited then continue
            if(v[p.i][p.j]) continue;
            v[p.i][p.j] = true;

            if(p.i == l-1 && p.j == m-1) return p.t; // we reached the end

            for(int i = 0; i<4 ; i++){
                int x = p.i + dx[i];
                int y = p.j + dy[i];

                if( x >= 0 && x < l && y >= 0 && y < m && !v[x][y]){
                    q.add(new Pair(x, y , Math.max(p.t, grid[x][y]))); // jitna time elapsed ho gaya hai utna water level ho chuka hai every where so take max
                }
            }

        }
        return 0;
    }

    private class Pair{
        public int i, j, t;
        Pair(int i ,int j, int t){
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
}
