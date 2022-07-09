package com.company;

import java.util.Queue;

/**
 *
 *
 *
 1055. Shortest Way to Form String

 From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).

 Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.



 Example 1:

 Input: source = "abc", target = "abcbc"
 Output: 2
 Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".

 Example 2:

 Input: source = "abc", target = "acdbc"
 Output: -1
 Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.

 Example 3:

 Input: source = "xyz", target = "xzyxz"
 Output: 3
 Explanation: The target string can be constructed as follows "xz" + "y" + "xz".



 Constraints:

 Both the source and target strings consist of only lowercase English letters from "a"-"z".
 The lengths of source and target string are between 1 and 1000.

 *
 *
 */

public class LCS_Google_ShortestWayToFromString {
    public int process(String s, String t){
        int count = 0;
        int start = 0;
        while(start < t.length()){
            // we will again and again  scan target string and try find lcs common subsequence
            start = modified_lcs(s,t,start);
            if(start == -1){
                return -1;
            }
            count++;
        }

        return count;
    }

    // this is not a complete LCS logic
    // since we know that s.length < t.length
    // we check till what index in `t` we can find out common sunsequence
    // also this question has a special case where we need to combine common sunsequemces of `s` to form `t` string
    // if `t` contains any character which is not present in `s` then -1
    public int modified_lcs(String s,String t, int startIndex){
        int sl = s.length();
        int tl = t.length();
        int i = 0, j = startIndex;
        while(i < sl && j < tl){
            char sc = s.charAt(i);
            char tc = t.charAt(j);
            if(sc == tc)
                j++; // this is special logic to detect if target string contains any character which is not present in source
            i++;
        }
        if(j == startIndex){
            // that means target has a char which is not inside source
            return -1;
        }else{
            return j; // in the next loop we will start scanning target string from here
        }
    }
}
