package com.company.dynamicprogramming;

/**
 * 97. Interleaving String
 * Medium
 *
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 *     s = s1 + s2 + ... + sn
 *     t = t1 + t2 + ... + tm
 *     |n - m| <= 1
 *     The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 *
 * Note: a + b is the concatenation of strings a and b.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 * Example 3:
 *
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 */
public class Interleaving_String {
    String a, b, c;
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        a = s1;
        b = s2;
        c = s3;
        dp = new int[a.length()+1][b.length()+1];
        return helper(0, 0, 0);
    }

    boolean helper(int i, int j, int k){
        if(i == a.length() && j == b.length() && k == c.length()) return true;
        if(k == c.length()) return false;

        if(dp[i][j] == -1) return false;

        if(i < a.length() && a.charAt(i) == c.charAt(k)){
            if( helper(i+1, j, k+1) ) return true;
        }
        if(j < b.length() && b.charAt(j) == c.charAt(k)){
            if( helper(i, j+1, k+1) ) return true;
        }

        // solution not possible in this path
        dp[i][j] = -1;
        return false;
    }
}
