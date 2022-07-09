package com.company;

import java.util.Arrays;

public class Google_CountRoomsInCircularStreet {
    public int process(int[] a){
        System.out.println(a.length);
        int i =0;
        System.out.println(Arrays.toString(a));
        while(true) {
            int prev = 0;
            while(a[i] == 1) {
                a[i] = 0;
                i++;
                if(i == a.length) i = 0;
                prev++;
            }
            System.out.println(Arrays.toString(a));
            int cur = 0;
            while(a[i] == 0) {
                a[i] = 1;
                i--;
                if(i < 0) i = a.length-1;
                cur++;
            }
            System.out.println(Arrays.toString(a));
            if (cur == prev) return cur;
        }
    }
}
