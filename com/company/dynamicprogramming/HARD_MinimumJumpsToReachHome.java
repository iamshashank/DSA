package com.company.dynamicprogramming;

import java.util.HashSet;

/**
 *
 * 1654. Minimum Jumps to Reach Home
 * Medium
 *
 * A certain bug's home is on the x-axis at position x. Help them get there from position 0.
 *
 * The bug jumps according to the following rules:
 *
 *     It can jump exactly a positions forward (to the right).
 *     It can jump exactly b positions backward (to the left).
 *     It cannot jump backward twice in a row.
 *     It cannot jump to any forbidden positions.
 *
 * The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
 *
 * Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * Output: 3
 * Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
 *
 * Example 2:
 *
 * Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * Output: -1
 *
 * Example 3:
 *
 * Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * Output: 2
 * Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.
 *
 *
 *
 * Constraints:
 *
 *     1 <= forbidden.length <= 1000
 *     1 <= a, b, forbidden[i] <= 2000
 *     0 <= x <= 2000
 *     All the elements in forbidden are distinct.
 *     Position x is not forbidden.
 *
 */

public class HARD_MinimumJumpsToReachHome {
    int max = Integer.MAX_VALUE - 5000;
    int[][] dp;
    HashSet<Integer> forb;
    int X;
    public int minimumJumps(int[] f, int a, int b, int x) {
        forb = new HashSet<>();
        X = x;
        for(int i=0;i<f.length;i++) forb.add(f[i]);
        dp = new int[6500][2]; // reasonably large dp array
        int ans = jump(a,b,0,0);
        if(ans >= max){
            ans = -1;
        }
        return ans;
    }

    public int jump(int a, int b, int pos, int lastActionWasBackJump){
        if(pos == X){
            return 0; // found the answer
        }
        // no solution in these cases
        if(forb.contains(pos) || pos >= 6500 || pos < 0){
            return max;
        }
        if(dp[pos][lastActionWasBackJump] != 0) return dp[pos][lastActionWasBackJump];
        // jump forward
        dp[pos][lastActionWasBackJump]  = 1 + jump(a,b,pos+a, 0); // if we jumping forward then for the next fucntion call lastActionWasJump will be 0
        if(lastActionWasBackJump == 0){
            // if last time the it was not backward jump
            dp[pos][lastActionWasBackJump]  = Math.min(dp[pos][lastActionWasBackJump], 1 + jump(a,b,pos-b, 1));
        }
        return dp[pos][lastActionWasBackJump];
    }

    /**
     *
     * // Here We are Using BFS Since every time there can be neighbours
     * // at evry step (consider neighbours here as moving forward and backward position (if possible)).
     * // So here we apply simple bfs traversal.
     * // We are keeping track of backward movement by queue second value i.e. -1
     * // here since here no consecutive backward movement is allowed.
     * // Map is used so that if we some point again then simply return because that point is already under process in queue (it just like visited array in out normal dfs/bfs).
     * class Solution {
     * public:
     *     int minimumJumps(vector<int>&nums, int a, int b, int x) {
     *         queue<pair<int,int>>q;
     *         map<int,bool>seen;
     *         for(int i = 0 ; i < nums.size() ; i++)
     *         {
     *             seen[nums[i]] = true;
     *         }
     *         q.push({0,-1});
     *         int lvl = -1;
     *         while(!q.empty())
     *         {
     *             lvl++;
     *             int sz = q.size();
     *             while(sz--)
     *             {
     *                 int node = q.front().first;
     *                 int val = q.front().second;
     *                 q.pop();
     *                 if(node==x)
     *                 {
     *                     return lvl;
     *                 }
     *                 if(seen[node])
     *                 {
     *                     continue;
     *                 }
     *                 seen[node] = true;
     *                 if(val==-1)
     *                 {
     *                     int k = a+node;
     *                     if(node<=2000+b)
     *                     {
     *                       q.push({k,0});
     *                     }
     *                 }
     *                 else if(val==0)
     *                 {
     *                     int k1 = a + node;
     *                     int k2 = node - b;
     *                     if(k2>=0)
     *                     {
     *                        q.push({k2,-1});
     *                     }
     *                     if(node<=2000+b)
     *                     {
     *                        q.push({k1,0});
     *                     }
     *                 }
     *             }
     *         }
     *         return -1;
     *     }
     * };
     *
     */


}
