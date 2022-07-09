package com.company.dbs_bfs_combined;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/
 *
 * 2146. K Highest Ranked Items Within a Price Range
 * Medium
 *
 * You are given a 0-indexed 2D integer array grid of size m x n that represents a map of the items in a shop. The integers in the grid represent the following:
 *
 *     0 represents a wall that you cannot pass through.
 *     1 represents an empty cell that you can freely move to and from.
 *     All other positive integers represent the price of an item in that cell. You may also freely move to and from these item cells.
 *
 * It takes 1 step to travel between adjacent grid cells.
 *
 * You are also given integer arrays pricing and start where pricing = [low, high] and start = [row, col] indicates that you start at the position (row, col) and are interested only in items with a price in the range of [low, high] (inclusive). You are further given an integer k.
 *
 * You are interested in the positions of the k highest-ranked items whose prices are within the given price range. The rank is determined by the first of these criteria that is different:
 *
 *     Distance, defined as the length of the shortest path from the start (shorter distance has a higher rank).
 *     Price (lower price has a higher rank, but it must be in the price range).
 *     The row number (smaller row number has a higher rank).
 *     The column number (smaller column number has a higher rank).
 *
 * Return the k highest-ranked items within the price range sorted by their rank (highest to lowest). If there are fewer than k reachable items within the price range, return all of them.
 *
 *
 */

public class K_HighestRankedItemByPrice {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        if(k==0) return new ArrayList<>();
        if(grid[start[0]][start[1]] == 0) return new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        Queue<Item> q = new LinkedList<>();
        // push start in queue
        // if its a empty space (a[i] == 1) then add price as -1 so later we can ignore it
        q.add(new Item(start[0], start[1], (grid[start[0]][start[1]] == 1) ? -1 : grid[start[0]][start[1]], 0 ));
        grid[start[0]][start[1]] = -1; // mark visited
        List<Item> list = new ArrayList<>();
        
        int dis = 1;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        while(q.size() > 0){
            int l = q.size();
            for(int v =0;v<l;v++){
                Item g = q.remove();
                list.add(g);
                for(int i = 0; i< 4;i++ ){
                    int ix = g.i + dx[i];
                    int jy = g.j + dy[i];
                    if(ix >= 0 && jy >= 0 && ix < row && jy < col && grid[ix][jy] != 0 && grid[ix][jy] != -1){
                        // if not 0 or 2 that means its not a wall or its not visited
                        q.add(new Item(ix, jy, (grid[ix][jy] == 1) ? -1 : grid[ix][jy], dis));
                        grid[ix][jy] = -1; // mark visited
                    }
                }
            }
            dis++;
        }

        // END BFS
        // now remove Items from list which are not actual items remove items where p = -1
        list = list.stream().filter((a)->{ return (a.p != -1 && (a.p >= pricing[0] && a.p <= pricing[1]) ); }).sorted((a,b)->{
            if(a.d != b.d)
                return a.d - b.d;
            if(a.p != b.p)
                return a.p - b.p;
            if(a.i != b.i)
                return a.i - b.i;
            if(a.j != b.j)
                return a.j - b.j;
            return 0;
        }).collect(Collectors.toList());

        List<List<Integer>> res = new ArrayList<>();
        for(int i =0;i< k;i++){
            List<Integer> tt = new ArrayList<>();
            if(i < list.size()){
                tt.add(list.get(i).i);
                tt.add(list.get(i).j);
                res.add(tt);
            }
        }
        return res;
    }

    class Item{
        int i,j,p,d;
        Item(int i, int j, int p, int d){
            this.i = i;
            this.j = j;
            this.p = p;
            this.d = d;
        }
    }
}