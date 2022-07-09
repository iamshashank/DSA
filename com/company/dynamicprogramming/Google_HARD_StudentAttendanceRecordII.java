package com.company.dynamicprogramming;

import java.util.HashMap;

/**
 *
 * 552. Student Attendance Record II
 * Hard
 *
 * An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
 *
 *     'A': Absent.
 *     'L': Late.
 *     'P': Present.
 *
 * Any student is eligible for an attendance award if they meet both of the following criteria:
 *
 *     The student was absent ('A') for strictly fewer than 2 days total.
 *     The student was never late ('L') for 3 or more consecutive days.
 *
 * Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 8
 * Explanation: There are 8 records with length 2 that are eligible for an award:
 * "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: 3
 *
 * Example 3:
 *
 * Input: n = 10101
 * Output: 183236316
 *
 */

public class Google_HARD_StudentAttendanceRecordII {

    /**
     * Best dp solution
     * https://www.youtube.com/watch?v=D5g-KZWbh6Y
     * @param n
     * @return
     */
    public int checkRecordDP(int n) {
        long[][][] dp = new long[n+1][3][2]; // 0,1,2 for late 0,1 for absent

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        dp[1][1][0] = 1;
        dp[1][1][1] = 0;
        dp[1][2][0] = 0;
        dp[1][2][1] = 0;

        for(int i=2;i<=n;i++){
            // since absent will always be 0 and consicitiveLate will also be 0 the only possibilities are tha we added Present at the last entry
            // so we previous entry could have been either present, 1 Late, 2 Late
            dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0])%mod ;
            // here we have 1 absent so its possible that the last entry is absent or some where in middle
            dp[i][0][1] = (dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0] + dp[i-1][0][1] + dp[i-1][1][1] + dp[i-1][2][1])%mod ;
            dp[i][1][0] = (dp[i-1][0][0])%mod;
            dp[i][1][1] = (dp[i-1][0][1])%mod;
            dp[i][2][0] = (dp[i-1][1][0])%mod;
            dp[i][2][1] = (dp[i-1][1][1])%mod; // since we need consicutive2 L + 1 Absent we have to come from 1 consicutive L and 1 absent
        }
        long ans = 0;
        for(int i =0;i<3;i++){
            for(int j =0;j<2;j++){
                ans = (ans + (dp[n][i][j]%mod))%mod;
            }
        }
        return (int)ans;
    }


    // SOLUTION 1 TIMES_OUT
    HashMap<String, Integer> map;
    long mod = 1000000007;

    // LOGIC 1
    public int checkRecord(int n) {
        // dymamic + memoization
        map = new HashMap<>();
        return solve(n,0,0);
    }

    // the idea is we are only generating the postive cases where student gets the award
    // so we will never allow more than 1 absent and more than 2 late
    // param consecutiveLate tells how many consecutive LATE at the end of the attendence register
    public int solve(int n, int absent, int consecutiveLate){
        if(n==0) return 1;
        if(map.containsKey(n+"#"+absent+"#"+consecutiveLate)){
            return map.get(n+"#"+absent+"#"+consecutiveLate);
        }
        long ans = 0;
        if(absent < 1){
            // we can allow 1 absent
            ans += solve(n-1, absent+1, 0); // we are making consecutiveLate 0 because consecutiveLate tell how many but sice we are adding 'A' in this case so we make it 0
            // ans = ans%mod;
        }
        if(consecutiveLate < 2){
            // we can allow upto 2 late days
            ans += solve(n-1, absent, consecutiveLate+1);
            // ans = ans%mod;
        }
        // case where are present on this day
        ans += solve(n-1, absent, 0);

        ans = ans%mod;

        int t = (int) ans;
        map.put(n+"#"+absent+"#"+consecutiveLate, t);
        return t;
    }

    // LOGIC 2
    int N;
    public int checkRecord2(int n) {
        N = n;
        // dymamic + memoization
        map = new HashMap<>();
        return solve(0,0,0);
    }

    // the idea is we are only generating the postive cases where student gets the award
    // so we will never allow more than 1 absent and more than 2 late
    // param consecutiveLate tells how many consecutive LATE at the end of the attendence register
    public int solve2(int n, int absent, int consecutiveLate){


        if(absent == 2) return 0;
        if(consecutiveLate == 3) return 0;
        if(n == N) return 1; // this condition has to come last so that we cont count wrong ans incase absent > 1 or late > 2

        if(map.containsKey(n+"#"+absent+"#"+consecutiveLate)){
            return map.get(n+"#"+absent+"#"+consecutiveLate);
        }

        long ans = 0;
        // we can allow upto 2 consicutive late days
        ans += solve(n+1, absent, consecutiveLate+1);

        // we can allow 1 absent
        // we are making consecutiveLate 0 because consecutiveLate tell how many but sice we are adding 'A' in this case so we make it 0
        ans += solve(n+1, absent+1, 0) ;


        // case where are present on this day
        ans += solve(n+1, absent, 0);

        int t = (int)(ans%mod);

        map.put(n+"#"+absent+"#"+consecutiveLate, t);
        return t;
    }

}
