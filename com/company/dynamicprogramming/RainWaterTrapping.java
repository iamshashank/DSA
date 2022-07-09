package com.company.dynamicprogramming;

public class RainWaterTrapping {
    public int trap(int[] h) {
        int l = h.length;
        if(l == 0) return 0;
        int[] maxL = new int[l];
        int[] maxR = new int[l];
        maxL[0] = h[0];
        maxR[l-1] = h[l-1];

        for(int i=1;i<l;i++){
            maxL[i] = Math.max(h[i], maxL[i-1]);
        }
        for(int i=l-2;i>=0;i--){
            maxR[i] = Math.max(h[i], maxR[i+1]);
        }
        int ans = 0;
        for(int i =1;i<l-1;i++){
            ans += (Math.min(maxL[i], maxR[i]) - h[i]);
        }
        return ans;
    }
}
