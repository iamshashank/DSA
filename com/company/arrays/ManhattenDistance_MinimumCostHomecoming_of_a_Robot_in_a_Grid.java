package com.company.arrays;

/**
 *
 * 2087. Minimum Cost Homecoming of a Robot in a Grid
 * Medium
 *
 * There is an m x n grid, where (0, 0) is the top-left cell and (m - 1, n - 1) is the bottom-right cell. You are given an integer array startPos where startPos = [startrow, startcol] indicates that initially, a robot is at the cell (startrow, startcol). You are also given an integer array homePos where homePos = [homerow, homecol] indicates that its home is at the cell (homerow, homecol).
 *
 * The robot needs to go to its home. It can move one cell in four directions: left, right, up, or down, and it can not move outside the boundary. Every move incurs some cost. You are further given two 0-indexed integer arrays: rowCosts of length m and colCosts of length n.
 *
 *     If the robot moves up or down into a cell whose row is r, then this move costs rowCosts[r].
 *     If the robot moves left or right into a cell whose column is c, then this move costs colCosts[c].
 *
 * Return the minimum total cost for this robot to return home.
 *
 *
 *
 * Example 1:
 *
 * Input: startPos = [1, 0], homePos = [2, 3], rowCosts = [5, 4, 3], colCosts = [8, 2, 6, 7]
 * Output: 18
 * Explanation: One optimal path is that:
 * Starting from (1, 0)
 * -> It goes down to (2, 0). This move costs rowCosts[2] = 3.
 * -> It goes right to (2, 1). This move costs colCosts[1] = 2.
 * -> It goes right to (2, 2). This move costs colCosts[2] = 6.
 * -> It goes right to (2, 3). This move costs colCosts[3] = 7.
 * The total cost is 3 + 2 + 6 + 7 = 18
 *
 */


/**
 * This is problem for greedy aproach but since we used amnhatten distance
 */
public class ManhattenDistance_MinimumCostHomecoming_of_a_Robot_in_a_Grid {
    // manhatten distance
    public int minCost(int[] sp, int[] hp, int[] rc, int[] cc) {
        int dx = (sp[0] < hp[0]) ? 1 : -1;
        int dy = (sp[1] < hp[1]) ? 1 : -1;
        int c = 0;
        // few obeservations since all cost are positive
        // if you look we will realize that you need to go from x1 to x2 for that at min you need to travel |x1-x2| blocks same for columns
        // you need to at min travel |y1-y2| blocks
        for(int i = sp[0];i!=hp[0]; i+= dx){
            c += rc[i+dx];
        }
        for(int i = sp[1];i!=hp[1]; i+= dy){
            c += cc[i+dy];
        }
        return c;
    }
}
