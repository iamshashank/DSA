package com.company.dynamicprogramming;

// dynamic programming
public class LongestPalindromeSubstring {
    public int process(String s){
        int largestLength = 0;
        // maintain a 2d array of s.length size
        int[][] dp = new int[s.length()][s.length()];

        // only top right section of the diagonal is needed
        // the below loops runs diagonally
        for(int i = 0; i < s.length();i++){
            for(int j=0; j < s.length() - i; j++){
                int x = j;
                int y = j + i;

                if(x==y){
                    // base condition
                    // main diagonal is always 1 as substring of length 1 is always palindrome
                    dp[x][y] = 1;
                }else if((y-x+1) == 2){
                    // base condition
                    // substring of length 2 is only palindrome of both characters are same
                    // index starts from 0 so that is why y-x == 1
                    if(s.charAt(x) == s.charAt(y)){
                        dp[x][y] = 1;
                    }else{
                        dp[x][y] = 0;
                    }
                }else {
                    // for other diagonals
                    // dp[x][y] = (dp[x+1][y-1]) && (character-at[x] == character-at[y])
                    if(dp[x+1][y-1] == 1 && s.charAt(x) == s.charAt(y)){
                        dp[x][y] = 1;
                    }else{
                        dp[x][y] = 0;
                    }
                }

                if( dp[x][y] == 1 && (y-x) + 1 > largestLength){
                    largestLength = (y - x) + 1;
                }
            }
        }

        return largestLength;
    }
}
