package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses
 * Medium
 *
 * Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
 *
 * The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.
 *
 *
 *
 * Example 1:
 *
 * Input: expression = "2-1-1"
 * Output: [0,2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Example 2:
 *
 * Input: expression = "2*3-4*5"
 * Output: [-34,-14,-10,-10,10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 *
 *
 * Constraints:
 *
 *     1 <= expression.length <= 20
 *     expression consists of digits and the operator '+', '-', and '*'.
 *     All the integer values in the input expression are in the range [0, 99].
 *
 */

public class DifferentWaysToAddParenthesis {
    public List<Integer> diffWaysToCompute(String expression) {
        return process(expression);
    }

    List<Integer> process(String exp){
        List<Integer> res = new ArrayList<>();

        // try to solve sub problem
        for(int i =0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = process(exp.substring(0,i));
                List<Integer> right = process(exp.substring(i+1));
                System.out.println(left+" "+ c +" "+right);
                for(Integer l : left){
                    for(Integer r : right){
                        if(c == '+') res.add(l+r);
                        else if(c == '-') res.add(l-r);
                        else res.add(l*r);
                    }
                }
            }
        }

        // if exp cannot be broken into sub problem then just add the integer value to res
        if(res.size() == 0) res.add(Integer.valueOf(exp));
        return res;
    }
}
