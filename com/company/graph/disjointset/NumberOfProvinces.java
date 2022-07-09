package com.company.graph.disjointset;

import java.util.HashSet;
import java.util.Set;

/**
 * 547. Number of Provinces
 * Medium
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 * Example 2:
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 200
 *     n == isConnected.length
 *     n == isConnected[i].length
 *     isConnected[i][j] is 1 or 0.
 *     isConnected[i][i] == 1
 *     isConnected[i][j] == isConnected[j][i]
 *
 */

public class NumberOfProvinces {
    public int findCircleNum(int[][] c) {
        int l = c.length;
        int[] g = new int[l];
        // initially there are `;` groups and parent of each group is themselves
        for(int i=0;i<l;i++) g[i] = i;
        for(int i=0;i<l;i++){
            for(int j = 0;j<l;j++){
                if(c[i][j] == 1){
                    int t = Math.min(g[i], g[j]);
                    setParent(g, g[i], g[j], t);
                }
            }
        }

        // System.out.println(Arrays.toString(g));

        Set<Integer> s = new HashSet<>();

        for(int i=0;i<l;i++) s.add(g[i]);
        return s.size();
    }

    public void setParent(int[] g, int p1, int p2, int newP){
        for(int i=0;i<g.length;i++){
            if(g[i] == p1 || g[i] == p2) g[i] = newP;
        }
    }


    /**
     * Using union find and path compression
     *
     */
    int[] parent;
    int[] rank;
    public int findCircleNum2(int[][] c) {
        int l = c.length;
        parent = new int[l];
        rank = new int[l];
        // initially there are `;` groups and parent of each group is themselves
        // and rank will be 0 for each
        for(int i=0;i<l;i++) parent[i] = i;

        for(int i=0;i<l;i++){
            for(int j = 0;j<l;j++){
                if(c[i][j] == 1){
                    union(i,j);
                }
            }
        }
        // path compression is necessary
        for(int i=0;i<l;i++){
            int p = getParent(i);
            parent[i] = p;
        }

        Set<Integer> s = new HashSet<>();
        for(int i=0;i<l;i++) s.add(parent[i]);
        return s.size();
    }

    int getParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = getParent(parent[node]);
    }

    void union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(rank[b] > rank[a]){
            parent[a] = b;
            rank[b] += 1;
        }else{
            parent[b] = a;
            rank[a] += 1;
        }
    }

}
