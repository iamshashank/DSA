package com.company.hash;

import java.util.Arrays;
import java.util.HashMap;

public class GoogleExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        return 0;
    }
}

//
//    Sometimes people repeat letters to represent extra feeling. For example:
//
//        "hello" -> "heeellooo"
//        "hi" -> "hiiii"
//
//        In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".
//
//        You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal to s by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is three or more.
//
//        For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has a size less than three. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo". If s = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = s.
//
//        Return the number of query strings that are stretchy.
//
//
//
//        Example 1:
//
//        Input: s = "heeellooo", words = ["hello", "hi", "helo"]
//        Output: 1
//        Explanation:
//        We can extend "e" and "o" in the word "hello" to get "heeellooo".
//        We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
//
//        Example 2:
//
//        Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
//        Output: 3




/**
 *
 *
 * # @param {String} s
 * # @param {String[]} words
 * # @return {Integer}
 * def expressive_words(s, words)
 *   c = 0
 *   s_group = group_count(s)
 *   words.each do |word|
 *     w_group = group_count(word)
 *     flag = true
 *     if(w_group.size == s_group.size)
 *       s_group.each_with_index do |sg, i|
 *         wg = w_group[i]
 *         if(sg[:char] != wg[:char])
 *           flag = false
 *           break
 *         end
 *         if !(sg[:count] == wg[:count] or (wg[:count] < sg[:count] and sg[:count] >2))
 *           flag = false
 *         end
 *       end
 *     else
 *       flag = false
 *     end
 *     c += 1 if flag
 *   end
 *   c
 * end
 *
 * def group_count(s)
 *     group = []
 *     i = 0;
 *     while(i<s.length)
 *       letter = s[i]
 *       c = 0;
 *       while(i < s.length and s[i] == letter)
 *         c += 1
 *         i += 1
 *       end
 *       group.push({char: s[i-1], count: c })
 *     end
 *   group
 * end
 *
 *
 *
 **/