package com.company;

/**
 * Problem Statement:
 *
 * You are given the following
 *
 *     An integer N
 *     String A consisting lowercase English alphabets having length N
 *
 * For any string T, you calculate the distinct characters appearing in the string and store them in the set S. for example say T = "aabeec" , then S = {a , b , c , e}
 *
 * Two sets of characters are different if and only if there is atleast one character in either of the set which is not present in other set.
 *
 * For example, say T = "ab" and G = "bc", then set of both the string are not same as 'c' is not present in set of string T. On the other hand , if T ="ab" and G = "aab" , then sets for both the string are same.
 *
 * Task:
 *
 * Consider all the substrings of string A. For each subtsring U , determine the set Su. Determine the number of distinct sets that can be obtained.
 *
 * Constraints: 1<=N<=100000
 */

public class Google_MathTrick {
    /**
     *
     * This is a simple Arithmetic Progression
     * We have created distinct sets from substring and not subsequence, which means we cannot skip characters in between
     * String = "qhopzpqli"    SET = {q, h, o, p ,z, l, i}
     * So this problem becomes how many sliding windows can we make from size 1 to len(SET)
     * N - window of len 1
     * N-1 window of len 2 ...... 1 window of len N
     * Add all this 1 + 2 + ... + N-1 + N = SUM OF AP   N/2(2*A + (N-1)D) in this case D = 1 so ans is 7/2(2+6) = 28
     *
     *
     * IF IN THIS QUSETION INSTEAD OF substring we had to use subsequence that means we could have skipped elements in between
     * then problem would have converted to SUM OF COMBINATION SERIES nC1 + nC2 + . . . + nC n = 2^n - 1
     *
     *
     */
}
