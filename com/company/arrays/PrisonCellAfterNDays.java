package com.company.arrays;

/**
 * 957. Prison Cells After N Days
 * Medium
 *
 * There are 8 prison cells in a row and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 *     If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 *     Otherwise, it becomes vacant.
 *
 * Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.
 *
 * You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the ith cell is vacant, and you are given an integer n.
 *
 * Return the state of the prison after n days (i.e., n such changes described above).
 *
 *
 *
 * Example 1:
 *
 * Input: cells = [0,1,0,1,1,0,0,1], n = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation: The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * Example 2:
 *
 * Input: cells = [1,0,0,1,0,0,1,0], n = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 *
 */

public class PrisonCellAfterNDays {
    // Trick to this question is the pattern repeats after 14 days
    // if you are lazy enough to write it or print it and find the pattern ->
    // use a hashmash or string[] and see that the days when same array-as-string repeats every 14 days
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] t = cells;
        n = n%14 == 0 ? 14 : n%14; // we find actual number of days we need to calculate
        while(n > 0){
            t = process(t);
            n--;
        }
        return t;
    }

    int[] process(int[] c){
        int[] t = new int[8];
        // as we can see the it dosent matter what values ar there c[0] and c[7] = 0 from day 1
        // so hard code but not needed as t[0] t[7] already 0

        for(int i=1;i<7;i++){
            if((c[i-1] == 0 && c[i+1] == 0 ) || (c[i-1] == 1 && c[i+1] == 1)){
                t[i] = 1;
            }
        }
        return t;
    }
}
