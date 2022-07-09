package com.company.slidingwindow;

import java.util.HashMap;
import java.util.Set;

// Sliding Window Problem
// The Longest Substring with At Most K Distinct Characters
public class LongestSubstringWithAtmost_K_UniqueCharacters {
    public String googledAlgo(String s, int k){
        int high = 0, low = 0, rs = 0, re = 0;
        HashMap map = new HashMap<Character, Integer>();
        for(low = 0, high = 0 ; high < s.length(); high++) {
            if(map.containsKey(s.charAt(high))) {
                map.put(s.charAt(high), ((int) map.get(s.charAt(high)) + 1));
            }else{
                map.put(s.charAt(high),  1);
            }

            while(map.size() > k){
                //shrink window
                int t = (int) map.get(s.charAt(low));
                if( t == 1 ){
                    // remove that key from map
                    map.remove(s.charAt(low));
                }else{
                    map.put(s.charAt(low), --t);
                }
                low++;
            }
            if(re - rs < high - low){
                re = high;
                rs = low;
            }
        }
        return s.substring(rs, re + 1);
    }
}
