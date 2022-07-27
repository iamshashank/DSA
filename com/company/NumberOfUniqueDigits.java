package com.company;

/**
 * 357. Count Numbers with Unique Digits
 * Medium
 *
 * Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
 *
 * Example 2:
 *
 * Input: n = 0
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     0 <= n <= 8
 */

public class NumberOfUniqueDigits {

    /*
		 Consider numbers with  some length say strictly 4 e.g.  i.e. their range would be 1000-9999
		 consider 1st Digit is left most difit
		 1st digit can take 9 possible values ( 1-9) since there are no leading 0s
		 2nd digit can take 9 possible values (0-9 except the one taken in 1st digit)
		 3rd digit can take 8 possible values
		 4th digit can take 7 possible values
		 so total number of unique numbers in this range would be 9*9*8*7
		 use this approach to calculate the final value in the problem statement
		 * 		0 -> 1
		 *  1-9 -> 9
		 *  10-99-> 9*9 = 81
		    100-999 -> 9 * 9 * 8 + 9 * 9 + 9 + 1
		    1000-9999 -> 9 * 9 * 8 * 7 +  9 * 9 * 8 + 9 * 9 + 9 + 1
		*/

    public int countNumbersWithUniqueDigits(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        if(n > 0) dp[1] = dp[0] + 9;
        if(n > 1) dp[2] = dp[1] + 9*9;
        int i = 3;
        while(i <= n){
            int t = 81;
            for(int j=3;j<=i;j++){
                t = t * (10-j+1);
            }

            dp[i] = dp[i-1] + t;
            i++;
        }
        return dp[n];
    }

}
