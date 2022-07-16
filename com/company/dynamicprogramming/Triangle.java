package com.company.dynamicprogramming;

import java.util.List;

/**
 *
 *
 * 120. Triangle
 * Medium
 *
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 *
 * Example 2:
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 *
 * Constraints:
 *
 *     1 <= triangle.length <= 200
 *     triangle[0].length == 1
 *     triangle[i].length == triangle[i - 1].length + 1
 *     -104 <= triangle[i][j] <= 104
 *
 *
 */

public class Triangle {
    List<List<Integer>> t;
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangles) {
        t = triangles;
        dp = new Integer[t.size()][t.size()];
        return process(0,0);
    }

    public int process(int row, int index){
        if(dp[row][index] != null) return dp[row][index];

        int sum = t.get(row).get(index);

        if(row < t.size()-1){
            sum += Math.min(process(row+1, index), process(row+1, index+1));
        }
        return dp[row][index] = sum;
    }


    int processClassic(int i, int j){
        if(i >= t.size()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int pathCost = Math.min( process(i+1, j), process(i+1, j+1) );
        return dp[i][j] = t.get(i).get(j) + pathCost;
    }

    public int minimumTotalBottomUp(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];

        for (int level=n-1; level>=0; level--)
            for (int i=0; i<=level; i++)
                dp[level][i] = triangle.get(level).get(i) + Math.min(dp[level+1][i], dp[level+1][i+1]);

        return dp[0][0];
    }

}
