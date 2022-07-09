package com.company.priorityqueue_heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 *
 * 2233. Maximum Product After K Increments
 * Medium
 *
 * You are given an array of non-negative integers nums and an integer k. In one operation, you may choose any element from nums and increment it by 1.
 *
 * Return the maximum product of nums after at most k operations. Since the answer may be very large, return it modulo 109 + 7. Note that you should maximize the product before taking the modulo.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,4], k = 5
 * Output: 20
 * Explanation: Increment the first number 5 times.
 * Now nums = [5, 4], with a product of 5 * 4 = 20.
 * It can be shown that 20 is maximum product possible, so we return 20.
 * Note that there may be other ways to increment nums to have the maximum product.
 *
 * Example 2:
 *
 * Input: nums = [6,3,3,2], k = 2
 * Output: 216
 * Explanation: Increment the second number 1 time and increment the fourth number 1 time.
 * Now nums = [6, 4, 3, 3], with a product of 6 * 4 * 3 * 3 = 216.
 * It can be shown that 216 is maximum product possible, so we return 216.
 * Note that there may be other ways to increment nums to have the maximum product.
 *
 */

public class MaxProductAfterKIncrement {
    public int nonHeapSolution(int[] nums, int k){
        if(nums.length == 1) return nums[0]+k;
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int i=0;
        int compareToIndex = i+1;
        while(k>0){
            i = 0;
            while(k>0 && nums[compareToIndex-1] != nums[compareToIndex]){
                k--;
                nums[i]++;
                i = (i+1)%compareToIndex;
            }
            compareToIndex++;
            if(compareToIndex == nums.length) break; // now we need to do equal distrubution
        }

        i = 0;
        while(k>0){
            nums[i]++;
            k--;
            i = (i+1)%nums.length;
        }

        System.out.println(Arrays.toString(nums));
        long ans = 1;
        for(i =0;i<nums.length;i++){
            ans *= nums[i];
            ans = ans%1000000007;
        }

        return (int)(ans);
    }

    public int heapSolution(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums) {
            minHeap.offer(num);
        }
        for(int i=0;i<k;i++) {
            minHeap.offer(minHeap.poll() + 1);
        }
        long answer = 1;
        int mod = 1000000007;
        while(!minHeap.isEmpty()) {
            answer *= minHeap.poll();
            answer %= mod;
        }
        return (int)answer;
    }
}

