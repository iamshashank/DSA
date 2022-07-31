package com.company.dynamicprogramming;

/**
 *
 * 338. Counting Bits
 * Easy
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * Example 2:
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 *
 * Constraints:
 *
 *     0 <= n <= 105
 */

public class CountingBits {

    /**

     In O(N) Time
     Let if we have X and Y in Such a way that,
     X/2 = Y
     then Number of set bits in X - Number of set bit in Y <= 1

     eg let X = 7and Y = 3
     then 7 / 2 = 3;

     7 -> 1 1 1 number of set bit are 3
     3 -> 0 1 1 number of set bit are 2

     there difference is 3 - 2 <= 1

     another eg
     X = 12 and y = 6
     then 12 / 2 = 6;

     12 -> 1100 number of set bit are 2
     6 -> 0110 number of set bit are 2

     there difference is 2 - 2 <= 1

     There can be 2 cases
     whether X is Odd or Even

     when X is odd then ans[X] = ans[X/2]+1
     when X is even then ans[X] = ans[X/2]

     0  0  -> 0
     1  1  -> 1

     2  10 -> 1
     3  11 -> 2

     4  100-> 1
     5  101-> 2
     6  110-> 2
     7  111-> 3


     8  1000->1
     9  1001->2
     10 1010->2
     11 1011->2
     12 1100->2
     13 1101->3
     14 1110->3
     15 1111->4


     */

    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n>0) dp[1] = 1;
        for(int i = 2;i<=n;i++){
            if(i%2 == 0){
                dp[i] = dp[i/2];
            }else{
                dp[i] = dp[i/2]+1;
            }
        }
        return dp;
    }
}
