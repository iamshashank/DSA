package com.company.dynamicprogramming;

//https://leetcode.com/problems/minimum-cost-for-tickets/submissions/
// https://www.youtube.com/watch?v=on7MoPbgefk
//You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
//
//        Train tickets are sold in three different ways:
//
//        a 1-day pass is sold for costs[0] dollars,
//        a 7-day pass is sold for costs[1] dollars, and
//        a 30-day pass is sold for costs[2] dollars.
//
//        The passes allow that many days of consecutive travel.
//
//        For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
//
//        Return the minimum number of dollars you need to travel every day in the given list of days.
//
//
//        Input: days = [1,4,6,7,8,20], costs = [2,7,15]
//        Output: 11
//        Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
//        On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
//        On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
//        On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
//        In total, you spent $11 and covered all the days of your travel.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {

    public int process(int[] days, int[] cost){
        int L = days.length;
        int offset = 29;
        // dp[i] is the min cost till that day
        // if i is not in Set<> that means we do not have to travel that day so cost till that day will be 0 + dp[i-1]
        // dp[i] = min of (1 day pass + dp[i-1]), 7 day cost + dp[i-7], 30 day cost + dp[i-30]
        int[] dp = new int[366]; // it can go it -29 so we offset everything so dp[-29] is at index dp[-29 + 29 = 0]
        Set<Integer> set = new HashSet<>();
        for(int d : days){
            set.add(d);
        }
        for(int i = 1; i < 366; i++ ){
            if(set.contains(i)){
                dp[i] = Math.min( cost[0] + dpAt(i-1, dp), Math.min( cost[1] + dpAt(i-7, dp),  cost[2] + dpAt(i-30, dp) ) );
            }else{
                dp[i] = dp[i-1] + 0;
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[days[L-1]];
    }

    public int dpAt(int i, int[] dp){
        if(i < 1) return 0;
        return dp[i];
    }

    public int setup(){
        return process(new int[]{1,4,6,7,8,20}, new int[]{2,7,15});
    }
}
