package com.company.binarysearch;

import java.util.Arrays;

/**
 * 1970. Last Day Where You Can Still Cross
 * Hard
 *
 * There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.
 *
 * Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).
 *
 * You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).
 *
 * Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
 *
 *
 *
 * Example 1:
 *
 * Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
 * Output: 2
 * Explanation: The above image depicts how the matrix changes each day starting from day 0.
 * The last day where it is possible to cross from top to bottom is on day 2.
 *
 * Example 2:
 *
 * Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
 * Output: 1
 * Explanation: The above image depicts how the matrix changes each day starting from day 0.
 * The last day where it is possible to cross from top to bottom is on day 1.
 *
 * Example 3:
 *
 * Input: row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
 * Output: 3
 * Explanation: The above image depicts how the matrix changes each day starting from day 0.
 * The last day where it is possible to cross from top to bottom is on day 3.
 */

public class Hard_LastDayYouCanStillCross {
    int[][] dp;
    int l, m;
    public int latestDayToCross(int row, int col, int[][] cells) {
        l = row; m = col;
        dp = new int[l][m];
        for(int i=0;i<cells.length;i++) {
            int[] t = cells[i];
            dp[t[0]-1][t[1]-1] = i+1; // this tell on which day which cell was flodded
            // then when we traverse we can check if currDay < dp[i][j] that means that cell has not been floded yet
        }

        int l = 0, r = cells.length;
        int ans = 0;
        while(l<=r){
            int mid = (l+r)/2;
            if(canStillTravel(mid)){
                ans = mid;
                // try to do better
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }

    private boolean canStillTravel(int day){
        boolean[][] v = new boolean[l][m];
        for(int i=0;i<l;i++) Arrays.fill(v[i], false);
        for(int i=0;i<m;i++){
            boolean t = dfs(0, i, v, day);
            if(t) return true;
        }
        return false;
    }

    private boolean dfs(int i, int j , boolean[][] v, int day){
        if(i<0 || j<0 || i>l-1 || j>m-1 || dp[i][j] <= day || v[i][j]) return false;
        v[i][j] = true;
        if(i == l-1) return true;

        return dfs(i-1, j, v, day) || dfs(i+1, j, v, day) || dfs(i, j+1, v, day) || dfs(i, j-1, v, day);
    }
}
