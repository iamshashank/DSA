package com.company.dynamicprogramming;

// https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
//Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed). Choose a subset of cuboids and place them on each other.
//  You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj. You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.
//  Return the maximum height of the stacked cuboids.


//Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
//        Output: 190
//        Explanation:
//        Cuboid 1 is placed on the bottom with the 53x37 side facing down with height 95.
//        Cuboid 0 is placed next with the 45x20 side facing down with height 50.
//        Cuboid 2 is placed next with the 23x12 side facing down with height 45.
//        The total height is 95 + 50 + 45 = 190.


//Input: cuboids = [[38,25,45],[76,35,3]]
//        Output: 76
//        Explanation:
//        You can't place any of the cuboids on the other.
//        We choose cuboid 1 and rotate it so that the 35x3 side is facing down and its height is 76.

import java.util.Arrays;
import java.util.Comparator;


// This uses similar logic as LongestIncreasingSubsequence
public class BoxStackingToGetMaxHeight {
    public int process(int[][] c){

        // sort/rotate each cuboid such that height is max so ascending
        for(int i=0; i<c.length;i++){
            Arrays.sort(c[i]);
        }

        // now sort the cuboids in ascending order
        // first compare length, if length equal then compare width, if that too equal the compare height
        Arrays.sort(c, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]){
                    return -1;
                }else if(o1[0] == o2[0]){
                    // if length are equal sort by width
                    if(o1[1] < o2[1]){
                        return -1;
                    }else if(o1[1] == o2[1]){
                        if(o1[2] < o2[2]){
                            return -1;
                        }
                        return 1;
                    }
                    return 1;
                }
                return 1;
            }
        });


        int[] dp = new int[c.length];
        int max = 0;
        // base conditiopn
        // each cube by itself can give height c[i][2]
        for(int i=0;i<c.length;i++){
            dp[i] = c[i][2];
        }

        // LongestIncreasingSubsequence
        for(int i=1;i<c.length;i++){
            for(int j=0; j<i; j++){
                if(c[i][0] >= c[j][0] && c[i][1] >= c[j][1] && c[i][2] >= c[j][2]){ // check if the 2 cube c[j] can be placed on top of c[i]
                    if(dp[j] + c[i][2] > dp[i] ){ // if we get height than existing then store new height
                        dp[i] = Math.max(dp[i], dp[j] + c[i][2] );
                    }
                }
            }
        }

        for(int i =0;i<c.length;i++)
            max = Math.max(max, dp[i]);
        return max;
    }


    public void setup() {
        int a = process(new int[][]{
                {50,45,20},{95,37,53},{45,23,12}
        });
        System.out.println(a);
    }
}
