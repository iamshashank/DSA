package com.company.binarysearch;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Implementing upper_bound() and lower_bound() in C
 *
 *     Difficulty Level : Medium
 *     Last Updated : 06 Aug, 2021
 *
 * Given a sorted array arr[] of N integers and a number K, the task is to write the C program to find the upper_bound() and lower_bound() of K in the given array.
 * Examples:
 *
 *
 *     Input: arr[] = {4, 6, 10, 12, 18, 20}, K = 6
 *     Output:
 *     Lower bound of 6 is 6 at index 1
 *     Upper bound of 6 is 10 at index 2
 *     Input: arr[] = {4, 6, 10, 12, 18, 20}, K = 20
 *     Output:
 *     Lower bound of 20 is 20 at index 5
 *     Upper bound doesn’t exist
 */

public class Google_LowerUpperBoundBinarySearch {

    private int lowerBound(int[] a, int l, int r, int v){
        int N = r;
        while(l<r){
            int mid = (l+r)/2;
            if(v <= a[mid]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(l < N && a[l] < v) l++; // [1,2,4,5] and we are searching 3, after the loop l = 1, but it should be 2 as `3` will be inserted at index 2
        return l;
    }

    private int upperBound(int[] a, int l, int r, int v){
        int N = l;
        int S = l;
        while(l<r){
            int mid = (l+r)/2;
            if(v >= a[mid]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        if(l < N && a[l] <= v) l++;
        return l;
    }

    public void process(int[] a, int b){
        System.out.println(lowerBound(a, 0, a.length, b));
        System.out.println(upperBound(a, 0, a.length, b));
    }

}
