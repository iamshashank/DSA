package com.company.priorityqueue_heap;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * Medium
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 *
 * Constraints:
 *
 *     1 <= k <= nums.length <= 104
 *     -104 <= nums[i] <= 104
 */

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        // if we have find 2nd greatest then we only main 2 el in Queue in ascending order
        // so by the end we will only have k el in queue and top will be the smalled in queue but kth greatest
        for(int n : nums){
            if(q.size() < k){
                q.add(n);
            }else{
                if(n > q.peek()){
                    q.remove();
                    q.add(n);
                }
            }
        }
        return q.remove();
    }
}
