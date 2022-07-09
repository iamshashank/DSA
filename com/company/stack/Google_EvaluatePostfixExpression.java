package com.company.stack;

import java.util.Stack;

public class Google_EvaluatePostfixExpression {
    public int evaluatePostFix(String[] s){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length;i++){
            if(s[i] == "+" || s[i] == "-" || s[i] == "*" || s[i] == "/"){
                int op2 = stack.pop(); // LIFO so the top will be operand 2
                int op1 = stack.pop();
                if(s[i] == "+") stack.push(op1+op2);
                if(s[i] == "-") stack.push(op1-op2);
                if(s[i] == "*") stack.push(op1*op2);
                if(s[i] == "/") stack.push(op1/op2);
            }else{
                stack.push(Integer.valueOf(s[i]));
            }
        }
        return stack.pop();
    }
}
