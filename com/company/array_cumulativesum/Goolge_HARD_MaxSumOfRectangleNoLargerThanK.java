package com.company.array_cumulativesum;

import java.util.Arrays;
import java.util.TreeSet;

/**
 *
 * 363. Max Sum of Rectangle No Larger Than K
 * Hard
 *
 * Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
 *
 * It is guaranteed that there will be a rectangle with a sum no larger than k.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
 *
 * Example 2:
 *
 * Input: matrix = [[2,2,-1]], k = 3
 * Output: 3
 *
 */

public class Goolge_HARD_MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] m, int K) {
        // ane's algo
        int r = m.length, c = m[0].length;
        int[] a = new int[r]; // vertical column

        int max = Integer.MIN_VALUE;

        for(int i =0;i<c;i++){
            Arrays.fill(a, 0);
            for(int j=i;j<c;j++){
                for(int v =0;v<r;v++) a[v] += m[v][j];

                // now the special trick
                int sum = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int k=0;k<a.length;k++){
                    sum += a[k]; // cumulative sum
                    Integer upperBound = set.ceiling(sum-K); // upper bound equal to the number or next largest in the set
                    if(upperBound != null) max = Math.max(max, sum - upperBound);
                    set.add(sum);
                }
                // end of trick
            }
        }
        return max;
    }
}
