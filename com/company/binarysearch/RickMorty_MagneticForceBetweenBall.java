package com.company.binarysearch;

import java.util.Arrays;

/**
 * 1552. Magnetic Force Between Two Balls
 * Medium
 *
 * In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.
 *
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 *
 * Given the integer array position and the integer m. Return the required force.
 *
 *
 *
 * Example 1:
 *
 * Input: position = [1,2,3,4,7], m = 3
 * Output: 3
 * Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
 *
 * Example 2:
 *
 * Input: position = [5,4,3,2,1,1000000000], m = 2
 * Output: 999999999
 * Explanation: We can use baskets 1 and 1000000000.
 */

public class RickMorty_MagneticForceBetweenBall {
    int l;
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        l = pos.length;

        int low = 1;
        int high = pos[l-1];
        int ans = 0;
        while(low <= high){
            int mid = (low+high)/2;
            if(arrangementPossible(pos, mid, m)){
                ans = mid;
                // try to increase the min gap
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    boolean arrangementPossible(int[] p, int k, int m){
        int lastBallAt = 0;
        int diff = 0;
        m--; // place the 1st one at lowest index 0
        for(int i=1;i<l;i++){
            diff = (p[i] - p[lastBallAt]);
            if(diff >= k){
                // place a ball in bucket `i`
                m--;
                lastBallAt = i;

            }
        }
        return m <= 0; // check if we were able to place all `m` balls with `k` gap
    }
}
