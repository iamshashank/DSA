package com.company.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * All possible ways to partition the string using DFS
 * "abba" -> [a, b, b, a], [a, b, ba], [a, bb, a], [ab, b, a], [ab, ba], [a, bba], [abb, a], [abba]
 */

public class AllPossiblePartitionOfString {
    public void process(String s){
        dfs(s, 0, new ArrayList<>());
    }
    void dfs(String s, int start, List<String> currPart){
        if(start >= s.length()){
            System.out.println(currPart);
            return;
        }
        for(int i = start;i<s.length();i++){
            currPart.add(s.substring(start, i+1));
            // apply dfs on remaining
            dfs(s, i+1, currPart);
            // we need to backtrack and remove all data for this partition so it can be used for next partition
            currPart.remove(currPart.size()-1); // remove last, we added 1 so remove 1
        }
    }
}
