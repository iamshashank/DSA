package com.company.bitmanipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 1525. Number of Good Ways to Split a String
 * Medium
 *
 * You are given a string s.
 *
 * A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.
 *
 * Return the number of good splits you can make in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aacaba"
 * Output: 2
 * Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
 * ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
 *
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: 1
 * Explanation: Split the string as follows ("ab", "cd").
 */

public class GoodWaysToSplitString {
    // this is a diff logic
    public int numSplits(String s) {
        Set<Character> set = new HashSet<>();
        HashMap<Integer, Integer> f = new HashMap<>(); // forward
        HashMap<Integer, Integer> b = new HashMap<>(); // backward
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
            f.put(i, set.size());
        }
        set.clear();
        for(int i=s.length()-1;i >= 0;i--){
            set.add(s.charAt(i));
            b.put(i, set.size());
        }
        // System.out.println(f);
        // System.out.println(b);

        int ans = 0;
        for(int i=0;i<s.length()-1;i++){
            if(f.get(i) == b.get(i+1)) ans++;
        }
        return ans;
    }
}
