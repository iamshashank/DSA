package com.company.slidingwindow;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/number-of-equal-count-substrings/
 * Given a string s, return the length of longest substring such that every character in the substring has equal number of occurance.
 */

public class Google_LongestSubstring_EveryCharacterHasEqualOccurence {
    public String longestSubstring(String s){
        char[] c  = s.toCharArray();
        int max = Integer.MIN_VALUE;
        int[] freq = new int[26];
        for(int i =0;i<c.length;i++){
            freq[c[i] - 'a']++;
            max = Math.max(max, freq[c[i] - 'a']);
        }
        int ans = 0, startIdx = -1, endIdx = -1;

        // future optimization
        // maybe instead of checking possible i from 1 to N we can do binary search logic in this
        // first check to see if max/2 is possible if yes then go for a bigger freq if not then lower

        for(int i = 1; i<= max ; i++){
            // find max window where freq of all char is `i`
            int low = 0, high = 0;
            int lowFreq = Integer.MAX_VALUE;
            Arrays.fill(freq, 0);
            while (high<c.length){
                freq[c[high] - 'a']++;

                while(freq[c[high] - 'a'] > i){
                    freq[c[low] - 'a']--;
                    low++;
                }
                int winLen = high-low+1;

                if(winLen > ans && lowestFreq(freq) == i){
//                    System.out.println(i+" "+ s.substring(low, high+1) +" "+winLen+", "+low+", "+high);
                    ans = winLen;
                    startIdx = low;
                    endIdx = high;
                }
                high++;
            }
        }
        return s.substring(startIdx, endIdx+1);
    }

    private int lowestFreq(int[] a){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(a[i] == 0) continue;
            min = Math.min(min, a[i]);
        }
        return min;
    }
}
