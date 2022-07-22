package com.company.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 139. Word Break
 * Medium
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 300
 *     1 <= wordDict.length <= 1000
 *     1 <= wordDict[i].length <= 20
 *     s and wordDict[i] consist of only lowercase English letters.
 *     All the strings of wordDict are unique.
 */
public class WordBreak {
    Set<String> set;
    int l;
    boolean ans = false;
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        l = s.length();
        dp = new int[l];
        Arrays.fill(dp, -1);
        for(String w : wordDict) set.add(w);
        dfs(s, 0);
        return ans;
    }

    int dfs(String s, int i){
        if(i >= l){
            ans = true;
            return 1;
        }
        if(dp[i] != -1) return dp[i];
        for(int x =i;x<l;x++){
            if(set.contains(s.substring(i, x+1))){
                dp[i] = dfs(s, x+1);
            }else{
                dp[i] = 0;
            }
        }
        return dp[i];
    }

    int dfs1(String s, int i){
        if(i >= s.length()) return 1;
        if(dp[i] != -1) return dp[i];
        for(int k=i;k<s.length();k++){
            if(set.contains(s.substring(i, k+1))){
                dp[i] = dfs(s, k+1);
            }else{
                dp[i] = 0;
            }
            if(dp[i] == 1) return dp[i];
        }
        return dp[i];
    }
}
