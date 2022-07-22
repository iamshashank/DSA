package com.company.kadane;

public class KadaneContigousSubarrayWithLargestSum {
    public int process(int[] a){
        int max = Integer.MIN_VALUE;
        int maxTillNow = 0;
        for(int i=0; i<a.length;i++){
            // we need contigous
            // what we try to do is as long is maxTillNow is +ive we add it to max
            // once it becomes negative then we know that it will decrease our max
            maxTillNow = maxTillNow + a[i];
            max = Math.max(max, maxTillNow);
            if(maxTillNow < 0)
                maxTillNow = 0;
        }
        return max;
    }
}
