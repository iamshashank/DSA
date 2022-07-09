package com.company;

import java.util.Arrays;

/**
 * ODD LENGTH MAGIC SQUARE
 * In any magic square, the first number i.e. 1 is stored at position (n/2, n-1). Let this position be (i,j). The next number is stored at position (i-1, j+1) where we can consider each row & column as circular array i.e. they wrap around.
 *
 * Three conditions hold:
 *
 *     1. The position of next number is calculated by decrementing row number of the previous number by 1,
 *     and incrementing the column number of the previous number by 1. At any time, if the calculated row position becomes -1,
 *     it will wrap around to n-1. Similarly, if the calculated column position becomes n, it will wrap around to 0.
 *
 *     2. If the magic square already contains a number at the calculated position, calculated column position will be decremented by 2,
 *     and calculated row position will be incremented by 1.
 *
 *     3. If the calculated row position is -1 & calculated column position is n, the new position would be: (0, n-2).
 */

public class Google_MagicSquareOdd {
    public int[][] genMagicSquare(int n){
        int grid[][] = new int[n][n];

        int i = n/2, j = n-1; // base condition for number 1

        for(int x=1;x<=n*n;){
            // condition 3
            if(i == -1 && j == n){
                i = 0; j = n-2;
            }else{
                // wrap around
                if(i < 0){
                    i = n-1;
                }
                if(j == n){
                    j = 0;
                }
            }

            // condition 2
            if(grid[i][j] != 0){
                // already occupied
                i += 1;
                j -= 2;
                continue;
            }else{
                // fill the grid
                grid[i][j] = x++;
            }

            // condition 1
            i--;
            j++;
        }
        return grid;
    }

    void process(int n){
        int[][] g = genMagicSquare(n);
        for(int[] a : g){
            System.out.println(Arrays.toString(a));
        }
    }
}
