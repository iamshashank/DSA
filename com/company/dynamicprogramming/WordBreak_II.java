package com.company.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 140. Word Break II
 * Hard
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 *
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 20
 *     1 <= wordDict.length <= 1000
 *     1 <= wordDict[i].length <= 10
 *     s and wordDict[i] consist of only lowercase English letters.
 *     All the strings of wordDict are unique.
 */

public class WordBreak_II {
    List<String> ans;
    Set<String> set;
    int l;
    public List<String> wordBreak(String s, List<String> wd) {
        l = s.length();
        ans = new ArrayList<>();
        set = new HashSet<>();
        for(String w : wd) set.add(w);
        dfs(s, 0, "");
        return ans;
    }

    void dfs(String s, int i, String currPartition){
        if(i >= l){
            ans.add(currPartition.trim());
            return;
        }
        for(int x = i;x<l;x++){
            String t = s.substring(i,x+1);
            if(set.contains(t)){
                dfs(s, x+1, currPartition + " " + t);
            }
        }
        return;
    }
}
