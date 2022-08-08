package com.company.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


// https://leetcode.com/problems/sort-array-by-increasing-frequency/
//Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
//
//        Return the sorted array.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,2,2,2,3]
//        Output: [3,1,1,2,2,2]
//        Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
//
//        Example 2:
//
//        Input: nums = [2,3,1,3,2]
//        Output: [1,3,3,2,2]
//        Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
//
//        Example 3:
//
//        Input: nums = [-1,1,-6,4,5,-6,1,4,1]
//        Output: [5,-1,4,4,-6,-6,1,1,1]

public class SortArrayInIncreasingFreqOfElements {
    public int[] process(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int t = 0;
        for (int a : nums) {
            if (map.containsKey(a)) {
                t = map.get(a) + 1;
            } else {
                t = 1;
            }
            map.put(a, t);
        }

//        int[][] d = new int[map.size()][2];
        ArrayList<Pair> d = new ArrayList<>();
        map.forEach((k, v) -> {
            d.add(new Pair(v, k));
        });

//        for (Pair a : d) {
//            System.out.println(a.freq + " " + a.value);
//        }

        d.sort((a, b) -> {
            if (a.freq != b.freq) {
                // sort by freq
                return a.freq - b.freq;
            } else {
                // if freq same sort by value in descending
                return b.value - a.value;
            }

        });

//        for (Pair a : d) {
//            System.out.println(a.freq + " " + a.value);
//        }
        ArrayList<Integer> ans = new ArrayList<>();

        d.forEach((a)->{
            while(a.freq > 0){
                ans.add(a.value);
                a.freq--;
            }
        });
        int[] x = new int[ans.size()];
        for(int i =0; i<ans.size();i++){
            x[i] = ans.get(i);
        }
        return x;
    }

    public class Pair{
        public int freq;
        public int value;
        Pair(int a, int b){
            this.freq = a;
            this.value = b;
        }
    }
}
