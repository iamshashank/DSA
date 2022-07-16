package com.company.string;

import java.util.Arrays;

/**
 * Partition String
 * You are given a string S of length N of digits 0 - 9. You need to partition strings into K substrings such that
 *
 *     Each substring has a minimum length of M
 *     Substring must start with even digit and ends with odd digit number
 *
 * Determine the number of ways to partition the strings which satisfy the above condition
 * You should find answer modulo 1e9 + 7
 *
 * constraints :
 * 1 <= n<= 2x10^3
 * 1<= m<= n
 * 1<=k<=n
 *
 * Test cases
 *
 * n = 9
 * m= 2
 * k = 3
 * s = '232387421'
 * So there are total 3 ways possible
 */

public class Google_PartitionString {
    int ans = 0, minLength;
    int[][] dp;
    public int partition(String s, int m, int k){
        minLength = m;
        dp = new int[s.length()+1][k+1];
        for(int i=0;i<s.length()+1;i++) Arrays.fill(dp[i], -1);
        return myLogic(s, 0, 0, k);
    }

    int helper(String s, int currIndex, int k){
        if(currIndex > s.length()) return 0;
        if(currIndex == s.length()){
            if(k == 0){
                return 1;
            }
            return 0;
        }

        if(dp[currIndex][k] != -1) return dp[currIndex][k];

        // we make sure that our substring is of minLength
        int i = currIndex+minLength-1; // last char of the current partition
        int count = 0;
        if(Integer.parseInt((s.charAt(currIndex)+""))%2 == 0) {
            while (i < s.length()) {
                // check if last char is odd then recursive call the new substring
                if (Integer.parseInt((s.charAt(i) + "")) % 2 != 0) {
                    // we need to make a decision
                    // split here
                    count += helper(s, i + 1, k - 1);
                    // not split here
                }
                i++;
            }
        }
        return dp[currIndex][k] = count;
    }

    int myLogic(String s, int len, int currIndex, int k){
        if(k == 0 && currIndex == s.length() && len >= minLength){
            return 1;
        }
        if(currIndex == s.length() || k == 0) return 0;
        if(Integer.parseInt((s.charAt(currIndex)+""))%2 != 0) return 0;
        if(dp[currIndex][k] != -1) return dp[currIndex][k];
        int i = currIndex;
        int count = 0;
        while(i < s.length()){
            if( Integer.parseInt((s.charAt(i)+""))%2 != 0 && (i-currIndex+1 >= minLength)){
                // we need to make a decision
                // split here
                count += myLogic(s, i-currIndex+1, i+1, k-1);
                // not split here
            }
            i++;
        }
        return dp[currIndex][k] = count;
    }

}
