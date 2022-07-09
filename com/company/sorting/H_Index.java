package com.company.sorting;

import java.util.Arrays;

/**
 * 274. H-Index
 * Medium
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.
 *
 * If there are several possible values for h, the maximum one is taken as the h-index.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 *
 * Example 2:
 *
 * Input: citations = [1,3,1]
 * Output: 1
 */

public class H_Index {
    public int hIndex(int[] c) {
        Arrays.sort(c);
        int res = 1;
        for(int i =c.length-1;i>=0;i--){
            // [0,1,3,5,6] - > [0,1,3,5,6]
            // jitna hum peechecaa rahe utna res ko badha rahe (res stores kitne paper have atleast c[i] >= H   )
            // initially when res = 1 it means h-index = 1 and it mean atleast 1 of the paper should have more than 1 citation which is true
            // then we try for bigger answer because we need to return max H-index
            if(c[i] >= res){
                res++;
            }
        }

        return res-1;
    }
}
