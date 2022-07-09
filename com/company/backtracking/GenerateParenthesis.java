package com.company.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 22. Generate Parentheses
 * Medium
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 */

public class GenerateParenthesis {
    List<String> ans;
    int N;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        N = n;
        process("", n, n);
        return ans;
    }

    void process(String a, int open, int close){
        if(close < open){
            return; // you cannot close more brancket than you open
        }
        if(open < 0 || close < 0) return;
        if(open == 0 && close == 0){
            ans.add(a);
            return;
        }
        process(a+"(", open-1, close);
        process(a+")", open, close-1);
    }
}
