package com.company.bfs;

import java.util.*;

/**
 *
 *
 *
 * 127. Word Ladder
 * Hard
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 *     Every adjacent pair of words differs by a single letter.
 *     Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 *     sk == endWord
 *
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 *
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 */

public class WordLadder {
    public int process(String a,String e, List<String> w){
        int ans = 0;
        Queue<String> q = new LinkedList<>();
        q.add(a);
        int k = 1;
        int[] v = new int[w.size()];
        while(q.size()>0){
            int l = q.size();
            for(int i = 0;i<l;i++){
                String tw = q.remove();
                for(int j =0;j<w.size();j++){
                    if(v[j] == 0 && !a.equals(w.get(j)) ){
                        int dif = diff(tw, w.get(j));
                        if( dif == 1){
                            if(w.get(j).equals(e)) {
                                return ++k;
                            }
                            v[j] = 1;
                            q.add(w.get(j));
                        }
                    }
                }
            }
            k++;
        }
        return ans;
    }

    int diff(String a, String b){
        int d = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) d++;
        }
        return d;
    }
}
