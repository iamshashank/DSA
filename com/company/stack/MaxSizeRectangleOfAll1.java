package com.company.stack;

// https://leetcode.com/problems/maximal-rectangle/

// Given a 2D matrix of 0s and 1s, find maximum size rectangle of all 1s in this matrix.
// 0 |1 1 1| 0
// 1 |1 1 1| 1
// 0  0 0 0  0

import java.util.Arrays;
import java.util.Stack;

// this is based on LargestRectangleInHistogram using stack
// here each row of matrix is considered a histogram and we run the Histogram logic on that
public class MaxSizeRectangleOfAll1 {
    public int process(int[][] a){
        int max = Integer.MIN_VALUE;
        int n = a.length;
        int m = a[0].length;
        int[] h = new int[m];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< n; i++){
            for(int j = 0; j<m; j++){
                // add if 1 else 0
                if(a[i][j] == 1)
                    h[j] = h[j]+a[i][j];
                else
                    h[j] = 0;
            }

//            max = Math.max(new LargestRectangleInHistogram().process(h), max);

            System.out.println(Arrays.toString(h));
            // now our histogram is ready for this iteration
            stack.clear();

            // start of histogram logic
            int curr = 0;
            for(int x = 0; x <h.length; x++){
                // if element smaller than top of stack then pop
                while(!stack.empty() && h[x] < h[stack.peek()]){
                    int top = stack.pop();
                    if(stack.empty()){
                        curr = h[top] * x;
                    }else{
                        curr = h[top] * (x - stack.peek() -1);
                    }
                    max = Math.max(max, curr);
                }
                stack.push(x);
            }
            while (!stack.empty()){
                int top = stack.pop();
                if(stack.empty()){
                    curr = h[top] * h.length;
                }else{
                    curr = h[top] * (h.length - stack.peek() -1);
                }
                max = Math.max(max, curr);
            }
            // end of histogram logic

        }

        return max;
    }

    public int setup(){
        int[][] a = new int[][]{
                {0,1,1,1,0},
                {1,1,1,1,0},
                {0,1,0,1,0},
                {0,1,1,0,0},
        };
        return process(a);
    }

    public int anotherLogic(int[] a){
        // this is exactly like rain water trapping logic
        // for each index we find the smaller value to the left called as previousSmallerElement
        // and smaller value to the right called nextSmallerElement
        int max = Integer.MIN_VALUE;
        int[] pse = previousSmallerElement(a); // these return index of PSE
        int[] nse = nextSmallerElement(a);     // returns index of NSE corresponding to each index
        for(int i =0; i<a.length; i++){
            int area = a[i] * (nse[i] - pse[i] -1);
            max = Math.max(area, max);
        }
        return max;
    }

    public int[] nextSmallerElement(int[] a){
        int[] res = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for(int i = a.length -1; i>0; i--){
            while(!s.empty() && a[s.peek()] >= a[i] ) s.pop();
            res[i] = s.empty() ? a.length : s.peek();
            s.push(i);
        }
        return res;
    }

    public int[] previousSmallerElement(int[] a){
        int[] res = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i <a.length; i++){
            while(!s.empty() && a[s.peek()] >= a[i]) s.pop();
            res[i] = s.empty() ? -1 : s.peek();
            s.push(i);
        }
        return res;
    }
}
