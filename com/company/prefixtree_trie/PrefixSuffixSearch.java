package com.company.prefixtree_trie;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * 745. Prefix and Suffix Search
 * Hard
 *
 * Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.
 *
 * Implement the WordFilter class:
 *
 *     WordFilter(string[] words) Initializes the object with the words in the dictionary.
 *     f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * Output
 * [null, 0]
 *
 * Explanation
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".
 *
 *
 *
 * Constraints:
 *
 *     1 <= words.length <= 15000
 *     1 <= words[i].length <= 10
 *     1 <= prefix.length, suffix.length <= 10
 *     words[i], prefix and suffix consist of lower-case English letters only.
 *     At most 15000 calls will be made to the function f.
 *
 */

public class PrefixSuffixSearch {
    TrieNode root;
    HashMap<String, Integer> dict;
    int ans = -1;
    public PrefixSuffixSearch(String[] words) {
        // the root does not store any cha
        root = new TrieNode();
        dict = new HashMap<>();
        ArrayList<String> t = new ArrayList<>();
        int i = 0;
        for(String w : words){
            dict.put(w, i++);
            for(String sw : generateVersions(w)){
                t.add(sw);
            }
        }
        System.out.println(t);
        for(String w : t){
            insert(w);
        }
    }

    /**
     *
     *  For a word like "test", consider "#test", "t#test", "st#test", "est#test", "test#test".
     *  Then if we have a query like prefix = "te", suffix = "t", we can find it by searching for something we've inserted starting with "t#te".
     *
     * @param p
     * @param s
     * @return
     */

    public int f(String p, String s) {
        ans = -1; //reset
        String w = s+"#"+p;
        // now search w in tire
        TrieNode r = root;
        for(int i = 0;i<w.length();i++){
            char c = w.charAt(i);
            if(!r.map.containsKey(c)){
                return -1;
            }
            r = r.map.get(c);
        }
        // ok we have found the tree node under which all the possible answer exists
        if(r.eod){
            ans = dict.get(p);
        }
        for(char i = 'a';i<='z';i++){
            if(r.map.containsKey(i)){
                dfs(r.map.get(i), p+i);
            }
        }
        return ans;
    }

    void dfs(TrieNode r, String w){
        if(r.eod){
            ans = Math.max(ans, dict.get(w));
        }
        for(char i = 'a';i<='z';i++){
            if(r.map.containsKey(i)){
                dfs(r.map.get(i), w+i);
            }
        }
    }

    void insert(String a){
        TrieNode r = root;
        for(int i=0; i<a.length();i++){
            char c = a.charAt(i);
            if(!r.map.containsKey(c)){
                r.map.put(c, new TrieNode());
            }
            r = r.map.get(c);
        }
        r.eod = true;
    }

    String[] generateVersions(String a){
        String[] t = new String[a.length()];
        for(int i=a.length()-1;i>=0;i--){
            t[i] = a.substring(i)+"#"+a;
        }
        return t;
    }

    class TrieNode{
        // the node themselves dont store character
        // its all connected via map
        public boolean eod = false;
        public HashMap<Character, TrieNode> map;
        TrieNode(){
            this.map = new HashMap<>();
        }
    }
}
