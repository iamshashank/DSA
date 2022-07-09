package com.company.dynamicprogramming;

/**
 *
 * https://www.youtube.com/watch?v=YDf982Lb84o
 *
 * 96. Unique Binary Search Trees
 * Medium
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 5
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 19
 */

public class UniqueBST {
    int N;
    int[] dp;
    public int numTrees(int n) {
        N = n;
        dp = new int[20];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        int t;
        for(int i =4;i<=n;i++){
            t = 0;
            for(int j=1;j<=i;j++){
                int elInLeft = j - 1;
                int elInRight = i-j;
                t += (dp[elInLeft] * dp[elInRight]);
            }
            dp[i] = t;
        }
        return dp[n];
    }

    public int countTreesRec(int numKeys) {
        if (numKeys <=1) {
            return(1);
        }
        else {
            int sum = 0;
            int left, right, root;
            for (root=1; root<=numKeys; root++) {
                left = countTreesRec(root - 1);
                right = countTreesRec(numKeys - root);
                sum += left*right;
            }
            return(sum);
        }
    }

}
