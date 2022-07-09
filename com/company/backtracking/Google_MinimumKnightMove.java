package com.company.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Google_MinimumKnightMove {
    public int process(int x, int y){
        // offset everything by +4 +4
        int offset = 400;
        int l = 2*offset;
        x = x+offset;
        y = y + offset;
        int dp[][] = new int[l][l];
        int v[][] = new int[l][l]; // visited
        for(int i =0;i<l;i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[offset][offset] = 0;
        v[offset][offset] = 1;//visited
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{offset, offset}); // add location of knight to queue
        // BFS
        int[][] moves = new int[][]{
                {-2, -1}, {-2, 1},
                {2,  -1},  {2,  1},
                {-1,  2},  {1,  2},
                {-1, -2}, {1, -2}
        };
        while(q.size() > 0) {
            int[] point = q.remove();
            for(int i = 0;i<8;i++){
                int ix = point[0] + moves[i][0];
                int iy = point[1] + moves[i][1];
                if(ix >=0 && ix<l && iy >= 0 && iy < l && v[ix][iy] == 0 ){
                    q.add(new int[]{ix, iy});
                    dp[ix][iy] = Math.min(dp[ix][iy], dp[point[0]][point[1]] + 1);
                    v[ix][iy] = 1; //visited
                }
            }
            // the logic is that bfs will travel each cell in smallest number of moves
            // as soon as we find the ans we return
            if (v[x][y] == 1)
                return dp[x][y];
        }
        // if answer not fount in lopp then it does not exist
        return -1;
    }
}
