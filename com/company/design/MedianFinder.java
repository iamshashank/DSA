package com.company.design;

import java.util.PriorityQueue;

/**
 *
 * 295. Find Median from Data Stream
 * Hard
 *
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 *
 *     For example, for arr = [2,3,4], the median is 3.
 *     For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 *
 * Implement the MedianFinder class:
 *
 *     MedianFinder() initializes the MedianFinder object.
 *     void addNum(int num) adds the integer num from the data stream to the data structure.
 *     double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 *
 *
 *
 * Constraints:
 *
 *     -105 <= num <= 105
 *     There will be at least one element in the data structure before calling findMedian.
 *     At most 5 * 104 calls will be made to addNum and findMedian.
 *
 *
 *
 * Follow up:
 *
 *     If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 *     If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 *
 */

public class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    /**
     * In this problem we need some sort of balanced binary search tree/ AVL tree where root of the tree divides the array into equal halves and is sorted
     * We have simulated the 2 halves of the tree by using 2 priority queue
     */

    public MedianFinder() {
        left = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        right = new PriorityQueue<>((a,b)->{
            return a-b;
        });
    }

    public void addNum(int num) {
        // always add in left then adjust/balance the size
        if(left.size() > 0 && num > left.peek()){
            right.add(num);
        }else{
            left.add(num);
        }


        int ls = left.size(), rs = right.size();
        if((ls+rs)%2 == 0){
            // even
            // odd
            if (ls > rs){
                while(left.size() != right.size()){
                    right.add(left.remove());
                }
            }else if(rs > ls){
                while(right.size() != left.size()){
                    left.add(right.remove());
                }
            }
        }else{
            // odd
            if (ls > rs && (ls-rs) > 1){
                while(left.size() - right.size() == 1){
                    right.add(left.remove());
                }
            }else if(rs > ls && (rs-ls) > 1){
                while(right.size() - left.size() == 1){
                    left.add(right.remove());
                }
            }
        }
        // System.out.println(left);
        // System.out.println(right);
        // System.out.println("---");
    }

    public double findMedian() {
        int ls = left.size(), rs = right.size();
        if(rs == 0) return left.peek();
        if(ls == 0) return right.peek();
        double ans = 0.0;
        if((ls+rs)%2 == 0){
            ans = ((double)left.peek() + (double)right.peek())/2;
        }else{
            if(ls > rs){
                ans = left.peek();
            }else{
                ans = right.peek();
            }
        }
        return ans;
    }
}
