package com.company.string;

import java.util.HashSet;

/**
 *
 * 1316. Distinct Echo Substrings
 * Hard
 *
 * Return the number of distinct non-empty substrings of text that can be written as the concatenation of some string with itself (i.e. it can be written as a + a where a is some string).
 *
 *
 *
 * Example 1:
 *
 * Input: text = "abcabcabc"
 * Output: 3
 * Explanation: The 3 substrings are "abcabc", "bcabca" and "cabcab".
 *
 * Example 2:
 *
 * Input: text = "leetcodeleetcode"
 * Output: 2
 * Explanation: The 2 substrings are "ee" and "leetcodeleetcode".
 *
 */

public class DistinctEchoSubstring {
    public int distinctEchoSubstrings(String t) {
        int L = t.length();
        HashSet<String> set = new HashSet<>();
        // we will essentially compare substring of all length from 2 to 4, 6, ..
        for(int l =1; l<= L/2; l++){
            // so with each iteration we are looking at matching string with length `l`
            int count = 0;
            // we are simultaneously matching the 2 half of the string
            for(int i = 0, j = l; j < L;i++, j++){
                if(t.charAt(i) == t.charAt(j)){
                    count++;
                }else{
                    count = 0;
                }

                // when we reach desired len add it to set
                if(count == l){
                    set.add(t.substring(i+1, j+1));
                    // we need to decrease count by 1 so that we can continue to look for other matching which are glued together
                    // abcabca in this abcabc is 1 solution but bcabca so 2 such solutions are glued together we need to decrease count by 1
                    // this way if we find 1 more matching cahracter that means we found 1 more matching string of len `l`
                    count--;
                }

            }
        }
        // System.out.println(set);
        return set.size();
    }
}
