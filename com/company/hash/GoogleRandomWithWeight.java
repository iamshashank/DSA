package com.company.hash;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 *
 *You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 *
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
 *
 *     For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output
 * [null,0]
 *
 * Explanation
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
 *
 *
 *
 * class Solution
 *
 * =begin
 *     :type w: Integer[]
 * =end
 *     def initialize(w)
 *         @w = w
 *         @sum = w.sum
 *         @c = {}
 *         @total_picks = 0
 *         @i = 0
 *     end
 *
 *
 * =begin
 *     :rtype: Integer
 * =end
 *     def pick_index()
 *         pick_one(@i)
 *     end
 *
 *     def pick_one(i = 0)
 *       ic = @c[i].to_i
 *       ideal_max_per = @w[i] * 100.0 / @sum
 *       ideal_max_count = ideal_max_per * @total_picks / 100
 *
 *       while(ic > ideal_max_count )
 *         i = (i + 1)% @w.length
 *
 *         ic = @c[i].to_i
 *         ideal_max_per = @w[i] * 100.0 / @sum
 *         ideal_max_count = ideal_max_per * @total_picks / 100
 *       end
 *
 *       @c[i] = @c[i].to_i + 1
 *       @total_picks += 1
 *       @i = (i + 1)% @w.length
 *       return i
 *     end
 * end
 *
 */

public class GoogleRandomWithWeight {
}
