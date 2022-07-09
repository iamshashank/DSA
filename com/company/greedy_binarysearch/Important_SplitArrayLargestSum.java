package com.company.greedy_binarysearch;


import java.util.Arrays;

/**
 *
 *https://leetcode.com/problems/split-array-largest-sum/
 *
 * 410. Split Array Largest Sum
 * Hard
 *
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m sub-arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two sub-arrays is only 18.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], m = 2
 * Output: 9
 *
 * Example 3:
 *
 * Input: nums = [1,4,4], m = 3
 * Output: 4
 *
 */


/**
 *
 * FLIPKART
 * len(a) is number of books
 * array `a` tells us how many pages a book has
 * a = [2,3,4,5,1,3]
 * We need to distribute these books among `m` students such that each students atleast gets 1 book
 * And each the number of pages a students has to read is minimum
 *
 *
 * EXAMPLE 2
 *
 * Shipping on conveyor-belt items with weight given
 * We need to decide the items so that it can be shipped in M days
 * [w1, w2, w3, w4, w5]
 * we need to decide what's needs to be the max which conveyor belt needs to handle
 *
 *
 * EXAMPLE 3
 *
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

public class Important_SplitArrayLargestSum {
    public int min = Integer.MAX_VALUE;
    public int process(int[] a, int m){
        int low = 0, high = 0;
        for(int i = 0; i<a.length;i++){
            high += a[i];
            // here we observe that we can start from max in the array
            // because in the worse case of we had to decide the array in sub arrays of len = 1 then also max sum among those
            // sub-array will the max in the array
            // that is  why low = max(in arr)
            low = Math.max(low, a[i]);
        }

        if(m == 1)
            return high;
        while(low <= high){
            int mid = (low + high)/2;
            if(allocationPossible(a, mid, m)){
                // then we try to improve the solution
                min = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return min;
    }

    public boolean allocationPossible(int[] a, int maxPage, int m){
        int sum = 0;
        int studentNeeded = 0;

        // we give boks to each students 1 by 1 and make sure each get only get at most maxPage
        // like this we calculate how many students are needed
        for(int i =0;i<a.length;i++){
            if(sum + a[i] > maxPage ){
                studentNeeded++;
                sum = a[i]; // for the next student
            }else{
                sum += a[i];
            }
        }
        studentNeeded++;
        // here if we can divide the books among the students then return true

        if(studentNeeded <= m){
            return true;
        }
        return false;
    }
}
// [7, 2, 5, 10, 8]
