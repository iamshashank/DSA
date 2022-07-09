package com.company.dynamicprogramming;

/**
 * This problem is similar to maximum area of square consisting of 1's.
 *
 * 1277. Count Square Submatrices with All Ones
 * Medium
 *
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 *
 */

public class CountSubmatrixWithAllOne {
    public int countSquares(int[][] m) {
        int l = m.length;
        int k = m[0].length;
        for(int i=1;i<l;i++){
            for(int j= 1;j<k;j++){
                if(m[i][j] == 1)
                    m[i][j] = Math.min(m[i-1][j-1] , Math.min(m[i-1][j], m[i][j-1])) + 1;
            }
        }
        int ans = 0;
        for(int i=0;i<l;i++){
            for(int j= 0;j<k;j++){
                ans += m[i][j];
            }
        }
        return ans;
    }
}
