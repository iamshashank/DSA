package com.company.stack;

import java.util.Stack;

/**
 * 227. Basic Calculator II
 * Medium
 *
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 *
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 *
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 3 * 105
 *     s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 *     s represents a valid expression.
 *     All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 *     The answer is guaranteed to fit in a 32-bit integer.
 */

public class CalculatorII {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        if(s == null || s.length() == 0) return 0;
        int l = s.length();
        int ans = 0;

        //insert fist numner into stack
        int firstOperator = findNextOperator(s, 0);
        Integer firstNumber = Integer.valueOf(s.substring(0, firstOperator).trim());
        stack.push(firstNumber);

        for(int i=firstOperator;i<l;i++){
            int operatorIndex = findNextOperator(s, i);
            int operatorIndex2 = findNextOperator(s, operatorIndex+1);
            Integer op2 = Integer.valueOf(s.substring(operatorIndex+1, operatorIndex2).trim());

            if(operatorIndex < l){
                char operator = s.charAt(operatorIndex);
                // + and - will evaluated at last, first all * and / will be evaluated
                if(operator == '+'){
                    stack.push(op2);
                }else if(operator == '-'){
                    stack.push(-1*op2);
                }else if(operator == '*'){
                    Integer op1 = stack.pop();
                    stack.push(op1*op2);
                }else if(operator == '/'){
                    Integer op1 = stack.pop();
                    stack.push(op1/op2);
                }
            }

            i = operatorIndex2-1;
        }

        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

    int findNextOperator(String s, int i){
        for(;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/') return i;
        }
        return s.length();
    }
}
