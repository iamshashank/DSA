package com.company.bellmanford;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 * Medium
 *
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 *
 * Example 2:
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
 *
 * Example 3:
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph is shown above.
 * The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 */


/**
 * WE run BFS K+1 times
 */
public class CheapestFlightWith_K_Stops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());
        for(int[] f : flights){
            adj.get(f[0]).add(new Pair(f[1], f[2]));
        }

        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int stops = 0;

        while(!q.isEmpty()){
            int l = q.size();
            if(stops == k+1) break;

            // one thing to note here for the level which is currenlty being processed
            // we dont want them to update the data we got in last run during intermediate processing
            int[] tdp = dp.clone();
            for(int i =0;i<l;i++){
                int from = q.remove();
                for(Pair t : adj.get(from)){
                    // new price is calculated from price foound in the last run `dp`
                    // dont use `tdp` for calculating price
                    tdp[t.to] = Math.min(tdp[t.to], dp[from]+t.price);
                    if(dp[from]+t.price <= tdp[t.to]){
                        q.add(t.to);
                    }

                }
            }
            for(int i=0;i<n;i++) dp[i] = tdp[i];
            stops++;
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }

    private class Pair{
        int to, price;
        Pair(int i, int j){
            this.to = i;
            this.price = j;
        }
    }
}
