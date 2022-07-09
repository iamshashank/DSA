package com.company.greedy;

import java.util.PriorityQueue;

/**
 *
 * 1642. Furthest Building You Can Reach
 * Medium
 *
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 *
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 *
 * While moving from building i to building i+1 (0-indexed),
 *
 *     If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 *     If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 *
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * Output: 4
 * Explanation: Starting at building 0, you can follow these steps:
 * - Go to building 1 without using ladders nor bricks since 4 >= 2.
 * - Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
 * - Go to building 3 without using ladders nor bricks since 7 >= 6.
 * - Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
 * It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
 *
 * Example 2:
 *
 * Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * Output: 7
 *
 * Example 3:
 *
 * Input: heights = [14,3,19,3], bricks = 17, ladders = 0
 * Output: 3
 *
 */
public class FarthestBuildingYouCanReach {
    public int furthestBuilding(int[] h, int b, int lad) {
        // this will store max amount of bricks we have used to climb over a building till now
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y)->{
            return y-x;
        });
        int l = h.length;
        for(int i=0;i<l-1;i++){
            if(h[i+1] <= h[i]){
                // do nothing simply jump ahead
            }else{
                // we need to use bricks/ladder
                int diff = h[i+1] - h[i];
                if(b >= diff){
                    b -= diff;
                    q.add(diff);
                }else{
                    // we dont have enough bricks
                    // now either we use ladder or reclaim bricks
                    if(lad > 0){
                        if(!q.isEmpty() && q.peek() > diff){
                            // if we can reclaim more bricks than currently needed then we swap our previous use of bricks with ladder
                            lad--;
                            b += q.remove();
                            b -= diff; // now climb to next
                            q.add(diff);
                        }else{
                            lad--; // use a ladder
                        }
                    }else{
                        // we dont have bricks and dont have ladder so we heached out max possible sol
                        return i;
                    }
                }
            }
            // System.out.println(b+" "+lad);
        }
        // if it reached here then it climed all the way
        return l-1;
    }
}
