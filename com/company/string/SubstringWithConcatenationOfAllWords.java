package com.company.string;


/**
 *https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * 30. Substring with Concatenation of All Words
 * Hard
 *
 * You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 *
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 *
 *
 * def find_substring(s, words)
 *   map = {}
 *   ans = []
 *   wl = words[0].length
 *   sub_length = words.length * wl
 *   # no way a substring of proper length exists
 *   return [] if s.length < sub_length
 *   # store all words as keys for faster access and count of each words becasue they may be repeate
 *   # we have append all words together
 *   words.each do |w|
 *     t = map[w].to_i
 *     map[w] = t+1
 *   end
 *
 *   (0..(s.length-sub_length)).each do |i|
 *     # from index i we will get substrings of length `wl` and see if it exists in out map
 *     # not then move to next iteration
 *     # if found we maintain a new hash and keep count of ecountered word
 *     # if we encounter more count of a particular word than needed then solution dont exist we move to next iteration
 *     str = s[i,sub_length]
 *
 *     break if(str.length != sub_length)
 *     j = 0
 *     th = {}
 *     flag = true
 *     while(j < str.length)
 *       w = str[j,wl]
 *       break if(w.length != wl)
 *       if(map[w].to_i == 0)
 *         flag = false
 *         break
 *       else
 *         x = th[w].to_i
 *         th[w] = x+1
 *         if(th[w] > map[w])
 *           # we have more that count of word `w` than we need
 *           flag = false
 *           break
 *         end
 *       end
 *       j += wl
 *     end
 *     ans.push(i) if(flag)
 *   end
 *   ans
 * end
 *
 *
 */

public class SubstringWithConcatenationOfAllWords {
}
