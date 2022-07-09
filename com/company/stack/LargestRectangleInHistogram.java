package com.company.stack;

import java.util.Stack;

/**
 *
 * 84. Largest Rectangle in Histogram
 * Hard
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 */

public class LargestRectangleInHistogram {

    public int process(int[] a){
        int max = Integer.MIN_VALUE, area = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i < a.length; i++){
            while(!stack.isEmpty() && a[i] < a[stack.peek()]){
                int top = stack.pop(); // this is a index
                int curr = 0;
                if(stack.empty()){
                    curr = a[top] * i;
                }else{
                    // here we are looking at that particular index and checking how much area it covers
                    curr = a[top] * (i - stack.peek() - 1);
                }
                max = Math.max(curr, max);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int top = stack.pop();
            if(stack.isEmpty()){
                area = a[top] * a.length;
            }else{
                area = (a.length - stack.peek() - 1)  * a[top];
            }
            max = Math.max(area, max);
        }
        return max;
    }
}
