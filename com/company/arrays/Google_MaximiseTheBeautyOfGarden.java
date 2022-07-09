package com.company.arrays;

import java.util.HashMap;

/**
 *
 *
 1788. Maximize the Beauty of the Garden

 There is a garden of n flowers, and each flower has an integer beauty value. The flowers are arranged in a line. You are given an integer array flowers of size n and each flowers[i] represents the beauty of the ith flower.

 A garden is valid if it meets these conditions:

 The garden has at least two flowers.
 The first and the last flower of the garden have the same beauty value.

 As the appointed gardener, you have the ability to remove any (possibly none) flowers from the garden. You want to remove flowers in a way that makes the remaining garden valid. The beauty of the garden is the sum of the beauty of all the remaining flowers.

 Return the maximum possible beauty of some valid garden after you have removed any (possibly none) flowers.



 Example 1:

 Input: flowers = [1,2,3,1,2]
 Output: 8
 Explanation: You can produce the valid garden [2,3,1,2] to have a total beauty of 2 + 3 + 1 + 2 = 8.

 Example 2:

 Input: flowers = [100,1,1,-3,1]
 Output: 3
 Explanation: You can produce the valid garden [1,1,1] to have a total beauty of 1 + 1 + 1 = 3.

 Example 3:

 Input: flowers = [-1,-2,0,-1]
 Output: -2
 Explanation: You can produce the valid garden [-1,-1] to have a total beauty of -1 + -1 = -2.

 *
 */

public class Google_MaximiseTheBeautyOfGarden {
    /**
     * In this we will loop from 0 to N and keep a sum variable in which we will keep on adding the current value so it
     * will store the total sum up till now
     * We will also maintain a hash which will store the first occurence of a beauty value and sum till them
     * jtna sum hua hai usko ek hash me store karnge for qucik access (key will be the beauty value and value will be the sum till then)
     * the idea being we want to quickly find what was the sum jab first time we encountered a beauty value
     * we can remove any number of flower and we have to maximise the sun so we will not add negative values to `sum`
     *
     */

    public int process(int[] a){
        int res = Integer.MIN_VALUE, sum =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // job bhi koi beauty value repeat hoga there could be a chance ki final solution uske 1st occurence se current occurence tak hoga
        // so we calculate max beauty we can do till now and store it in max
        for(int i =0;i<a.length;i++){
            if(map.containsKey(a[i])){
                // if we find a beauty value again in the array we will substract the sum till its first occourence then add the beauty value 2 times
                // this way we get sum where first and last beauty value is same
                res = Math.max(res, sum - map.get(a[i]) + 2*a[i]);
            }

            if(a[i]>0) sum += a[i];
            // we will store the sum till first occurrence of a beauty value
            if(!map.containsKey(a[i])) map.put(a[i], sum);
        }
        return res;
    }
}
