package com.company.binarysearch;


/**
 *
 *
 * Consider an array arr of distinct numbers sorted in increasing order. Given that this array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
 *
 * Examples:
 *
 *     Input: arr[] = {15, 18, 2, 3, 6, 12}
 *     Output: 2
 *     Explanation: Initial array must be {2, 3, 6, 12, 15, 18}. We get the given array after rotating the initial array twice.
 *
 *     Input: arr[] = {7, 9, 11, 12, 5}
 *     Output: 4
 *
 *     Input: arr[] = {7, 9, 11, 12, 15};
 *     Output: 0
 *
 *
 */

public class NumberOfRotationsOfSortedArray {

    public int process(int[] a){
        int ans = 0;
        int low = 0, high = a.length-1;
        int n = a.length;
        while(low <= high){
            int mid = (low + high)/2;
            int prev = (mid - 1 + n) % n; // to cover edge case if mid = 0 its left value is the last element of the array
            int next = (mid + 1) % n;

            if(a[mid] < a[next] && a[mid] < a[prev] ){
                return mid;
            }else if(a[mid] < a[high]){
                high = mid -1;
            }else if(a[mid] > a[high]){
                low = mid+1;
            }
        }
        return ans;
    }
}
