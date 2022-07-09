package com.company.knapsack;

// https://leetcode.com/problems/maximum-split-of-positive-even-integers/
//
//You are given an integer finalSum. Split it into a sum of a maximum number of unique positive even integers.
//
//        For example, given finalSum = 12, the following splits are valid (unique positive even integers summing up to finalSum): (12), (2 + 10), (2 + 4 + 6), and (4 + 8). Among them, (2 + 4 + 6) contains the maximum number of integers. Note that finalSum cannot be split into (2 + 2 + 4 + 4) as all the numbers should be unique.
//
//        Return a list of integers that represent a valid split containing a maximum number of integers. If no valid split exists for finalSum, return an empty list. You may return the integers in any order.
//
//
//
//        Example 1:
//
//        Input: finalSum = 12
//        Output: [2,4,6]
//        Explanation: The following are valid splits: (12), (2 + 10), (2 + 4 + 6), and (4 + 8).
//        (2 + 4 + 6) has the maximum number of integers, which is 3. Thus, we return [2,4,6].
//        Note that [2,6,4], [6,2,4], etc. are also accepted.




//  start to sum up even numbers starting from 2 to some Number
//  And stop where the sum of the above sequence is just above the given finalSum.

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSplitOfPositiveEvenIntergers {
    public void process(int final_sum){
        if (final_sum % 2 != 0){
            System.out.println(Arrays.toString(new int[]{}));
        }
        int a = 0, sum = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while(sum <= final_sum){
            a += 2;
            res.add(a);
            sum += a;
        }
        if (sum != final_sum) {
            res.remove(new Integer((sum-final_sum)));
        }
        System.out.println(res.toString());
    }
}
