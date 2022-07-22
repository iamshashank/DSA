package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=lSOsKhQc_VI
 * 174. Dungeon Game
 * Hard
 *
 * The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
 *
 * To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 * Return the knight's minimum initial health so that he can rescue the princess.
 *
 * Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 *
 *
 *
 * Example 1:
 *
 * Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
 * Output: 7
 * Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * Example 2:
 *
 * Input: dungeon = [[0]]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     m == dungeon.length
 *     n == dungeon[i].length
 *     1 <= m, n <= 200
 *     -1000 <= dungeon[i][j] <= 1000
 */
public class Hard_DungeonGame_II {
    int n,m;
    int[][] dp;
    public int calculateMinimumHP(int[][] dg) {
        n = dg.length;
        m = dg[0].length;
        dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++) Arrays.fill(dp[i], -1);
        int ans = dfs(dg, 0, 0);
        return ans;
    }


    int dfs(int[][] dg, int i, int j){
        if(i >= n || j >= m) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == n-1 && j == m-1){
            if(dg[i][j] > 0){
                return dp[i][j] = 1;
            }else{
                return dp[i][j] = 1 - dg[i][j];
            }
        }

        int health = 1; // at min we need this health

        // hum i,j pe khade hai aur ye dekhenge ki right or down kis path se jaane ke liye we need less health
        int right = dfs(dg, i, j+1);
        int bottom = dfs(dg, i+1, j);
        int min = Math.min(right, bottom);

        // ab we need to see ki i,j pe ane ke liye kitni health chaheye
        if(health + dg[i][j] - min > 0){
            health = 1;
        }else{
            health = (1 - dg[i][j]) + min -1;
        }
        return dp[i][j] = health;
    }
}
