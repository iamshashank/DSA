package com.company.hash_and_sorting;

import java.util.Arrays;
import java.util.HashMap;

// google interview
// https://leetcode.com/problems/hand-of-straights/
//Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
//
//        Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
//
//
//
//        Example 1:
//
//        Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//        Output: true
//        Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
//
//        Example 2:
//
//        Input: hand = [1,2,3,4,5], groupSize = 4
//        Output: false
//        Explanation: Alice's hand can not be rearranged into groups of 4.
//


public class HandOfStraight {
    public boolean process(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;
        Arrays.sort(hand);
        int x = hand.length / groupSize;
        int[][] g = new int[x][groupSize];
//        for(int i = 0; i< x; i++){
//            for(int j=0; j< hand.length; j++){
//                g[i][j] = -1;
//            }
//        }
        // this will keep track of till which index we have added values in g[] group array
        int[] index = new int[x];
        int counter = 0;
        for(int i =0; i<hand.length; i++){
            int e = hand[i]; // element to be added
            int tempCounter = counter; // after inserting element in group we will compare new and old counter if value does not change that means solution not possible
            for(int j =0; j<x; j++){
                if(index[j] == 0){
                    // array empty so just insert
                    g[j][index[j]] = e;
                    index[j]++;
                    counter++;
                    break;
                }else if(index[j] != groupSize &&  g[j][index[j] -1] + 1 == e){
                    // index[j] != 0 so there is already some lement in this array so compare it
                    g[j][index[j]] = e;
                    index[j]++;
                    counter++;
                    break;
                }else{
                    continue; // we will let this element go to another group
                }
            }

            // now we compare with tempCounter to check if we were actually able to insert `e` in one of the groups
            // if not then solution does not exists
            if(tempCounter == counter)
                return false;

        }
//        for(int i =0;i< x; i++){
//            System.out.println(Arrays.toString(g[i]));
//        }
        return true;
    }

    // CLEANER LOGIC
    public boolean isPossibleDivide(int[] n, int k) {
        int l = n.length;
        if(l%k != 0) return false;
        Arrays.sort(n);
        // freq map
        HashMap<Integer, Integer> fq = new HashMap<>();

        for(int i=0;i<l;i++) {
            int t = fq.getOrDefault(n[i], 0);
            fq.put(n[i], t+1);
        }

        for(int i = 0; i<l;i++){
            // we try form a k length consicutive array
            if(fq.getOrDefault(n[i],0) == 0) continue;
            for(int j = n[i];j < n[i]+k;j++){
                // we try to see if we have these numbers in our map
                // since the have to be consecutive if we done find any we can return false
                int t = fq.getOrDefault(j, 0);
                if(t == 0){
                    return false;
                }else{
                    // reduce the count
                    fq.put(j, t-1);
                }
            }
        }
        return true;
    }
}
