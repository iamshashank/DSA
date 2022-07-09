package com.company.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountNodeWithHighestScore {
    public int countHighestScoreNodes(int[] p) {
        int l = p.length;
        long[] t_ans = new long[l];
        long max = 0;
        // count matrix
        //at each index i a[i][0] will tell count of nodes in left sub-tree
        //at each index i a[i][1] will tell count of nodes in right sub-tree
        long[][] count = new long[l][2];

        // Adjacecny matrix
        List<Integer>[] a = new List[l];
        for(int i =0;i<l;i++)
            a[i] = new ArrayList<>();
        for(int i =0;i<l;i++){
            int node = i;
            int parent = p[i];
            if(parent != -1){
                if(a[parent] == null){
                    a[parent] = new ArrayList<>();
                }
                a[parent].add(i);
            }
        }

        // DFS to count num-of-nodes at each node
        dfs(a, count, 0);

//        for(int i=0;i<l;i++){
//            if(a[i]!=null) System.out.println(Arrays.toString(a[i].toArray()));
//        }
//        System.out.println("_____");
//        for(int i=0;i<l;i++)
//            System.out.println(Arrays.toString(count[i]));

        for(int i=0;i<l;i++){
            if(p[i] == -1){
                // root node
                t_ans[i] = (count[i][0] == 0 ? 1 : count[i][0]) * (count[i][1] == 0 ? 1 : count[i][1]);
            }else if(a[i].size() == 0){
                // leaf node
                t_ans[i] = l - 1;
            }else{
                // element in the middle somewhere which will divide tree into 3 parts
                long rr = l - count[i][0] - count[i][1] - 1;
                t_ans[i] = ( rr == 0 ? 1 : rr) * (count[i][0] == 0 ? 1 : count[i][0]) * (count[i][1] == 0 ? 1 : count[i][1]);
            }
            max = Math.max(max, t_ans[i]);
        }
        int res = 0;
//        System.out.println(Arrays.toString(t_ans));
        for(int i =0;i<l;i++){
            if(t_ans[i] == max)
                res++;
        }
        return res;
    }

    private int dfs(List<Integer>[] a, long[][] count, int root) {
        if(a[root] == null || a[root].size() == 0) return 1;
        int left = 0, right = 0;
        if(a[root].size() == 2){
            left = dfs(a, count, a[root].get(0));
            right = dfs(a, count, a[root].get(1));
        }else{
            left = dfs(a, count, a[root].get(0));
        }
        count[root][0] = left;
        count[root][1] = right;
        return left + right + 1;
    }
}