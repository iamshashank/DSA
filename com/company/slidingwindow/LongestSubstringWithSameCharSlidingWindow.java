package com.company.slidingwindow;

//"You have been given the string s (which consists of only uppercase English characters) and the integer k. You can replace any character in the string with another uppercase English character. This operation can be performed at most k times. After executing the preceding procedures, return the length of the longest substring containing the same letter."

public class LongestSubstringWithSameCharSlidingWindow {
    public int process(String a, int k){
        int l = 0, r, maxFreq = Integer.MIN_VALUE;
        int freq[] = new int[26];
        for(r = 0; r < a.length(); r++){
            freq[a.charAt(r) - 'a']++;
            maxFreq = Math.max(maxFreq, freq[a.charAt(r) - 'a']);
            // move the front till our window can still have all same characters even if we have use K replacement
            while( (r - l + 1) - maxFreq > k ){
                freq[a.charAt(l) - 'a']--;
                l++;
            }
            // max between old max and current length of substring
            maxFreq = Math.max(maxFreq, r - l + 1);
        }
        return maxFreq;
    }
}
