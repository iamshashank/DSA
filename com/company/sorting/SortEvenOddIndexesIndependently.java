package com.company.sorting;

import java.util.Arrays;
import java.util.Collections;

public class SortEvenOddIndexesIndependently {
    public int[] sortEvenOdd(int[] n) {
        int ol = n.length/2;
        int el = n.length-ol;
        int ei = 0;
        int oi = 0;
        int[] o = new int[ol];
        int[] e = new int[el];
        for(int i =0;i<n.length;i++){
            if(i%2==0){
                e[ei++] = n[i];
            }else{
                e[oi++] = n[i];
            }
        }
        Arrays.sort(e);
        Arrays.sort(o);
        oi = 0;
        ei = 0;
        for(int i =0;i<n.length;i++){
            if(i%2==0){
                n[i] = e[ei++];
            }else{
                n[i] = o[oi++];
            }
        }
        return n;
    }
}
