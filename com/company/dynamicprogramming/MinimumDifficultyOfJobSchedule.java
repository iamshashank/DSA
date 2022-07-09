package com.company.dynamicprogramming;

import java.util.Arrays;

/**
 * 1335. Minimum Difficulty of a Job Schedule
 * Hard
 *
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
 *
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 *
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 */

public class MinimumDifficultyOfJobSchedule {
    int l;
    int[] jd;
    int dp[][];
    public int minDifficulty(int[] job, int d) {
        // since jobs are dependent we cannot sort the array
        l = job.length;
        jd = job;
        dp = new int[l][d+1];
        for(int i=0;i<l;i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        if(l < d) return -1;
        dp[0][d] = f(0, d);
        return dp[0][d];
    }

    // we have split jobs between D days
    // each day has to get atleast 1 job
    // find min answer
    int f(int index, int daysLeft){
        // base case
        if(daysLeft == 1){
            // if only 1 day left then all remainaing jobs auto go that day
            return max(index, -1);
        }
        if(dp[index][daysLeft] != Integer.MAX_VALUE) return dp[index][daysLeft];
        // we are doing l-d+1 to make sure we have atleast 1 job left for each of the upcoming d-1 days
        // say we have 5 jobs and 4 days so when at index 0 we can at max do 2 jobs j[0], j[1] so that the rest
        // 3 days have 1 job left each (5-4+1 = 2) so i can go to 0 and 1
        for(int i=index;i<l-daysLeft+1;i++){
            int curr = max(index, i+1) + f(i+1, daysLeft-1);
            dp[index][daysLeft] = Math.min(curr, dp[index][daysLeft]);
        }
        return dp[index][daysLeft];
    }

    int max(int i, int j){
        int max = jd[i];
        if(j == -1) j = l; // search till end of array
        for(;i<j;i++){
            max = Math.max(max, jd[i]);
        }
        return max;
    }
}
