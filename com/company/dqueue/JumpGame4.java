package com.company.dqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1696. Jump Game VI
 * Medium
 *
 * You are given a 0-indexed integer array nums and an integer k.
 *
 * You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array.
 * That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.
 *
 * You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.
 *
 * Return the maximum score you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-1,-2,4,-7,3], k = 2
 * Output: 7
 * Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
 *
 * Example 2:
 *
 * Input: nums = [10,-5,-2,4,0,3], k = 3
 * Output: 17
 * Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
 *
 * Example 3:
 *
 * Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * Output: 0
 *
 */

public class JumpGame4 {
    public int maxResult(int[] n, int k) {
        int l = n.length;
        if(l == 1) return n[0];

        int[] dp = new int[l];
        Deque<Integer> dq = new ArrayDeque<>(); // store index in this
        dp[0] = n[0];
        dq.add(0);

        // we want dequeue to maintain index of the largest el before index i and i-k
        for(int i =1; i<l;i++){
            // check out of bounds
            if(i-dq.peekFirst() > k) dq.removeFirst();
            // add to dp
            dp[i] = n[i] + dp[dq.peekFirst()];
            while(!dq.isEmpty() && dp[i] > dp[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        return dp[l-1];
    }
}
