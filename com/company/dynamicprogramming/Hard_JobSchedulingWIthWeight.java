package com.company.dynamicprogramming;

import java.util.Arrays;

public class Hard_JobSchedulingWIthWeight {
    /**
     * Normal DP similar to LIS Longest common subsequence but it will TLE
     */
    public int jobSchedulingTLE(int[] s, int[] e, int[] p) {
        int l = s.length;
        Job[] j = new Job[l];
        for(int i=0;i<l;i++) j[i] = new Job(s[i], e[i], p[i]);
        // we will sort in ascending by end time
        Arrays.sort(j, (a, b)->{
            return a.e - b.e;
        });
        // for(int i=0;i<l;i++) System.out.println(j[i].s+" "+j[i].e);
        int[] dp = new int[l];
        // inititally if each job is by itself then max profit is the profit from the job itself
        for(int i=0;i<l;i++) dp[i] = j[i].p;
        // this will use nested loop similar to LIS longest increasing subsequnece
        // System.out.println(Arrays.toString(dp));
        for(int i=1;i<l;i++){
            for(int k=0;k<i;k++){
                if(!overlapping(j[k], j[i])){
                    dp[i] = Math.max(dp[i], dp[k]+j[i].p);
                }
            }
            // System.out.println(Arrays.toString(dp));
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<l;i++) ans = Math.max(ans, dp[i]);
        return ans;
    }


    public int jobScheduling(int[] s, int[] e, int[] p) {
        int l = s.length;
        Job[] j = new Job[l];
        for(int i=0;i<l;i++) j[i] = new Job(s[i], e[i], p[i]);
        // we will sort in ascending by end time
        Arrays.sort(j, (a,b)->{
            return a.e - b.e;
        });

        // the dp[i] will store answer if we only consider first i jobs
        // answer in dp[] will in ascending order
        int[] dp = new int[l];
        dp[0] = j[0].p;

        for(int i=1;i<l;i++){
            // use binary search to find a largest previous index which is not overlapping
            int previndex = search(j, i);
            // System.out.println(previndex);
            if(previndex == -1){
                // we didnt find any non-overlapping job before j[i] so just compare to the previous dp[i-1]
                // d[i] will have max ans we can get till now if dp[i-1] has better solution we will not j[i] into the solution
                dp[i] = Math.max(dp[i-1], j[i].p);
            }else{
                // se if we can do better from the prev one
                dp[i] = Math.max(dp[i-1], dp[previndex]+j[i].p);
            }
            // System.out.println(Arrays.toString(dp));
        }

        return dp[l-1];
    }

    int search(Job[] j, int i){
        int ans = -1;
        int l = 0, r = i-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(j[mid].e <= j[i].s){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }


    boolean overlapping(Job a, Job b){
        return a.e > b.s;
    }

    class Job{
        public int s,e,p;
        Job(int s, int e, int p){
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }
}
