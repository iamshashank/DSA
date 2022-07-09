package com.company.dfs;

/**
 * Problem Statement -
 * Given a matrix of size n*m, where each position is representing a city.
 * Initially all city are represented by zero. ( means they are not traversible ).
 * On each day one city will randomly become traversible. ( matrix[i][j] = 1 )
 *
 * Write an algorithm that can detect when there is a path from any city of first column to any city of last column.
 *
 * 0 : unvisited
 * 1: visited
 * 2: can reach last column city (if cell being enabled as column index as n-1 ]
 *
 *     If any cell is visited, check all 4 valid direction if any cell is 2 , mark the cell as 2 instead of 1 , that esntially mean we can reach to end.
 *     If the current cell is marked as 2 instead of 1 , do a DFS and remark every 1 as 2 , reason is we are now connected to a 2 based cell and any 1 connected to 2 shd also flip to 2.
 *     if grid[0][0] is 2 , we can reach end , otherwise not.
 *
 * Take this example
 * 4 * 4 grid
 * 0 0 0 0
 * 0 0 0 0
 * 0 0 0 0
 * 0 0 0 0
 *
 *     enabe [1, 1] , [1, 2] , [2, 2] (DFS wont run since column is not last)
 *     0 0 0 0
 *     0 1 1 0
 *     0 0 1 1
 *     0 0 0 0
 *
 *     enable [2, 3] & [3, 3] (this is last column nodes, mark as 2)
 *     Do DFS as node is marked as 2, as 1's will turn to 2
 *     0 0 0 0
 *     0 2 2 0
 *     0 0 2 2
 *     0 0 0 2
 *
 */

public class Google_Day_WhenAPathExists {
    boolean ans = false;
    int l, m;
    int[][] dp;
    // op = [ [0,0], [2,3] ] meaning on 1st day cell [0][0] became traversable so 1
    // on 2nd day cell[2][3] became 1 (travesable)
    public int findDay(int row, int col, int[][] op){
        l = row; m = col;
        dp = new int[l][m];
        // 0 unvisited
        // 1 visited
        // visited and can reach end from here
        for(int i =0;i<op.length;i++){
            int x = op[i][0];
            int y = op[i][1];

            if(dp[x][y] == 0) dp[x][y] = 1;

            // if any of the 4 neighbour is 2 then we run dfs to update all neighbor to connected 2
            if(dp[x][y] != 2){
                if(x-1 >= 0 && dp[x-1][y] == 2) dfs(x, y);
                if(x+1 < l-1 && dp[x+1][y] == 2) dfs(x, y);
                if(y-1 >= 0 && dp[x][y-1] == 2) dfs(x, y);
                if(y+1 < m-1 && dp[x][y+1] == 2) dfs(x, y);
            }


            if(y == m-1){
                // some node on last col is not traversable so apply dfs to convert all connected 1 to 2
                dfs(x,y);
            }
            if(ans) return i+1;
        }
        return -1;
    }

    private void dfs(int i, int j){
        if(i < 0 || j < 0 || i > l-1 || j > m-1 || dp[i][j] == 0 || dp[i][j] == 2) return;
        dp[i][j] = 2;
        if(i == 0){
            // we have reached 1st col and can now connect last and 1st col
            ans = true;
            return;
        }
        dfs(i-1, j);
        dfs(i+1, j);
        dfs(i , j-1);
        dfs(i, j+1);
    }
}
