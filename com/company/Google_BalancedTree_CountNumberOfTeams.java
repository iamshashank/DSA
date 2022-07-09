package com.company;

import java.util.TreeSet;

/**
 *https://leetcode.com/problems/count-number-of-teams/
 * 1395. Count Number of Teams
 * Medium
 *
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 *
 * You have to form a team of 3 soldiers amongst them under the following rules:
 *
 *     Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 *     A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 *
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 *
 *
 *
 * Example 1:
 *
 * Input: rating = [2,5,3,4,1]
 * Output: 3
 * Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
 *
 * Example 2:
 *
 * Input: rating = [2,1,3]
 * Output: 0
 * Explanation: We can't form any team given the conditions.
 *
 * Example 3:
 *
 * Input: rating = [1,2,3,4]
 * Output: 4
 *
 */

public class Google_BalancedTree_CountNumberOfTeams {
    public int numTeams(int[] rating) {
        /**
         *
         *
         * TreeSet is balance tree implementation
         * In normal form (when comparator not given for ordering) its in ascending order
         * so finding things like how many elements are smaller than N by using headSet(N)
         * and tailSet(N) will tell us how many elements are greater than N
         * All this is done in log(N) time so dont have to loop and search in O(N) time
         *
         *
         * Here since we have to arrange in group of three that means that if we are on index i if we know how many smaller elements are behind us (k)
         * and how many greater in front of us (v) the number of 3 length increasing subsequence that can be formed are k*v
         *
         */
        TreeSet<Integer> left = new TreeSet<>(), right= new TreeSet<>();
        for(int n: rating) right.add(n);
        int cnt = 0;
        for(int n: rating){
            right.remove(n);
            cnt += left.headSet(n).size() * right.tailSet(n).size(); // for LIS od size 3
            cnt += left.tailSet(n).size() * right.headSet(n).size(); // for decreasing subsequences of size 3
            left.add(n);
        }
        return cnt;
    }
}
