package com.company.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 *
 *     Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 *     Each vowel 'a' may only be followed by an 'e'.
 *     Each vowel 'e' may only be followed by an 'a' or an 'i'.
 *     Each vowel 'i' may not be followed by another 'i'.
 *     Each vowel 'o' may only be followed by an 'i' or a 'u'.
 *     Each vowel 'u' may only be followed by an 'a'.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 5
 * Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
 *
 * Example 2:
 *
 * Input: n = 2
 * Output: 10
 * Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 *
 * Example 3:
 *
 * Input: n = 5
 * Output: 68
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 2 * 10^4
 *
 */

public class CountVowelPermutation {

    /**
     * This is  simple meoization question but the trick is to optimise memory, passing lots of sting in resucrsion will give meory limit exceed
     * so use int to represent 5 vowels
     * Also dont use map to avoid memory limit use simple array
     */

    int max = 1000000007;
    // HashMap<String, Integer> map;
    int[][] map;
    public int countVowelPermutation(int n) {
        // set = new HashSet<>();
        // map = new HashMap<>();
        map = new int[5][20000];
        for(int i=0;i<5;i++) Arrays.fill(map[i], -1);
        int ans = (((((process(n-1, 0) % max) + (process(n-1, 1) % max))%max +
                (process(n-1, 2) % max))%max+ (process(n-1, 3) % max))%max + (process(n-1, 4) % max));
        return (ans%max);
    }

    int process(int n, int v){
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(map[v][n] != -1) return map[v][n];

        // now when the current last char is `c` and only `n`position left we try to find out
        // number of permutations taht can be made
        int count = 0;

        if(v == 0){
            count = (process(n-1, 1) % max);
            return map[v][n] = (count % max);
        }
        if(v == 1){
            count = ((process(n-1, 0) % max) + (process(n-1, 2) % max));
            return map[v][n] = (count % max);
        }
        if(v == 2){
            count = ((((process(n-1, 0) % max) + (process(n-1, 1) % max))%max + (process(n-1, 3) % max))%max + (process(n-1, 4) % max));
            return map[v][n] = (count % max);
        }
        if(v == 3){
            count = ((process(n-1, 2) % max) + (process(n-1, 4) % max));
            return map[v][n] = (count % max);
        }
        if(v == 4){
            count = (process(n-1, 0) % max);
            return map[v][n] = (count % max);
        }

        return 0;
    }
}
