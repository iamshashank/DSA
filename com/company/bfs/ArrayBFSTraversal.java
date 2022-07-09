package com.company.bfs;

import java.util.*;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 *
 * 1424. Diagonal Traverse II
 * Medium
 *
 * Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 *
 * Example 2:
 *
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *
 */


public class ArrayBFSTraversal {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        ArrayList<Integer> ans = new ArrayList<>();
//        boolean[][] vis = new boolean[100000][100000];
        List<Integer[]> vis = new ArrayList<>();
        for(List<Integer> row : nums ){
            vis.add(new Integer[row.size()]);
        }

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0,0});
        vis.get(0)[0] = 1;
        while(!q.isEmpty()){
            Integer[] curr = q.remove();
            ans.add(nums.get(curr[0]).get(curr[1]));
            // bottom
            if(isValid(nums, vis, curr[0]+1,curr[1])){
                q.add(new Integer[]{curr[0]+1, curr[1]});
                vis.get(curr[0]+1)[curr[1]] = 1;
            }
            // right
            if(isValid(nums, vis, curr[0], curr[1]+1)){
                q.add(new Integer[]{curr[0], curr[1]+1});
                vis.get(curr[0])[curr[1]+1] = 1;
            }
        }
        int[] a = new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            a[i] = ans.get(i);
        }
        return a;
    }

    public boolean isValid(List<List<Integer>> nums, List<Integer[]> vis, int i , int j){
        if(i < nums.size() && j < nums.get(i).size() && vis.get(i)[j] == null){
            return true;
        }
        return false;
    }
}
