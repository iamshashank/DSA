package com.company.binarysearch;

/**
 * https://www.interviewbit.com/blog/count-inversions-of-an-array/
 * Question:
 * Two arrays are given of length n and two numbers c and d.
 * Find the count of all pairs that follow the condition : a[i]-a[j]+c <= b[i]-b[j]+d such that i < j.
 *
 * Constraints:
 *
 * 2 <= n < 1e5
 * 1 <= a[i], b[i] <= 1e9
 */

import java.util.*;

/**
 * THIS TOPIC IS CALLED COUNT-INVERSION / GLOBAL  INVERSION
 * it is solved in O(NlogN) using merge sort
 * Try to fix i and then find j with binary search
 * a[i] - b[i] + c - d <= a[j] - b[j]    i < j
 */
public class Google_CountPair_satisfying_condition {
    public int process(int[] a, int[] b, int c, int d){
        int n = a.length;
        int ans = 0;
        Pair[] diff = new Pair[n];
        for(int i=0;i<n;i++) {
            diff[i] = new Pair(i, (a[i] - b[i] + c - d));
        }
        return mergeSort(diff, 0, n-1);
    }

    int mergeSort(Pair[] a, int l, int r){
        int inversion = 0;
        if(l<r){
            int mid = (l+r)/2;
            inversion += mergeSort(a, l, mid);
            inversion += mergeSort(a, mid+1, r);
            inversion += merge(a, l, mid, r);
        }
        return inversion;
    }

    int merge(Pair[] a, int l, int mid, int r){
//        System.out.println(l+":"+mid+":"+r);
        int inversion = 0;
        int l1 = mid-l+1;
        int l2 = r-mid;
        Pair[] t1 = new Pair[l1];
        Pair[] t2 = new Pair[l2];
        for(int i =0; i<l1;i++){
            t1[i] = a[l+i];
        }
        for(int i =0; i<l2;i++){
            t2[i] = a[mid+1+i];
        }
        int i = 0, j = 0, k = l;
        while(i < l1 && j < l2){
            // DESC
            if(t1[i].diff <= t2[j].diff ){
                inversion += l1 - i;
                a[k++] = t2[j++];
            }else{
                a[k++] = t1[i++];
            }
        }
        while(i < l1){
            a[k++] = t1[i++];
        }
        while(j < l2){
            a[k++] = t2[j++];
        }

        return inversion;
    }

    private class Pair{
        int index, diff;
        Pair(int index, int diff){
            this.index = index;
            this.diff = diff;
        }

        public String toString(){
            return diff+"";
        }
    }
}
