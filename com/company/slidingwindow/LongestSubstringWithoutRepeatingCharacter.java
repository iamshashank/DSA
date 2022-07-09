package com.company.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {


    /**
     *
     * 3. Longest Substring Without Repeating Characters
     * Medium
     *
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * @param s
     * @return
     */

    // in this we store the first encountered index of a char
    // then when we find it again we calculate the length and start whole process from firstIndex+1
    public int moreElegantSolution(String s) {
        // in value we store last first found index of the character
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0;
        int t =0;
        int max = 0;
        while(high < s.length()){
            char c = s.charAt(high);
            t = map.getOrDefault(c, -1); // first found index of `c` if -1 then not found yet

            if(t != -1){
                // means we are again finding this char and this is its 2nd occurence
                System.out.println(low+" "+high);
                int l = high - low;
                max = Math.max(max, l);
                low = t+1;
                high = t+1;
                map.clear();
                continue;
            }
            map.put(c, high);
            high++;
        }
        // System.out.println(low+" "+high);
        max = Math.max(max, high-low);
        return max;
    }


    public int process(String s){
        int windowStart = 0, windowEnd = 0, maxLengthTillNow = 0, maxLengthStartIndex = 0, maxLengthEndIndex = 0;
        int[] map = new int[26];
        while(windowEnd < s.length() && windowStart < s.length()){
            if(isValid(map)){
                char c = s.charAt(windowEnd);
                map[c - 'a']++;
                // every char is still unique in our window
                if((windowEnd - windowStart) > maxLengthTillNow){
                    maxLengthTillNow = (windowEnd - windowStart);
                }
                windowEnd++;
            }else{
                // there is repetition in window so start shrinking

                char k = s.charAt(windowStart);
                map[k - 'a']--;
                windowStart++;

            }
        }
        return maxLengthTillNow;
    }

    public boolean isValid(int[] map){
        for(int i=0; i < map.length; i++){
            if(map[i] > 1){
                return false;
            }
        }
        return true;
    }
}
