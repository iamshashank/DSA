package com.company.greedy_binarysearch;

import java.util.Arrays;

/**
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the
 * array sweetness.
 *
 * You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces
 * using K cuts, each piece consists of some consecutive chunks.
 *
 * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your
 * friends.
 *
 * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
 *
 * Example 1:
 *
 * Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * Output: 6
 * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
 *
 * Example 2:
 *
 * Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
 * Output: 1
 * Explanation: There is only one way to cut the bar into 9 pieces.
 *
 */


public class DivideChocolate {
    public int process(int[] chocolate, int k){
        int maxForMeTillNow = 1;
        // we have K friends + me so total k+1 chunks me divide karna hai
        // here we have to divide sweetness, and doing so make it so that i get the max value but at same time
        // all my friends have to get more than me or at least equal
        // they cannot have value less than me
        // best case scenario its possible to divide chocolate evenly by sweetness and everyone gets the same value
        // in this particular case the max possible value can be sum(sweetnesss)/K+1
        if(chocolate.length < k+1) return 0; // not possible
        int low = 1, high = Arrays.stream(chocolate).sum()/(k+1);
        // so what this means is that at best "me" can get "high" amount of sweetness or any amount from low ... high
        // searching each possibility is inefficient so we will use binary search for this
        // we will try to see if "me" can get mid = (low+high)/2 amount if not then we try between low ... mid-1
        while(low < high){
            int mid = (low+high)/2;
            if(canShare(chocolate,k,mid)){
                maxForMeTillNow = Math.max(mid, maxForMeTillNow);
                // see we can get more
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return maxForMeTillNow;
    }

    public boolean canShare(int[] chocolate, int k, int w){
        int cuts = 0;
        int sum = 0;
        for(int i=0;i<chocolate.length;i++){
            sum += chocolate[i];
            if(sum >= w){
                cuts++;
                sum = 0;
            }
        }
        return cuts >= k;
    }
}
