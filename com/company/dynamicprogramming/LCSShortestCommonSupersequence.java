package com.company.dynamicprogramming;

//https://leetcode.com/problems/shortest-common-supersequence/

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
 *
 * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 *
 * Example 2:
 *
 * Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
 * Output: "aaaaaaaa"
 *
 */

public class LCSShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int x = str1.length();
        int y = str2.length();
        int[][] dp = new int[x+1][y+1];
        // find out the LCS
        for(int i=1;i<x+1;i++){
            for(int j=1; j<y+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        // the trick is that what the Shortest Common Supersequence  is
        // if we find the LCS for it we will get the shortest supersequence
        int i = x;
        int j = y;

        StringBuilder s = new StringBuilder();
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                s.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i][j-1] > dp[i-1][j]){
                    s.append(str2.charAt(j-1));
                    j--;
                }else{
                    s.append(str1.charAt(i-1));
                    i--;
                }
            }
        }

        while(i>0){
            s.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            s.append(str2.charAt(j-1));
            j--;
        }
        return s.reverse().toString();
    }
}