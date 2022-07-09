package com.company.slidingwindow;

/**
 *
 *
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 *
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
 *
 * Example 1:
 *
 * Input: S = “abcdebdde”, T = “bde”
 *
 * Output: “bcde”
 *
 * Explanation:
 *
 * “bcde” is the answer because it occurs before “bdde” which has the same length.
 *
 * “deb” is not a smaller window because the elements of T in the window must occur in order.
 *
 * Note:
 *
 *     All the strings in the input will only contain lowercase letters.
 *     The length of S will be in the range [1, 20000].
 *     The length of T will be in the range [1, 100].
 *
 */

public class Google_MinimimWindowSubsequence {
    public String process(String a, String b){
        if(a==b) return a;
        int x = 0, y = a.length()-1;
        int indexB = 0, indexA = 0;
        while(indexA < a.length()){
            if(a.charAt(indexA) == b.charAt(indexB)){
                indexB++;
            }
            if(indexB == b.length()){
                // it means we have found `b` int the window now we need to look back and find x,y
                int tempRight = indexA;
                indexB--; //arrays starts from 0

                while(indexB >= 0){
                    if(b.charAt(indexB) == a.charAt(indexA)) indexB--;
                    indexA--;
                }
                indexA++; // so this is the left from where substring starts
                if(y-x+1 > tempRight-indexA+1 ){
                    // store new substring
                    x = indexA;
                    y = tempRight;
                }
                indexB=0; // we will look for the string again
            }
            indexA++;
        }
        if(y-x+1 == a.length())
            return "";
        return a.substring(x, y+1);
    }
}
