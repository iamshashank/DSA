package com.company.stack;

import sun.jvm.hotspot.debugger.cdbg.CDebugger;

import java.util.Arrays;
import java.util.Stack;

// THESE ARE ALL EXAMPLE OF MONOTONIC STACK

// push number from starting into stack
// if k > 0 & the number to be pushed is smaller than top-of-stack then pop the stack and push the new number and k--
// if all numbers are pushed and k == 0 then just pop the stack and arrange the numbers, then reverse it to ge the answer
// if k > 0 then pop from stack k times
// when k == 0  then just pop the stack and arrange the numbers, then reverse it to ge the answer
public class RemoveKDigitsFromANumber {
    public String process(String num, int k) {
        StringBuilder result = new StringBuilder();

        // We have to delete all digits
        if (k >= num.length()) {
            return "0";
        }
        // Nothing to delete
        if (k == 0) {
            return num;
        }
        Stack<Character> s = new Stack<Character>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            // Removing all digits in stack that are greater
            // than this digit(since they have higher
            // weightage)
            while (!s.isEmpty() && k > 0 && s.peek() > c) {
                s.pop();
                k--;
            }
            // ignore pushing 0
            if (!s.isEmpty() || c != '0')
                s.push(c);
        }

        // If our k isn't 0 yet then we keep popping out the
        // stack until k becomes 0
        while (!s.isEmpty() && k > 0) {
            k--;
            s.pop();
        }
        if (s.isEmpty())
            return "0";
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        String str = result.reverse().toString();

        return str;
        }
    }

