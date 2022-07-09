package com.company.wierd_searching;

/**
 *
 * 240. Search a 2D Matrix II
 * Medium
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 *     Integers in each row are sorted in ascending from left to right.
 *     Integers in each column are sorted in ascending from top to bottom.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 */

public class Search2DMatrix {

    /**
     * In this problem we started comparing the matrix elements from top right corner.
     * If the pointed value is equal to target value then return true.
     * if the pointed value is more than target value then go to left.
     * If the pointed value is less than target then go to down.
     *
     * Time complexity :- O(n+m)
     * Space Complexity :- O(1)
     *
     * @param m
     * @param target
     * @return
     */

    public boolean searchMatrix(int[][] m, int target) {
        int r = m.length;
        int c = m[0].length;
        int i = 0, j = c-1;
        while(i<r && j >=0){
            if(m[i][j] == target){
                return true;
            }else if(m[i][j] < target){
                i++;
            }else{
                j--;
            }
        }

        return false;
    }
}
