package com.company.dynamicprogramming;

//Given  a m*n matrix traverse from top left to bottom right
//Hoe many unique path to traverse exists

public class UniqueWaysToTraverseToEndOfMatrix {
    public int process(int X, int Y){
        int dp[][] = new int[X][Y];
        // base case row 0 is always 1 & col 0 is always 1
        // rest is dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for(int i =0; i<X; i++){
            for(int j = 0; j< Y;j++){
                if(i==0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[X-1][Y-1];
    }
}
