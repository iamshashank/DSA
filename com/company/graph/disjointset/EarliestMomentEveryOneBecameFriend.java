package com.company.graph.disjointset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EarliestMomentEveryOneBecameFriend {
    int[] parent;
    int[] rank;
    int timestamp = -1;

    public int findMoment(int[][] m, int n){
        int l = m.length;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i=0;i<l;i++){
            union(m[i][1], m[i][2], m[i][0]);
//            System.out.println(Arrays.toString(parent));
        }
        // compression
        Set<Integer> s = new HashSet<>();
        for(int i =0;i<n;i++) {
            parent[i] = getParent(i);
            s.add(parent[i]);
        }
        if(s.size() == 1) return timestamp;
        return -1;
    }

    int getParent(int node){
        if(node == parent[node]) return node;
        return parent[node] = getParent(parent[node]);
    }

    void union(int a, int b, int ts){
        a = getParent(a);
        b = getParent(b);
        if(a != b) timestamp = ts;
        if(rank[b] > rank[a]){
            parent[a] = b;
            rank[b]++;
        }else{
            parent[b] = a;
            rank[a]++;
        }

    }
}
