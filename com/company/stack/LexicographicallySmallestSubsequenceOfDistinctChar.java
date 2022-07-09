package com.company.stack;

import java.util.Stack;

/**
 *
 * 1081. Smallest Subsequence of Distinct Characters
 * Medium
 *
 * Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 *
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 */

public class LexicographicallySmallestSubsequenceOfDistinctChar {

    /**
     *
     * we will use sort-of monotonic stack
     * in monotonic stack we only push if condition is met else we pop
     * here we find out the last index of each character in string and store in lastindexOf[s[i]-'a']
     * so lastindexOf[2] will store the last index where char `c` occurred
     * the in monotonic stack push char s[i] if its smaller than stack.top since we need to get Lexicographically smaller answer
     * If s[i] > stack.top we should ideally pop the stack but before popping we have check if the element we are popping is available at a later stage using lastindexOf[]
     * we have make the result lexicographic but at the same time the subsequence should contain all distinct characters once
     */

    public String smallestSubsequence(String s) {
        int[] lastIndexOf = new int[26];
        // store lastIndexOf of each char
        for(int i =0 ;i<s.length();i++)
            lastIndexOf[s.charAt(i) -'a'] = i;

        Stack<Character> stk = new Stack<>();
        int[] v = new int[26];
        for(int i =0;i<s.length();i++){

            if(v[s.charAt(i) -'a'] == 1) continue; // ignore if already visited

            while( !stk.isEmpty() && s.charAt(i) < stk.peek() && lastIndexOf[stk.peek() - 'a'] > i ){
                v[stk.peek() - 'a'] = 0; // undo visit
                stk.pop(); // remove that char
            }
            stk.push(s.charAt(i));
            v[s.charAt(i) - 'a'] = 1;
        }

        StringBuilder str = new StringBuilder();
        while(!stk.isEmpty()){
            str.append(stk.pop());
        }
        return str.reverse().toString();
    }
}
