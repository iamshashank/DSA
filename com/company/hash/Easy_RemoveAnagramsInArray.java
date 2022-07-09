package com.company.hash;

/**
 *
 *
 * def remove_anagrams(words)
 *     map = {}
 *     words.each do |w|
 *       map[w] = add_to_hash(w)
 *     end
 *     flag = false
 *     i = 1
 *     indexOfPrevEl = 0
 *     while(i < words.length)
 *       if(map[words[i]] == map[words[indexOfPrevEl]] )
 *         words[i] = nil
 *         i += 1
 *         # indexOfPrevEl remains same
 *       else
 *         indexOfPrevEl = i
 *         i += 1
 *       end
 *     end
 *     words.compact
 * end
 *
 * def add_to_hash(w)
 *   m = {}
 *   (0...w.length).each do |i|
 *     m[w[i]] = m[w[i]].to_i + 1
 *   end
 *   m
 * end
 *
 */

public class Easy_RemoveAnagramsInArray {
}
