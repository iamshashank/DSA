package com.company.dynamicprogramming;

/**
 * 583. Delete Operation for Two Strings
 * Medium
 *
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 *
 * Example 2:
 *
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 */


public class DeleteOperationOn2String {
    // LCS least common subsequence
    public int minDistance(String a, String b) {
        int l = a.length()+1, m = b.length()+1;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[l][m];
        for(int i=1;i<l;i++){
            for(int j=1;j<m;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        int x = a.length() + b.length();
        return x - 2*max;
    }
}
