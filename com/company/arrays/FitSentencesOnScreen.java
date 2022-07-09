package com.company.arrays;

/**
 *
 * LeetCode — 418. Sentence Screen Fitting
 *
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.
 *
 * Note:
 *
 *     A word cannot be split into two lines.
 *     The order of words in the sentence must remain unchanged.
 *     Two consecutive words in a line must be separated by a single space.
 *     Total words in the sentence won’t exceed 100.
 *     Length of each word is greater than 0 and won’t exceed 10.
 *     1 ≤ rows, cols ≤ 20,000.
 *
 * Example 1:
 *
 * Input:
 * rows = 2, cols = 8, sentence = ["hello", "world"]Output:
 * 1Explanation:
 * hello---
 * world---The character '-' signifies an empty space on the screen.
 *
 * Example 2:
 *
 * Input:
 * rows = 3, cols = 6, sentence = ["a", "bcd", "e"]Output:
 * 2Explanation:
 * a-bcd-
 * e-a---
 * bcd-e-The character '-' signifies an empty space on the screen.
 *
 */

public class FitSentencesOnScreen {
    public int process(String[] a, int X, int Y){
        int ans = 0;
        int i = 0, j = 0;
        // sentence counter and word index
        int sc = 0, wi = 0;
        while(i<X){
            if(j==0){
               if(a[wi].length() <= Y){
                    j = a[wi].length();
                   wi = (wi+1)%a.length;
                   if(wi == 0) ans++;
               }else{
                   return 0; // you cant possibly fit a word in 1 line
               }
            }else{

                int spaceLeftOnCurrentRow = (Y - j);
                int spaceNeededForNextWork = a[wi].length() + 1; // including 1 cell for ` ` space char
                if (spaceLeftOnCurrentRow >= spaceNeededForNextWork) {
                    // we can fit the word
                    j += spaceNeededForNextWork;
                    wi = (wi + 1) % a.length;
                    if (wi == 0) ans++;
                } else {
                    // need new row
                    i++;
                    j = 0;
                }
            }
        }
        return ans;
    }
}
