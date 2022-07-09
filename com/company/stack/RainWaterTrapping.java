package com.company.stack;

import java.util.Stack;

// monotonic stack similar to the largest rectangle histogram
public class RainWaterTrapping {
    public int trap(int[] h) {
        int l = h.length;
        if(l == 0) return 0;
        Stack<Integer> s = new Stack<>();
        int i =0;
        int ans = 0;
        while(i<l){
            while(!s.isEmpty() && h[i] > h[s.peek()]){
                int top = s.pop();
                if(s.isEmpty()) break; // there is no boundary on left side to hold water
                int width = (i - s.peek() - 1);
                int height = Math.min(h[i], h[s.peek()]) - h[top];
                ans += width*height;
            }
            s.push(i++);
        }
        return ans;
    }
}
