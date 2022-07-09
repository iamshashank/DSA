package com.company.prefixtree_trie;

import java.util.HashMap;

/**
 * https://www.youtube.com/watch?v=oobqoCJlHA0
 *208. Implement Trie (Prefix Tree)
 * Medium
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 *     Trie() Initializes the trie object.
 *     void insert(String word) Inserts the string word into the trie.
 *     boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 *     boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 */

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
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


    public boolean search(String word) {
        TrieNode r = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!r.map.containsKey(c)) return false;
            r = r.map.get(c);
        }

        return r.eod;
    }

    public boolean startsWith(String prefix) {
        TrieNode r = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!r.map.containsKey(c)) return false;
            r = r.map.get(c);
        }
        return true;
    }

    class TrieNode{
        boolean eod = false;
        HashMap<Character, TrieNode> map;
        TrieNode(){
            this.map = new HashMap<>();
        }
    }
}
