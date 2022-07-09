package com.company.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 1153
 *
 * Description
 *
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.
 *
 * In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
 *
 * Return true if and only if you can transform str1 into str2.
 *
 * Example 1:
 *
 * Input: str1 = “aabcc”, str2 = “ccdee”
 *
 * Output: true
 *
 * Explanation: Convert ‘c’ to ‘e’ then ‘b’ to ‘d’ then ‘a’ to ‘c’. Note that the order of conversions matter.
 *
 * Example 2:
 *
 * Input: str1 = “leetcode”, str2 = “codeleet”
 *
 * Output: false
 *
 * Explanation: There is no way to transform str1 to str2.
 *
 */

public class Google_StringTransformsIntoAnotherString {
    public boolean process(String s1, String s2){
        // the main trick this question is that solution only exists if we can create 1 to 1 mapping for each char in string A to each char in string b
        // Example 1 {a -> c, b -> d, c -> e} so answer is TRUE
        // Example 2 {l -> c, e -> [o, d, t], t -> e , c -> l, o -> e, d -> e} in this e is to be converted to o, d, t which is not possible
        if(s1.length() != s2.length()) return false;
        if(s1 == s2) return true;
        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> s = new HashSet<>();
        for(int i = 0; i < s1.length(); i++){
            s.add(s2.charAt(i));
            if(map.containsKey(s1.charAt(i))){
                if(map.get(s1.charAt(i)) != s2.charAt(i)) return false;
            }else{
                map.put(s1.charAt(i), s2.charAt(i));
            }
        }
        //  str1 = 'abcdefghijklmnopqrstuvwxyz', str2 = 'zyxwvutsrqponmlkjihgfedcba'
        //  this is an edge case where all 26 letters are used, and in diff orders for both strings,
        //  this should return False  because we can't convert any more letters
        // for example if we convert `a`-> z then by the time we reach the last char `z`
        // in s1 there will be 2 z in s1 if we convet it to `a` then first char will also change to `a`
        if(map.size() == 26 && s.size() == 26) return false;

        return true;
    }
}
