package com.company.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 */

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows > 0){
            List<Integer> t = new ArrayList<>();
            t.add(1);
            ans.add(t);
        }
        if(numRows > 1){
            List<Integer> t = new ArrayList<>();
            t.add(1);
            t.add(1);
            ans.add(t);
        }

        if(numRows > 2){
            for(int i=2;i< numRows;i++){
                List<Integer> t = new ArrayList<>();
                t.add(1);
                List<Integer> prevRow = ans.get(i-1);
                for(int j=1;j<i;j++){
                    t.add(prevRow.get(j-1)+prevRow.get(j));
                }
                t.add(1);
                ans.add(t);
            }
        }

        return ans;
    }

}
