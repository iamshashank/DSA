package com.company.string;

import java.util.ArrayList;

/**
 *
 * 692. Top K Frequent Words
 * Medium
 *
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Example 2:
 *
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 */

public class TopKFreqWord {
    /**
     * # @param {String[]} words
     * # @param {Integer} k
     * # @return {String[]}
     * def top_k_frequent(words, k)
     *     map = {}
     *     words.each do |w|
     *         map[w] = map[w].to_i + 1
     *     end
     *     puts map
     *     ans = map.keys.sort do |a, b|
     *        if(map[a] != map[b])
     *           map[b] - map[a]
     *        else
     *           a <=> b
     *        end
     *     end
     *     ans.slice(0,k)
     * end
     *
     */
}
