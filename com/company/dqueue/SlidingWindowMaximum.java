package com.company.dqueue;

import java.util.*;

/**
 *
 * 239. Sliding Window Maximum
 * Hard
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 */

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k >= nums.length){
            Arrays.sort(nums);
            return new int[]{nums[nums.length-1]};
        }
        int[] ans = new int[nums.length-k+1];
        int  low = 0, high = 0;
        // we need the max value in the window in log(N)
        Deque<Integer> dq = new ArrayDeque<>();
        // monotonic decreasing dqueue or in descending order
        // the idea is we only want to add elements to dq if the incoming number is smaller than what at back of queue
        // this way the front of the queue will always have the max value of the window
        while(high < nums.length){
            // we store index in dq
            while (!dq.isEmpty() && nums[high] > nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(high); // this adds at the end

            // out of bounds check
            // if the first element in dqueue or the max is falling outside the window we remove it
            if(dq.peekFirst() < low )
                dq.removeFirst();

            // as soon as high reaches k we start filling in ans array
            if(high+1 >= k){
                ans[low] = nums[dq.peekFirst()];
                low++;
            }
            high++;
        }

        return ans;
    }

    public int[] usingTreeSet(int[] nums, int k){
        if(k >= nums.length){
            Arrays.sort(nums);
            return new int[]{nums[nums.length-1]};
        }
        TreeMap<Integer, Integer> map = new TreeMap(); // ascending
        int[] ans = new int[nums.length-k+1];
        int i = 0;
        int low = 0, high = 0;
        while(high < nums.length){
            if(high >= k){
                ans[i++] = map.lastKey();
                // remove last el
                int t = nums[low++];
                int count = map.getOrDefault(t, 0);
                if(count == 1){
                    map.remove(t);
                }else{
                    map.put(t, count-1);
                }
            }
            int t = nums[high++];
            int count = map.getOrDefault(t, 0);
            map.put(t, count+1);
        }
        ans[i] = map.lastKey();
        return ans;
    }
}
