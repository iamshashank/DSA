package com.company.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=BysNXJHzCEs
 *
 * a = 'abcdef'
 * b = 'gfcdevf
 * longest common substring is "cde" it should be continous
 * similar logic to LCS
 *
 */

public class LongestCommonSubString {
    public int process(String s1, String s2){
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length; j++){
                if(i == 1){
                    dp[i][j] = (s1.charAt(0) == s2.charAt(j-1)) ? 1 : 0;
                }else if(j == 1){
                    dp[i][j] = (s1.charAt(i-1) == s2.charAt(0)) ? 1 : 0;
                    continue;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
