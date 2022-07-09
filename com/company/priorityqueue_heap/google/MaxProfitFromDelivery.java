package com.company.priorityqueue_heap.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You have n items, cost is c(i) and delivery cost is d(i). If customer orders more than one item, then they get it for the minimum delivery cost. How do you find the maximum amount of money you can make after delivering m items? I know this is a knapsack problem, but I just can't find a way to solve it. And I want to make sure I am able to solve these problems for future interviews.
 *
 * For e.g.
 * cost and delivery cost respectively (first column being cost, second being delivery cost):
 * Item 1: 7, 10
 * Item 2: 4, 15
 * Item3: 8, 1
 *
 * m = 2
 *
 * Input format (java): int n, int m, int[][] arr where n is the total number of items, m is the maximum number of items you can deliver, arr has each row with first element being cost, second being delivery cost.
 *
 * Output: 31 (You choose the first two items because if you chose the 3rd item, the delivery cost for 2 items would be 1 + 1 (since 1 is the mimimum delivery cost) so you would end up with 23 + 2 = 25.
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

public class MaxProfitFromDelivery {
    public int maxProfit(int n, int[] cost, int[] deliveryCost, int k) {
        List<Pair> e = new ArrayList<>();
        for(int i =0;i<n;i++){
            e.add(new Pair(cost[i], deliveryCost[i]));
        }
        // sort by eff
        Collections.sort(e, (a, b)->{ return b.e - a.e; });
        // PQ stores the speed in asc order
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long costSum = 0, profit = Integer.MIN_VALUE;
        for(Pair p : e){
            if(q.size() == k){
                costSum -= q.remove();
            }
            // add the new one
            q.add(p.s);
            costSum += p.s;
            profit = Math.max(profit, ((costSum)*p.e*q.size()));
            // perf = perf % 1000000007;
        }
        return (int)(profit%1000000007);
    }

    private class Pair{
        public int s,e;
        Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
}
