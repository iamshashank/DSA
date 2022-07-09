package com.company.dynamicprogramming;

import java.util.Arrays;

public class Google_MinSwapsToMakeArrayincreasing {
    int[][] dp;
    public int minSwap(int[] a, int[] b) {
        if(a.length != b.length) return -1;
        dp = new int[a.length+1][2]; // dp[i][0] is for when not swapped d[i][1] for swapped
        for(int i = 0;i<a.length;i++)
            Arrays.fill(dp[i], -1);

        return swapFunction(a,b,0, 0);
    }

    // int s is the number of sawps make in a particular recursive path
    public int swapFunction(int[]a, int[] b, int i, int previousElSwapped){
        // if(s > ans) return; // if out current path is already worse than the old answer whats the point
        // base condition
        if(i == a.length) return 0;
        if(dp[i][previousElSwapped] != -1) return dp[i][previousElSwapped];
        int r = Integer.MAX_VALUE;
        if(previousElSwapped == 0){ // that means previous element is not swapped so all conditions are normal
            // i == 0 we can swap or not, or what ever is smaller
            if(i==0) r = Math.min(Math.min(r, swapFunction(a,b,i+1, 0)), 1 + swapFunction(a,b, i+1, 1));
            //  if its already in increasing we dont need to swap
            if(i>0 && a[i] > a[i-1] && b[i] > b[i-1]) r = Math.min(r, swapFunction(a,b,i+1,0));
            // but we also can swap if after swapping the array is still in increasing order
            if(i>0 && a[i] > b[i-1] && b[i]>a[i-1]) r = Math.min(r, 1+ swapFunction(a,b,i+1,1));
        }else{
            // a[i-1] and b[i-1] are swapped in previous recursive call
            // i == 0 we can swap or not, what ever is smaller
            if(i==0) r = Math.min(Math.min(r, swapFunction(a,b,i+1, 0)), 1 + swapFunction(a,b, i+1, 1));
            //  if its already in increasing we dont need to swap
            if(i>0 && a[i] > b[i-1] && b[i] > a[i-1]) r = Math.min(r, swapFunction(a,b,i+1,0));
            // but we also can swap if after swapping the array is still in increasing order
            if(i>0 && a[i] > a[i-1] && b[i]>b[i-1]) r = Math.min(r, 1 + swapFunction(a,b,i+1,1));
        }
        dp[i][previousElSwapped] = r;
        return r;
    }
}
