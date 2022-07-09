package com.company.stack;


//https://leetcode.com/problems/find-the-most-competitive-subsequence/
//Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.
//An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.
//We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b.
//For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.

import java.util.Stack;


// This is a derivative of the RemoveKDigitsFromANumber problem
// in this we need to if we want to get a subsequence of size K, then we need to remove L - K elements from this array
// and in doing so make sure the remaining numbers form the smallest number that way it will be competitive

public class MostCompetitiveSubSequence {
    public int[] process(int[] nums, int k){

//        def most_competitive(nums, k)
//            # we need if create subsequence of size k so we need to remove L-K elements
//            k = nums.length - k
//            s = [] # stack
//            nums.each_with_index do |a, i|
//                while(!s.empty? and k > 0 and a < s.last )
//                    k -= 1
//                    s.pop
//                end
//                s.push a
//            end
//            # if k > 0 pop elements
//            while(!s.empty? and k > 0)
//                s.pop
//                k -= 1
//            end
//            s
//        end

        return nums;
    }
}
