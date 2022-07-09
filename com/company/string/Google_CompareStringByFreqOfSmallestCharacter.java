package com.company.string;

/**
 *https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 *
 * 1170. Compare Strings by Frequency of the Smallest Character
 * Medium
 *
 * Let the function f(s) be the frequency of the lexicographically smallest character in a non-empty string s. For example, if s = "dcce" then f(s) = 2 because the lexicographically smallest character is 'c', which has a frequency of 2.
 *
 * You are given an array of strings words and another array of query strings queries. For each query queries[i], count the number of words in words such that f(queries[i]) < f(W) for each W in words.
 *
 * Return an integer array answer, where each answer[i] is the answer to the ith query.
 *
 *
 *
 * Example 1:
 *
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 *
 * Example 2:
 *
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 *
 *
 *
 *
 *
 *
 * # @param {String[]} queries
 * # @param {String[]} words
 * # @return {Integer[]}
 * def num_smaller_by_frequency(queries, words)
 *     map = []
 *     low = 26
 *
 *     a = [0]*26
 *     words.each do |w|
 *       a.fill(0)
 *       (0...w.length).each do |i|
 *         c = w[i].ord - 'a'.ord
 *         a[c] += 1
 *         low = c if c < low
 *       end
 *       map.push(a[low])
 *       low = 26
 *     end
 *
 *     qmap = []
 *     low = 26
 *     # same thing for word
 *     queries.each do |w|
 *       a.fill(0)
 *       (0...w.length).each do |i|
 *         c = w[i].ord - 'a'.ord
 *         a[c] += 1
 *         low = c if c < low
 *       end
 *       qmap.push(a[low])
 *       low = 26 #reset
 *     end
 *
 *     ans = []
 *     qmap.each do |qc|
 *       counter = 0
 *       map.each do |mc|
 *         counter += 1 if qc < mc
 *       end
 *       ans.push(counter)
 *     end
 *   ans
 * end
 *
 */

public class Google_CompareStringByFreqOfSmallestCharacter {
}
