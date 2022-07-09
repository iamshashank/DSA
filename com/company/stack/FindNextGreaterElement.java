package com.company.stack;


// use the same logic as RemoveKDigitsFromANumber using stack
// calculate the answers (Next greater number) in 1 go

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

// given a array a= [1, 3, 4, 2] and queries = [4, 1, 2] for each queries find th next greater element & -1 if next exists
// a = [1,3,4,2], q = [4, 1, 2] output = [-1, 3, -1]

public class FindNextGreaterElement {
    public String process(int[] a, int[] q){
        HashMap<Integer, Integer> map = new HashMap();

        // create a table which store index of each element
        for(int i = 0; i< a.length; i++){
            map.put(a[i], i);
        }

        int[] t = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = a.length -1; i >=0; i-- ){
            // so we are finding NextGreatestFor a[i]
            if(stack.empty()){
                t[i] = -1;
            }else {
                while(!stack.empty() && a[i] > stack.peek() ){
                    stack.pop();
                }
                if(stack.empty()){
                    // no greater number present
                    t[i] = -1;
                }else{
                    // we found a number which is greater
                    t[i] = stack.peek();
                }
            }
            stack.push(a[i]);
        }
        int[] result = new int[q.length];
        for(int i=0; i<q.length; i++){
            result[i] = t[map.get(q[i])];
        }
        return Arrays.toString(result);
    }
}
