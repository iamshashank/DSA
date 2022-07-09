package com.company;

import java.util.Arrays;

/**
 *
 * 204. Count Primes
 * Medium
 *
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 *
 * Input: n = 1
 * Output: 0
 *
 */


/**
 *
 * FAST ALGO FOR FINDING PRIME IN RANGE
 *
 * Sieve of Eratosthenes
 *
 * The idea behind Sieve of Eratosthenes is to cross out all the composites in the given range. Once we are sure that all composites are crossed out, we are left with all the primes in the given range. How do we cross out all the composites?
 *
 * Let’s create a process to find all primes in the range 1 to N.
 *
 *     Iterate from 2 to sqrt(N), call it i
 *     For each i, we cross out all the multiples of i, i.e. 2*i, 3*i .. and so on
 *     If i is already crossed out, we don’t do anything, because if i is already crossed out, we are ensured that all multiples of i are already crossed out in our previous iterations
 *     In the end, we print out all the numbers that are not crossed out
 *
 * Example: Let’s take a range [2, 25] and find all the primes in this list.
 *
 * [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
 *
 *     Iterate from 2 to sqrt(25), call it i
 *         So we iterate from 2 to 5
 *     For 2, cross all multiples of 2 i.e. 2*2, 3*2, 4*2 .. and so on
 */

public class CountPrime {
    class Solution {
        public int countPrimes(int n) {
            int c = 0;
            boolean[] prime = new boolean[5000000+1];
            Arrays.fill(prime, true);
            prime[0] = false;
            prime[1] = false;

            for(int i = 2;i<n;i++){
                if(prime[i]){
                    c++;
                    for(int j = 2*i;j<n; j += i){
                        prime[j] = false; // so we dont check these
                    }
                }
            }
            return c;
        }

    }
}
