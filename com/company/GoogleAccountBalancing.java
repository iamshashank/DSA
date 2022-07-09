package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GoogleAccountBalancing {
    public int process(int[][] t){
        int row = t.length, col = 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 0;
        // we need to know how many people are involved
        for(int i=0; i< row;i++){
            if(!map.containsKey(t[i][0])){
                map.put(t[i][0], k++);
            }
            if(!map.containsKey(t[i][1])){
                map.put(t[i][1], k++);
            }
        }
        int[] res = new int[k];
        int greaterThanZero = 0;
        int lessThanZero = 0;
        for(int i=0;i<row;i++){
            int u1 = map.get(t[i][0]);
            int u2 = map.get(t[i][1]);
            res[u1] -= t[i][2];
            res[u2] += t[i][2];
        }

        for(int i =0;i<res.length;i++){
            if(res[i] > 0){
                greaterThanZero++;
            } else if(res[i] <= -1 ){
                lessThanZero++;
            }
        }
        return Math.max(lessThanZero, greaterThanZero);
    }
}
