package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.youtube.com/watch?v=_sA1xI4XK0c
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 *
 *
 */

public class GoogleCountOfSmallerNumberAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int L = nums.length;
        int[] c = new int[L];
        int[][] num = new int[L][2];
        for(int i = 0;i<L;i++){
            num[i][0] = nums[i];
            num[i][1] = i;
        }
        mergeSort(c, num, 0, L-1); // decending order
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<L;i++){
            list.add(c[i]);
        }
        return list;
    }

    public void mergeSort(int[] c, int[][] a, int l, int r){
        int mid = (l+r)/2;
        if(l < r){ // we dont need  l == r as it will be single character by then
            mergeSort(c, a, l, mid);
            mergeSort(c, a, mid+1, r);
            merge(c, a, l, mid, r);
        }
    }

    public void merge(int[] c, int[][] a, int l, int m, int r){
        int size = (r - l + 1);
        int[][] tmp = new int[size][2];
        int k = 0; // counter for tmp
        int i = l;
        int j = m+1;
        while(i <= m && j <= r){
            if(a[i][0] <= a[j][0]){
                // decending so we add j and increment its counter
                tmp[k][0] = a[j][0];
                tmp[k][1] = a[j][1];
                k++;
                j++;
            }else{
                // here we increase the counter
                // a[i][1] store the index of a[i] in orginal array
                // why we are doing r - j +1
                // we are standing on arr1 and we are looking at arr2
                // both these array are sorted in themselves
                // so if we find a arr1[i] which is greater than arr2[j] the every element in arr2 from j to r will be guarenteed smaller than arr1[i]
                // because all sun-arrays are in themselves are in descending
                // so we find out how many elements lie from j to r  = r-j+1
                c[a[i][1]] += r -j +1;
                tmp[k][0] = a[i][0];
                tmp[k][1] = a[i][1];
                k++;
                i++;
            }
        }

        while(i<=m){
            tmp[k][0] = a[i][0];
            tmp[k][1] = a[i][1];
            k++;
            i++;
        }

        while(j<=r){
            tmp[k][0] = a[j][0];
            tmp[k][1] = a[j][1];
            k++;
            j++;
        }

        for(i = l; i<= r; i++){
            a[i][0] = tmp[i-l][0];
            a[i][1] = tmp[i-l][1];
        }

    }

}
