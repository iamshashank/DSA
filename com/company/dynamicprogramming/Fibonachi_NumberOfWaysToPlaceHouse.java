package com.company.dynamicprogramming;

/**
 * 2320. Count Number of Ways to Place Houses
 * Medium
 *
 * There is a street with n * 2 plots, where there are n plots on each side of the street. The plots on each side are numbered from 1 to n. On each plot, a house can be placed.
 *
 * Return the number of ways houses can be placed such that no two houses are adjacent to each other on the same side of the street. Since the answer may be very large, return it modulo 109 + 7.
 *
 * Note that if a house is placed on the ith plot on one side of the street, a house can also be placed on the ith plot on the other side of the street.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 4
 * Explanation:
 * Possible arrangements:
 * 1. All plots are empty.
 * 2. A house is placed on one side of the street.
 * 3. A house is placed on the other side of the street.
 * 4. Two houses are placed, one on each side of the street.
 *
 * Example 2:
 *
 * Input: n = 2
 * Output: 9
 * Explanation: The 9 possible arrangements are shown in the diagram above.
 */

public class Fibonachi_NumberOfWaysToPlaceHouse {
    /*

    n = 1
    0, 1    --> 2

    n = 2
    00, 01, 10  --> 3

    n = 3
    000, 001, 010, 100, 101 -->5

    n = 4
    0000, 0001, 0010, 0100, 1000, 0101, 1010, 1001 --> 8

    Above generated pattern is for fibonacci series

    Now, square them for the other side combination.

    */
    public int countHousePlacements(int n) {
        long a = 2, b = 3;
        if(n == 1) return 2*2;
        if(n == 2) return 3*3;
        // fibonacci series
        for(int i = 3;i<=n;i++){
            long t = (a + b)%1000000007;
            a = b;
            b = t;
        }

        return (int)((b*b)%1000000007);
    }
}
