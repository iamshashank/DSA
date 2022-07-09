package com.company.binarysearch;

import java.util.Arrays;

public class Google_NearestStore {
    public int[] findStores(int[] h, int[] s){
        Arrays.sort(s);
        int[] res = new int[h.length];
        for(int i=0;i<h.length;i++){
            int idx = Arrays.binarySearch(s, h[i]);
            if(idx >= 0){
                // binarySearch returns >=0 if h[i] will be found
                res[i] = h[i]; // so the closest store will be itself
            }else{
                // (-(insertion point) -1)
                idx = (-1 * idx) - 1; // h[i] wil be inserted here
                int l = 0, r = 0;
                if(idx > 0) l = Math.abs(s[idx-1] - h[i]);
                if(idx < s.length) r = Math.abs(s[idx] - h[i]);
                if(l<=r){
                    res[i] = s[idx-1];
                }else{
                    res[i] = s[idx];
                }
            }
        }
        return res;
    }
}
