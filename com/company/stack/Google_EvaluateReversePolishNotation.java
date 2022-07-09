package com.company.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Google_EvaluateReversePolishNotation {
    public int evaluate(String[] exp){
        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String c : exp){
            if(!c.equals("=") && !c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")){
                stack.push(c);
            }else{
                String b = stack.pop();
                String a = stack.pop();
                if(c.equals("=")){
                    if(map.containsKey(b)){
                        map.put(a, map.get(b));
                    }else{
                        map.put(a, Integer.valueOf(b));
                    }
                }else {
                    int A = map.containsKey(a) ? map.get(a) : Integer.valueOf(a);
                    int B = map.containsKey(b) ? map.get(b) : Integer.valueOf(b);
                    int ans = 0;
                    if(c.equals("+")){
                        ans = A+B;
                    } else if (c.equals("-")) {
                        ans = A-B;
                    } else if (c.equals("*")) {
                        ans = A*B;
                    } else {
                        ans = A/B;
                    }
                    stack.push(ans+"");
                }
            }
        }

        return Integer.valueOf(stack.pop());
    }
}
