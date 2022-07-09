package com.company.dynamicprogramming;

public class GivenSomeOperationConvertString1IntoString2 {
//    https://www.scaler.com/topics/data-structures/2d-dp-problems/
//    Given two strings str1 and str2 and a few operations that can be performed on str1, the task is to find the minimum number of operations required to convert str1 to str2. Operations:
//    Insert, Delete, Replace.
//    dp[i][j]=1+min(dp[i−1][j],dp[i][j−1],dp[i−1][j−1])

        public int process(String s1, String s2, int N, int M){
            int dp[][] = new int[N+1][M+1];
            for(int i=0; i<= N; i++){
                for(int j =0; j<= M; j++){
                    if(i == 0){
                        dp[i][j] = j;
                    }else if(j == 0){
                        dp[i][j] = i;
                    }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = 1 + Math.min(
                                Math.min(
                                        dp[i-1][j-1], // replacement, in this remaining characters to be scanned decreases by 1 in both
                                        dp[i-1][j]    // delete, in this size of s1 decreases by 1
                                ),
                                dp[i][j-1] );         // insert, in this 1 new element is added to s1 so elements remaining to be searched remain same in s1 but decreases in s2 by 1
                    }
                }
            }
            return dp[N][M];
        }
}
