package com.company.dbs_bfs_combined;

import java.util.*;

public class SumOfTreeDistances {
    List<Integer>[] adj;
    Queue<Integer> q;
    int[] visited;

    public int[] optimised(int n, int[][] e){
        adj = new List[n];
        visited = new int[n];
        int[] ans = new int[n];
        int[] d = new int[n];
        int[] c = new int[n];

        for(int i =0; i<n;i++){
            adj[i] = new ArrayList<>();
        }
        // build adjacency matrix directional
        for(int i = 0; i < e.length; i++){
            adj[e[i][0]].add(e[i][1]);
            adj[e[i][1]].add(e[i][0]);
        }

        c[0] = dfs(0,d,c,0);
        // we do dfs once and now we loop once to find ans for a[0] and for rest we will mathamatically find the answers
        for(int i =0;i<n;i++){
            ans[0] += d[i];
        }
        // find answers for rest in O(N) time
        dfs2(0, d,c,ans, n, -1);
        return ans;
    }

    // d[] stores the depth of each node
    // c[i] stores number of nodes under the sub-tree starting at `i` so (itself + count(all children)) or (1 + count(all children))
    // after getting count of left nodes we can do (N -c[i]) to get number of nodes on right
    // ans[i] = ans[0] - c[i] + (N-c[i])
    public int dfs(int node, int[] d, int[] c, int depth){
        visited[node] = 1;
        d[node] = depth;
        int count = 1;
        for(int i =0;i<adj[node].size();i++){
            if(visited[adj[node].get(i)] == 1) continue;
            int t = dfs(adj[node].get(i), d, c, depth+1);
            c[adj[node].get(i)] = t;
            count += t;
        }
        return count;
    }

    public void dfs2(int node, int[] d, int[] c, int[] ans, int N, int parent){
        for(int i = 0;i<adj[node].size();i++){
            if(adj[node].get(i) == parent) continue;
            // this has to be recursive because the formula is only valid when we a child becomes root
            // so we need to make recursively 1 by 1 make each child as root and find ans[child]
            // there is no direct math logic to get the ans
            ans[adj[node].get(i)] = ans[node] - c[adj[node].get(i)] + (N - c[adj[node].get(i)]);
            dfs2(adj[node].get(i), d,c ,ans,N, node);
        }
    }



    // old brute force logic
    public int[] bruteforce(int n, int[][] e) {
        adj = new List[n];
        visited = new int[n];

        for(int i =0; i<n;i++){
            adj[i] = new ArrayList<>();
        }

        q = new LinkedList<>();
        // build adjacancy matrix
        for(int i = 0; i < e.length; i++){
            adj[e[i][0]].add(e[i][1]);
            adj[e[i][1]].add(e[i][0]); // add connection both ways so we can traverse up or down
        }

        // at the bruteforce level we need to run bfs at each node and count levels for each new node
        // but we can memoize the sub-problems
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            q.clear();
            int[] d = new int[n]; // this will store depth of each node from root i
            bfs(i, d);
            for(int j=0;j<n;j++){
                ans[i] += d[j];
            }
            Arrays.fill(visited, 0);
        }

        return ans;
    }

    public void bfs(int node, int[] d){
        int k = 1;
        d[node] = 0;
        q.add(node);
        visited[node] = 1;
        while(q.size()>0){
            int len = q.size();
            for(int i = 0; i< len ;i++){
                int curr = q.remove();
                for(int j = 0; j< adj[curr].size();j++){
                    if(visited[adj[curr].get(j)] == 0){
                        d[adj[curr].get(j)] = k;
                        q.add(adj[curr].get(j));
                        visited[adj[curr].get(j)] = 1;
                    }
                }
            }
            k++; // increase depth
        }
    }

}
