package com.company;

/**
 *
 * You are given a 0-indexed integer array nums of length n.
 *
 * nums contains a valid split at index i if the following are true:
 *
 *     The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
 *     There is at least one element to the right of i. That is, 0 <= i < n - 1.
 *
 * Return the number of valid splits in nums.
 *
 */

public class NoOfWaysToSplitArray {
    public int waysToSplitArray(int[] a) {
        int l = a.length;
        long[] s = new long[l];
        s[0] = a[0];
        for(int i =1;i<l;i++){
            s[i] = s[i-1] + a[i];
        }
        int c = 0;
        for(int i=0;i<l-1; i++){
            long prev = s[i];
            long next = s[l-1] - prev;
            if(prev >= next)
                c++;
        }
        return c;
    }
}
