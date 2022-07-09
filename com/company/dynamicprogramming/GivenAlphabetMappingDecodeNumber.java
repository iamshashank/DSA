package com.company.dynamicprogramming;

import java.util.Arrays;

//Using the following mapping, a message comprising characters from A to Z can be encoded into numbers:
//  'A' = "1" 'B" = "2"... 'Z" = "26"
//  To decode an encoded message, all of the digits must be gathered and then mapped back into letters using the opposite of the aforementioned mapping (there may be multiple ways).
//  For example, "11106" can be translated as follows:
//  "KJF" with the grouping (11-10-6)
//  "AAJF" with the grouping (1-1-10-6)
//  It should be noted that the grouping (1 11 06) is illegal since "06" cannot be mapped into 'F' because "6" differs from "06".
//  Return the number of ways to decode a string s that solely contains digits.
//
public class GivenAlphabetMappingDecodeNumber {
    int[] dp;
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return process(s.toCharArray(), 0);
    }

    int process(char[] c, int i){
        if(i >= c.length) return 1;
        if(c[i] == '0') return 0; // this is invalid path
        if(dp[i] != -1) return dp[i];

        // we only have 2 choice either take 1 char or 2 char
        int res = process(c, i+1);
        // try to take 2 char but we can only take it if its less than 27
        if(i+1 < c.length && Integer.valueOf(c[i]+""+c[i+1]) < 27){
            res += process(c, i+2);
        }
        return dp[i] = res;
    }
}
