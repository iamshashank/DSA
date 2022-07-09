package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=lDYIvtBVmgo
 * Given a string, how many minimum splits would it take so that each partition after split is a palindrome
 * Variant of AllPossiblePartitionOfString, Hard_PalindromePartition under backtracking
 *
 */

public class PalindromePartition {
    public int process(String s){
        int l = s.length();
        int[][] dp = new int[l][l];
        for(int i=0;i<l;i++) Arrays.fill(dp[i] ,Integer.MAX_VALUE);
        // we will work diagonal by diagonal in top right matrix
        // fill the main diagonal, all string on main diagonal are of len 1 so already palindrome so it will take 0 splits to make them palindrome
        for(int i =0;i<l;i++){
            dp[i][i] = 0;
        }
        // 2nd diagonal all substring of len 2, if both char are equal then they are palindrome so 0 splits required
        // if not then 1 split required to make them of len 1, and then they will be palindrome
        for(int i =0;i<l-1;i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 0;
            }
            dp[i][i+1] = 1;
        }

        for(int i = 2;i<l;i++){
            for(int j=0;j<l-i;j++){
                int start = j;
                int end = j+i;
//                System.out.println(start + " "+ end);
                // the above 2 loops are for diagonal by diagoanl traversal
                if(palindrome(s, start, end)){
                    dp[start][end] = 0; // already a palindrome
                }else{
                    for(int v =start; v<end; v++){
                        dp[start][end] = Math.min(dp[start][end], 1 + dp[start][v] + dp[v+1][end]);
                    }
                }
            }
        }
//        for(int i=0;i<l;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[0][l-1];
    }

    boolean palindrome(String s, int i ,int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
