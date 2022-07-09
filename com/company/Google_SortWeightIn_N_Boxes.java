package com.company;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Give an array of boxes with size N+1 with its weight is from 1->N. The final element is empty marked with an 0.
 * Sort the boxes from lightest to heaviest where you can only move 1 box at a time to the empty slot. You should do it in o(N) time.
 */

public class Google_SortWeightIn_N_Boxes {
    public int[] sort(int[] a){
        int n = a.length;
        int[] map = new int[n];
        System.out.println(Arrays.toString(a));

        for(int i=0;i<n;i++) map[a[i]] = i;
        System.out.println(Arrays.toString(map));
        int idxZero = n-1;

        for(int box=1;box<n;box++){
            // this box should be at index `box-1`
            if(map[box] == box-1) continue;
            // move whatever is at index `box-1` to idxZero
            a[idxZero] = a[box-1];
            map[a[box-1]] = idxZero;
            // over our box to box-1
            a[box-1] = box;
            // update zero index
            idxZero = map[box];
            map[box] = box-1;
        }
        a[n-1] = 0;

        return a;
    }
}
