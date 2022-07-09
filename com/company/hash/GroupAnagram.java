package com.company.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. Group Anagrams
 * Medium
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= strs.length <= 104
 *     0 <= strs[i].length <= 100
 *     strs[i] consists of lowercase English letters.
 */

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String code = hashCode(s);
            if(!map.containsKey(code)) map.put(code, new ArrayList<String>());
            map.get(code).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String k : map.keySet()){
            ans.add(map.get(k));
        }
        return ans;
    }

    String hashCode(String a){
        int[] x = new int[26];
        for(int i=0;i<a.length();i++){
            x['z'-a.charAt(i)]++;
        }
        String code = "";
        for(int i=0;i<26;i++) code += x[i]+"|";
        return code;
    }
}
