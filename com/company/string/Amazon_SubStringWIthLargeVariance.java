package com.company.string;

import java.util.HashMap;

/**
 * 2272. Substring With Largest Variance
 * Hard
 *
 * The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters present in the string. Note the two characters may or may not be the same.
 *
 * Given a string s consisting of lowercase English letters only, return the largest variance possible among all substrings of s.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aababbb"
 * Output: 3
 * Explanation:
 * All possible variances along with their respective substrings are listed below:
 * - Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
 * - Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
 * - Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
 * - Variance 3 for substring "babbb".
 * Since the largest possible variance is 3, we return it.
 *
 * Example 2:
 *
 * Input: s = "abcde"
 * Output: 0
 * Explanation:
 * No letter occurs more than once in s, so the variance of every substring is 0.
 */

public class Amazon_SubStringWIthLargeVariance {
    public int largestVariance(String s) {
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0)+1);
        }
        int variance = 0;
        //Iterate through unique characters
        for (Character primaryChar: charCount.keySet()) {
            for  (Character secondaryChar: charCount.keySet()) {
                // We need a unique character  pair to compute variance
                if (primaryChar == secondaryChar) { continue; }
                int secondaryCharCount = charCount.get(secondaryChar);
                int primaryFreq = 0;
                int secondaryFreq = 0;

                for (int i = 0; i < s.length(); i++) {
                    Character currChar = s.charAt(i);
                    if (currChar == primaryChar) {
                        primaryFreq++;
                    }
                    if (currChar == secondaryChar) {
                        secondaryFreq++;
                        secondaryCharCount--;
                    }
                    // Variance only computed if we have already seen both a primary
                    // and a secondary character
                    // we are check 1 way case only primary > secondary
                    // reverse will checked when primary and & secondary will be swapped by for loop
                    if (primaryFreq > 0 && secondaryFreq > 0 && primaryFreq > secondaryFreq) {
                        variance  = Math.max(variance, (primaryFreq - secondaryFreq));
                    }
                    // We reset our index so we are ignoring the substring which will
                    // impact our variance negatively
                    // why secondaryCharCount check is necessary for ex: "lripaa"
                    // in this suppose you ar checking for `l` and `a` when you reach i = 2
                    // count(l) = 1 and count(a) = 0 then we if make primaryFreq = 0 and secondFreq = 0
                    // without checking if we will get any `l` in the future then our soluton will be wrong
                    if (primaryFreq < secondaryFreq && secondaryCharCount > 0) {
                        primaryFreq = 0;
                        secondaryFreq = 0;
                    }
                }

            }
        }
        return variance;
    }
}
