package com.company.binarysearch;

/**
 * 1760. Minimum Limit of Balls in a Bag
 * Medium
 *
 * You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.
 *
 * You can perform the following operation at most maxOperations times:
 *
 *     Take any bag of balls and divide it into two new bags with a positive number of balls.
 *         For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
 *
 * Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.
 *
 * Return the minimum possible penalty after performing the operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [9], maxOperations = 2
 * Output: 3
 * Explanation:
 * - Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
 * - Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
 * The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
 */

public class MinimumLimitOfBallsInBag {
    int l;
    public int minimumSize(int[] n, int mo) {
        l = n.length;
        int max = 0, min = 0;
        for(int i=0;i<l;i++){
            max = Math.max(max, n[i]);
            min = Math.min(min, n[i]);
        }
        int low = 1; // each bag has 1 ball
        int high = max;
        int ans = low;
        while(low <= high){
            int mid = (low+high)/2;
            if(maxPenaltyPossible(n, mid, mo)){
                ans = mid;
                // try to minimise penalty
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }

    // check if we can get a max penalty of K using `mo` operations
    boolean maxPenaltyPossible(int[] n, int k, int mo){
        int max = 0;
        for(int i=0;i<l;i++){
            if(n[i] > k){
                // if n[i] = 7 and k=2 we need to split it into 4 parts and it and requires 4-1= 3 1 less operations so we use Math.floor
                // also if n[i] is fully divisible by K then we get 1 extra cut so we need to decrement by 1
                // example n[i] = 9 and k=3 we can split it into 3 group having 3 each and it will require 3 split but 9/3=3 gives us 3 so we decrement by 1
                int numberOfTimesItNeedsToBeSplitInto_K_Size_Chunks = (int)Math.floor((n[i]-1)/k);
                if(mo >= numberOfTimesItNeedsToBeSplitInto_K_Size_Chunks){
                    // we have `mo` left to make splits and there will be some parts of K size and last one of n[i]%k size which is smaller than K
                    max = Math.max(max, k);
                    mo -= (numberOfTimesItNeedsToBeSplitInto_K_Size_Chunks);
                }else{
                    return false; // unable to split and make it compliant
                }
            }else{
                max = Math.max(max, n[i]);
            }
        }
        return max <= k;
    }
}
