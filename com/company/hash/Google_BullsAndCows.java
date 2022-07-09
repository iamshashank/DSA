package com.company.hash;

/**
 *
 * https://leetcode.com/problems/bulls-and-cows/
 *
 * 299. Bulls and Cows
 * Medium
 *
 * You are playing the Bulls and Cows game with your friend.
 *
 * You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
 *
 *     The number of "bulls", which are digits in the guess that are in the correct position.
 *     The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
 *
 * Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
 *
 * The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
 *
 *
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1807"
 *   |
 * "7810"
 *
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull
 *
 *
 *
 *
 *
 * # @param {String} secret
 * # @param {String} guess
 * # @return {String}
 * def get_hint(s, g)
 *     sh = {}
 *     gh = {}
 *     bh = {}
 *
 *     b = 0 #bulls
 *     c = 0
 *     (0...s.length).each do |i|
 *       sh[s[i]] = sh[s[i]].to_i+1
 *     end
 *     (0...g.length).each do |i|
 *       gh[g[i]] = gh[g[i]].to_i+1
 *     end
 *     # puts gh
 *     (0...g.length).each do |i|
 *       if(i<s.length)
 *         # here we can compare bulls
 *         if s[i] == g[i]
 *           b += 1
 *           bh[s[i]] = bh[s[i]].to_i+1 # this will help us with cows
 *         end
 *       end
 *     end
 *     # puts bh
 *     # cows
 *     gh.each do |k, v|
 *       maxKinS = sh[k].to_i
 *       if(maxKinS > 0)
 *         kINbull = bh[k].to_i
 *         leftFORcow = maxKinS - kINbull
 *         c += (leftFORcow > (v - kINbull) ? (v - kINbull) : leftFORcow)
 *       end
 *     end
 *     return "#{b}A#{c}B"
 * end
 *
 *
 */

public class Google_BullsAndCows {
}
