package com.company.backtracking;

import java.util.*;

/**
 *139. Word Break
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
 *
 */

public class Google_WordBreak {

    Set<String> set;
    int l;
    boolean ans = false;
    int[] dp;

    /**
     * This is same as PalindromePartition only diff is here the condition is diff
     * Instead of checking if sub-problem is a palindrome we check if its in the dictionary
     *
     * @param s
     * @param wordDict
     * @return
     */
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
}
