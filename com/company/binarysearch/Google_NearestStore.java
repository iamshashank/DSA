package com.company.binarysearch;

import java.util.Arrays;

/**
 * You are given 2 arrays representing integer locations of stores and houses (each location in this problem is one-dementional).
 * For each house, find the store closest to it.
 * Return an integer array result where result[i] should denote the location of the store closest to the i-th house.
 * If many stores are equidistant from a particular house, choose the store with the smallest numerical location.
 * Note that there may be multiple stores and houses at the same location.
 *
 * Example 1:
 *
 * Input: houses = [5, 10, 17], stores = [1, 5, 20, 11, 16]
 * Output: [5, 11, 16]
 * Explanation:
 * The closest store to the house at location 5 is the store at the same location.
 * The closest store to the house at location 10 is the store at the location 11.
 * The closest store to the house at location 17 is the store at the location 16.
 *
 * Example 2:
 *
 * Input: houses = [2, 4, 2], stores = [5, 1, 2, 3]
 * Output: [2, 3, 2]
 *
 * Example 3:
 *
 * Input: houses = [4, 8, 1, 1], stores = [5, 3, 1, 2, 6]
 * Output: [3, 6, 1, 1]
 */

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
