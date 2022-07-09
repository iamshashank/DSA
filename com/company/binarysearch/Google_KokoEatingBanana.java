package com.company.binarysearch;

/**
 * 875. Koko Eating Bananas
 * Medium
 *
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 *
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 *
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 */

public class Google_KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        // in this if we h < len(piles) then solution not possible
        int l = piles.length;
        if(h < l) return -1;

        // find the max in array
        int max = 0;
        int sum = 0;
        for(int i=0;i<l;i++) {
            max = Math.max(max, piles[i]);
            sum += piles[i];
        }

        if(h == l){
            // we need to to finish each pile in 1 go so whatever it takes to finish the largest
            return max;
        }

        // now h > l so we have some wiggle room
        // since koko can only work on 1 pile in 1 turn
        // at most efficient case scenario koco get to eat same k amount every day to eat
        // int he worst case kobo has to eat max amount on any 1 day and rest days she has to eat less than k
        int low = (int)Math.ceil((double)sum/h);

        int high = max;

        // we try to find out best solution with these limit using binary search
        // If Koko can eat all the piles with a speed of nnn, she can also finish the task with the speed of n+1n + 1n+1. With a larger eating speed, Koko will spend less or equal time on every pile. Thus, the overall time is guaranteed to be less than or equal to that of the speed nnn.
        // If Koko can't finish with a speed of nnn, then she can't finish with the speed of n−1n - 1n−1 either. With a smaller eating speed, Koko will spend more or equal time on every pile, thus the overall time will be greater than or equal to that of the speed nnn.
        int mid = low;
        while(low < high){
            mid = (low+high)/2;
            if(canEat(piles, mid, h)){
                // then she can definitly eat at mid+1 so we look for a smaller answer
                high = mid;
            }else{
                low = mid+1;
            }
        }

        return high;
    }

    boolean canEat(int[] p, int k, int h){
        int hoursNeeded = 0;
        for(int i=0;i<p.length;i++){
            hoursNeeded += Math.ceil((double)p[i]/k);
        }
        return hoursNeeded <= h;
    }

}
