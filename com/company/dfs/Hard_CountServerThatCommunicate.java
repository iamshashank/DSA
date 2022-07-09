package com.company.dfs;

/**
 * 1267. Count Servers that Communicate
 * Medium
 *
 * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
 *
 * Return the number of servers that communicate with any other server.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 0
 * Explanation: No servers can communicate with others.
 *
 * Example 2:
 *
 * Input: grid = [[1,0],[1,1]]
 * Output: 3
 * Explanation: All three servers can communicate with at least one other server.
 *
 * Example 3:
 *
 * Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * Output: 4
 * Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
 *
 *
 *
 * Constraints:
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m <= 250
 *     1 <= n <= 250
 *     grid[i][j] == 0 or 1
 */

public class Hard_CountServerThatCommunicate {
    int tCount = 0, ans = 0, l,m;
    int[][] v, g;
    public int countServers(int[][] grid) {
        g = grid;
        l = grid.length;
        m = grid[0].length;
        v = new int[l][m];
        for(int i=0;i<l;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && v[i][j] == 0){
                    dfs(i,j, 0);
                    if(tCount > 1) ans += tCount;
                    tCount = 0;
                }
            }
        }
        return ans;
    }

    // 0 is right, 1 is down direction
    void dfs(int x, int y, int direction){
        if(x > l-1 || y > m-1 || x <0 || y < 0) return;
        if(v[x][y] == 1) return;
        if(g[x][y] == 1){
            tCount++;
            v[x][y] = 1;
            // from here we can go right or down
            dfs(x, y+1, 0); // right
            dfs(x, y-1, 1); // left
            dfs(x+1, y, 2); // down
            dfs(x-1, y, 3); // top
        }else{
            // continue onsame direction
            if(direction == 0) dfs(x, y+1, direction); // continue right
            if(direction == 1) dfs(x, y-1, direction); // continue right
            if(direction == 2) dfs(x+1, y, direction); // continue down
            if(direction == 3) dfs(x-1, y, direction); // continue down
        }
    }
}
