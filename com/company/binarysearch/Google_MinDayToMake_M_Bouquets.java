package com.company.binarysearch;

/**
 * 1482. Minimum Number of Days to Make m Bouquets
 * Medium
 *
 * You are given an integer array bloomDay, an integer m and an integer k.
 *
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 *
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 *
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * Output: 3
 * Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
 * We need 3 bouquets each should contain 1 flower.
 * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
 * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
 * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
 *
 * Example 2:
 *
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
 * Output: -1
 * Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
 *
 * Example 3:
 *
 * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * Output: 12
 * Explanation: We need 2 bouquets each should have 3 flowers.
 * Here is the garden after the 7 and 12 days:
 * After day 7: [x, x, x, x, _, x, x]
 * We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
 * After day 12: [x, x, x, x, x, x, x]
 * It is obvious that we can make two bouquets in different ways.
 */

public class Google_MinDayToMake_M_Bouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 0, r = 0;
        for(int d : bloomDay) r = Math.max(r, d);
        int ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(isValid(bloomDay, mid, m, k)){
                ans = mid;
                //lets try to improve ans see we can get the Bouquets ready before mid
                r = mid -1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    boolean isValid(int[] a, int mid, int bouquetsNeeded, int size){
        int currCount = 0, currSize = 0;
        for(int d : a){
            if(d <= mid) currSize++;
            else currSize = 0;

            if(currSize == size) {
                currCount++;
                currSize = 0;
            }
        }
        return currCount >= bouquetsNeeded;
    }
}
