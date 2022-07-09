package com.company.arrays;

import java.util.HashSet;

/**
 *
 * 840. Magic Squares In Grid
 * Medium
 *
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 *
 * Given a row x col grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 *
 */

public class NumberOfMagicSquareSize3 {
    HashSet<Integer> set;
    public int numMagicSquaresInside(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        if(grid.length < 3 || grid[0].length < 3) return 0;
        set = new HashSet<>();

        int ans = 0;
        for(int i =2;i<x;i++){
            for(int j =2;j<y;j++){

                boolean flag = addToSet(i,j, grid);
                // System.out.println(flag);
                if( flag == false) continue;

                int r1 = grid[i-2][j-2] + grid[i-2][j-1] + grid[i-2][j];

                int r2 = grid[i-1][j-2] + grid[i-1][j-1] + grid[i-1][j];
                int r3 = grid[i][j-2] + grid[i][j-1] + grid[i][j];

                int c1 = grid[i-2][j-2] + grid[i-1][j-2] + grid[i][j-2];
                int c2 = grid[i-2][j-1] + grid[i-1][j-1] + grid[i][j-1];
                int c3 = grid[i-2][j] +   grid[i-1][j] +   grid[i][j];

                int d1 = grid[i-2][j-2] + grid[i-1][j-1] + grid[i][j];
                int d2 = grid[i][j-2] + grid[i-1][j-1] + grid[i-2][j];

                if(r1 == r2 && r1 == r3 && r1 == c1 && r1 == c2 && r1 == c3 && r1 == d1 && r1 == d2 && set.size() == 9){
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public boolean addToSet(int i, int j, int[][] grid){
        set.clear();
        for(int p=i;p>=i-2;p--){
            for(int q = j;q>=j-2;q--){
                if(grid[p][q] > 9 || grid[p][q] < 1) return false; // it has to be 1 to 9
                set.add(grid[p][q]);
            }
        }
        return set.size() == 9;
    }
}
