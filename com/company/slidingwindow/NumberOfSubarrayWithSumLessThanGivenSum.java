package com.company.slidingwindow;


// You are provided with an array containing n non-negative numbers, as well as a non-negative number sum.
// You must determine the number of subarrays in a whose sum is less than the sum.
// We can make the assumption that there is no overflow. Sample input and output for the given problem is as follows:

//Input: a = [2, 5, 6]
//        sum = 10
//        Output: 4
// [2] [5] [6] [2, 5]
public class NumberOfSubarrayWithSumLessThanGivenSum {
    public int process(int[] a, int S){
        int l =0, r=0, result = 0, sum =0;
        for(r =0; r<a.length; r++){
            sum += a[r];
            //shrink when condition failing
            while(sum > S){
                sum -= a[l++];
            }
            // this is the meat of the question
            // here the main logic is that at each iteration the new length of the window is the number of new sub-array that needs to be counted
            result +=  r-l+1;
        }
        return result;
    }
}
