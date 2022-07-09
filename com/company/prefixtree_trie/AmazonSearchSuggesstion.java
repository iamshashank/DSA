package com.company.prefixtree_trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 1268. Search Suggestions System
 * Medium
 *
 * You are given an array of strings products and a string searchWord.
 *
 * Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return a list of lists of the suggested products after each character of searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 *
 * Example 2:
 *
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 *
 * Example 3:
 *
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 *
 */

public class AmazonSearchSuggesstion {
    TrieNode root;

    class TrieNode{
        boolean eod = false;
        HashMap<Character, TrieNode> map;
        TrieNode(){
            this.map = new HashMap<>();
        }
    }

    public void insert(String w) {
        TrieNode t = root; // so we dont loose root
        for(int i=0;i<w.length();i++){
            char c = w.charAt(i);
            if(!t.map.containsKey(c)){
                t.map.put(c, new TrieNode());
            }
            t = t.map.get(c);
        }
        t.eod = true;
    }

    public List<String> search(String prefix) {
        TrieNode r = root;
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!r.map.containsKey(c)) return ans;
            r = r.map.get(c);
        }
        // from here we need to find at most three word
        if(r.eod) ans.add(prefix);
        for(char i = 'a';i<= 'z';i++){
            if(ans.size() == 3) break;
            if(!r.map.containsKey(i)) continue;
            dfs(r.map.get(i), ans, prefix+i);
        }
        return ans;
    }

    public void dfs(TrieNode root, List<String> ans, String a){
        if(ans.size() == 3) return;
        if(root.eod == true){
            ans.add(a);
        }
        for(char i = 'a';i<= 'z';i++){
            if(root.map.containsKey(i)){
                dfs(root.map.get(i), ans, a+i);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] p, String sw) {
        root = new TrieNode();
        for(int i=0;i<p.length;i++){
            insert(p[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<sw.length();i++){
            String c = sw.substring(0,i+1);
            ans.add(search(c));
        }
        return ans;
    }


}
