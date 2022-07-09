package com.company.dynamicprogramming;

import java.util.Arrays;

// https://www.youtube.com/watch?v=o_AJ3VWQMzA
public class EggDroping {
    public int process(int floors, int eggs) {
        // to cover edge case we make + 1 larger 2d matrix Floor * Eggs
        int[][] dp = new int[floors + 1][eggs + 1];

        // base conditions if you have N floors and 1 egg it will take N attempts because we need to check 1 floor at a time
        for (int i = 0; i < floors + 1; i++) {
            dp[i][1] = i;
        }
        // base condition if you have 1 floor and K eggs it will only take 1 attempt, number of eggs dont matter
        for (int i = 1; i < eggs + 1; i++) {
            dp[1][i] = 1;
        }

        for (int n = 2; n < floors + 1; n++) {
            for (int e = 2; e < eggs + 1; e++) {
                dp[n][e] = Integer.MAX_VALUE;
                for (int x = 1; x <= n ; x++) {
                    int eggNotBroken = dp[n - x][e - 1];
                    int eggBroken = dp[x - 1][e];
                    dp[n][e] = Math.min(dp[n][e], Math.max(eggBroken, eggNotBroken) + 1);
                }
            }
        }
//        for (final int[] a : dp) {
//            System.out.println(Arrays.toString(a));
//        }
        return dp[floors][eggs];
    }

    public int calculateRecursive(int eggs, int floors){
        if(eggs == 1){
            return floors;
        }
        if(floors == 0){
            return 0;
        }
        int min = 1000;
        for(int i=1; i <= floors; i++){
            int val = 1 + Math.max(calculateRecursive(eggs-1, i-1),calculateRecursive(eggs, floors-i));
            if(val < min){
                min = val;
            }
        }
        return min;
    }


    /**
     * Only 2 eggs
     */
    public int twoEggDrop(int n) {
        int egg = 2;
        int[][] dp = new int[n+1][egg+1]; // to avoid zero index nonsense
        for(int i=1;i<n+1;i++) dp[i][1] = i; // if only 1 egg we go to each floor and check
        for(int i=2;i<egg+1;i++) dp[1][i] = 1; // if we have more than 1 egg but only 1 floor then it will always take 1 attempt
        for(int f = 2;f<n+1;f++){
            for(int e = 2; e<egg+1; e++){
                dp[f][e] = Integer.MAX_VALUE;
                // now for each f, e we have to decide from which floor we want to drop the egg
                // start from lowest floor upto f floor
                for(int k=1;k<=f;k++){
                    int eggNotBreak = dp[f-k][e]; // we have check all bove floors
                    int eggBreak = dp[k-1][e-1]; // we have check from all below floors and left with e-1 egg
                    dp[f][e] = Math.min(dp[f][e], 1 + Math.max(eggNotBreak, eggBreak));
                }
            }
        }
        return dp[n][egg];
    }

}
