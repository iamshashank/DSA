package com.company.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.youtube.com/watch?v=3jvWodd7ht0
 *
 * we must generate all possible substrings of a string by partitioning at every index until we reach the end of the string.
 * Example, abba can be partitioned as ["a","ab","abb","abba"].
 * Each generated substring is considered as a potential candidate if it a Palindrome.
 *
 * 131. Palindrome Partitioning
 * Medium
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 */

public class Hard_PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s, ans, 0, new ArrayList<String>());
        return ans;
    }

    /**
     *
     * "aaa" -> [["a","a","a"],["a","aa"],["aa","a"],["aaa"]]
     * What we need is logic to divide string into all possible substring and this is done by dfs, but only consider those partitions which are palindrome
     *
     *
     *
     * @param s
     * @param res
     * @param start
     * @param currPart
     */

    // here currPart is the array list which will store the partition which is currently being processed
    void dfs(String s, List<List<String>> res, int start, List<String> currPart){
        if(start >= s.length()){
            // we have a valid partition and we can add it to result
            // you see below that we are only proceeding with the valid partions/paths so if we reach this point the its a valid solution
            res.add(new ArrayList<>(currPart)); // this creates a copy of currPart so wont have to worry about pass-by-ref nonsence
        }
        for(int i = start;i<s.length();i++){
            if(parlindrome(s, start, i)){
                // this is a valid partition so far, for now add this to our answer
                currPart.add(s.substring(start, i+1));
                // apply dfs on remaining
                dfs(s, res, i+1, currPart);
                // we need to backtrack and remove all data for this partition so it can be used for next partition
                currPart.remove(currPart.size()-1); // remove last, we added 1 so remove 1
            }
        }
    }

    boolean parlindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
