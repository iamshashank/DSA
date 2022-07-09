package com.company.knapsack;

import java.util.Arrays;


/**
 * 1049. Last Stone Weight II
 * Medium
 *
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights x and y with x <= y. The result of this smash is:
 *
 *     If x == y, both stones are destroyed, and
 *     If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 *
 * At the end of the game, there is at most one stone left.
 *
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
 *
 * Example 2:
 *
 * Input: stones = [31,26,33,21,40]
 * Output: 5
 *
 *
 *
 * Constraints:
 *
 *     1 <= stones.length <= 30
 *     1 <= stones[i] <= 100
 */

public class Google_LastStoneWeight {
    // 0 - 1 Knasack to split array in parts of total_sum/2
    // this is same as
    // 2035. Partition Array Into Two Arrays to Minimize Sum Difference
    // https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
    // we need to partition the array into 2 such that diff of sum(part1) - sum(part2) is min
    // in best scenario we get get both partition sum to sum(total array)/2 then diff is 0
    public int lastStoneWeightII(int[] stones) {
        int totalSum = Arrays.stream(stones).sum();
        // knapsack DP
        // dp array will tell us which what weight can be formed by the stones
        boolean[] dp = new boolean[totalSum/2+1];
        dp[0] = true; // given n stones we can always split it such that we get weight 0, ie: by taking 0 stones
        int maxWeightReached = 0;
        for(int s : stones){
            // this cloning is necessary because this way we dont recount the multiples of `s`
            // notice we are checking dp[i-s] with orginal copy but updating the new copy
            // otherwise if dp[3] = 1 then dp[6] will be also be one because dp[6-3] = 1
            // same way dp[9-3] = dp[6] will also be 1 but in realty only dp[3] will be 1 ans
            boolean[] temp = dp.clone();
            for(int i = s;i<dp.length;i++){
                if(dp[i-s]){
                    // it is possible
                    temp[i] = true;
                    maxWeightReached = Math.max(i, maxWeightReached);
                    if(maxWeightReached == totalSum/2) return Math.abs(totalSum - maxWeightReached*2);
                }
            }
            dp = temp;
        }
        // so for 1 partition we reached a sum of maxWeightReached
        // so the other remaining partition sum is (totalSum - maxWeightReached)
        // so the ans is diff of 2 partitions = (totalSum - maxWeightReached) - maxWeightReached OR totalSum - 2*maxWeightReached
        return Math.abs(totalSum - maxWeightReached*2);
    }
}
