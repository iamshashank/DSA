package com.company.priorityqueue_heap.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1383. Maximum Performance of a Team
 * Hard
 *
 * You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.
 *
 * Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
 *
 * The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.
 *
 * Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * Explanation:
 * We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
 *
 * Example 2:
 *
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68
 * Explanation:
 * This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5 to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
 *
 * Example 3:
 *
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * Output: 72
 *
 *
 *
 * Constraints:
 *
 *     1 <= k <= n <= 105
 *     speed.length == n
 *     efficiency.length == n
 *     1 <= speed[i] <= 105
 *     1 <= efficiency[i] <= 108
 */

/**
 * It is tough to maintain both sum of speed and minimum of efficiency and to find optimal answer
 * In this type of questions we have to fix a parameter, here we can fix minimum efficiency
 * If we sort {efficiency,speed} in decreasing efficiency, we know for ith efficiency, since everything from 1 to i-1
 * is more than it, ith is the minimum. So from 1 to i-1 if we have the sum of best k-1 speeds we can team them
 * with ith and we do this for every i and keep taking its maximum.
 * Note that to find topk sum we can use a heap and maintain its size as less than equal to k and also
 * keep track of sum of the elements present in heap
 */

public class MaxPerformanceOfTeam {
    public int maxPerformance(int n, int[] speed, int[] eff, int k) {
        List<Pair> e = new ArrayList<>();
        for(int i =0;i<n;i++){
            e.add(new Pair(speed[i], eff[i]));
        }
        // sort by eff
        Collections.sort(e, (a, b)->{ return b.e - a.e; });
        // PQ stores the speed in asc order
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long sumOfSpeed = 0, perf = Integer.MIN_VALUE;
        for(Pair p : e){
            if(q.size() == k){
                sumOfSpeed -= q.remove();
            }
            // add the new one
            q.add(p.s);
            sumOfSpeed += p.s;
            perf = Math.max(perf, (sumOfSpeed)*p.e);
            // perf = perf % 1000000007;
        }
        return (int)(perf%1000000007);
    }

    private class Pair{
        public int s,e;
        Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
}
