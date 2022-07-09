package com.company;

/**
 *
 * 264. Ugly Number II
 * Medium
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 1690
 *
 */

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for(int i =1;i<n;i++){
            int m2 = dp[p2]*2;
            int m3 = dp[p3]*3;
            int m5 = dp[p5]*5;

            dp[i] = Math.min(Math.min(m2, m3), m5);
            if(dp[i] == m2) p2++; // for 6 both 2,3 are applicable
            if(dp[i] == m3) p3++; // for 6 both 2,3 are applicable
            if(dp[i] == m5) p5++;
        }
        return dp[n-1];
    }
}
