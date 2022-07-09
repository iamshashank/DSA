package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 *
 *132. Palindrome Partitioning II
 * Hard
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * Example 2:
 *
 * Input: s = "a"
 * Output: 0
 *
 * Example 3:
 *
 * Input: s = "ab"
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 2000
 *     s consists of lowercase English letters only.
 *
 */

public class Hard_PalindromePartitionII {
    int[][] dp;

    public int minCut(String s) {
        int l = s.length();
        dp = new int[l][l];
        for(int i=0;i<l;i++) Arrays.fill(dp[i], -1);
        return dfs(s, 0, l-1);
    }

    // this is same problem as Hard_PalindromePartition in backtracking but there we had to store all partitions and for that we had to maintain arraylist and do backtracking
    // since here we only need to return min cuts we can use tabulation/DP and avaoid backtracking to improve performace
    int dfs(String s, int start, int end){
        if(start > end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        if(palindrome(s, start, end)) return 0;
        dp[start][end] = Integer.MAX_VALUE;
        for(int i = start;i<end;i++){
            if(palindrome(s, start, i)){
                dp[start][end] = Math.min(
                        dp[start][end],
                        1 + dfs(s, start, i) + dfs(s, i+1, end)
                );
            }
        }
        return dp[start][end];
    }

    boolean palindrome(String s, int i ,int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
