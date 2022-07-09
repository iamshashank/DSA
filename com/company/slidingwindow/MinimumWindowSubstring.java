package com.company.slidingwindow;

import java.util.HashMap;

/**
 *https://leetcode.com/problems/minimum-window-substring/
 * 76. Minimum Window Substring
 * Hard
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 */

public class MinimumWindowSubstring {
    HashMap<Character, Integer> tMap;
    HashMap<Character, Integer> winMap;
    public String minWindow(String s, String t) {
        int low = 0, high = 0;
        tMap = new HashMap<>();
        winMap = new HashMap<>();
        int minWindow = Integer.MAX_VALUE;
        for(int i=0;i<t.length();i++){
            int tt = 0;
            char c = t.charAt(i);
            if(tMap.containsKey(c)){
                tt = tMap.get(c);
            }
            tMap.put(c, tt+1);
        }
        int x = -1, y = -1;
        for(int r =0;r<s.length();r++){
            // add char to winmap
            int g = 0;
            if(winMap.containsKey(s.charAt(high))){
                g = winMap.get(s.charAt(high));
            }
            winMap.put(s.charAt(high), g+1);


            // shrink window if you can
            while(stillValid(s,t,low, high)){

                // check window size
                if(stillValid(s,t,low, high)){
                    if(high-low+1 < minWindow){
                        x = low;
                        y = high;
                        minWindow = (high-low+1);
                    }
                }

                char c = s.charAt(low);
                int tt = 0;
                if(winMap.containsKey(c)){
                    tt = winMap.get(c);
                    tt = tt -1;
                }
                if(tt<= 0){
                    winMap.remove(c);
                }else{
                    winMap.put(c, tt);
                }
                low++;
            }

            // grow the window
            high++;
        }

        if(x == -1 || y == -1)
            return "";
        return s.substring(x, y+1);
    }

    public boolean stillValid(String s ,String t,int low,int high){

        if((high - low + 1) < t.length())
            return false;

        for(char i = 'a';i<= 'z';i++){
            int sc = 0, tc = 0;
            if(tMap.containsKey(i)){
                if(!winMap.containsKey(i)) return false;
                sc = winMap.get(i);
                tc = tMap.get(i);
                if(sc < tc) return false;
            }
        }

        for(char i = 'A'; i <= 'Z'; i++){
            int sc = 0, tc = 0;
            if(tMap.containsKey(i)){
                if(!winMap.containsKey(i)) return false;
                sc = winMap.get(i);
                tc = tMap.get(i);
                if(sc < tc) return false;
            }
        }
        return true;
    }
}
