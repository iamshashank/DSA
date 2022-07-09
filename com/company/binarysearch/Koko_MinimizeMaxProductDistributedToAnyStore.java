package com.company.binarysearch;

/**
 * 2064. Minimized Maximum of Products Distributed to Any Store
 * Medium
 *
 * You are given an integer n indicating there are n specialty retail stores. There are m product types of varying amounts, which are given as a 0-indexed integer array quantities, where quantities[i] represents the number of products of the ith product type.
 *
 * You need to distribute all products to the retail stores following these rules:
 *
 *     A store can only be given at most one product type but can be given any amount of it.
 *     After distribution, each store will have been given some number of products (possibly 0). Let x represent the maximum number of products given to any store. You want x to be as small as possible, i.e., you want to minimize the maximum number of products that are given to any store.
 *
 * Return the minimum possible x.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6, quantities = [11,6]
 * Output: 3
 * Explanation: One optimal way is:
 * - The 11 products of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3
 * - The 6 products of type 1 are distributed to the other two stores in these amounts: 3, 3
 * The maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.
 *
 * Example 2:
 *
 * Input: n = 7, quantities = [15,10,10]
 * Output: 5
 * Explanation: One optimal way is:
 * - The 15 products of type 0 are distributed to the first three stores in these amounts: 5, 5, 5
 * - The 10 products of type 1 are distributed to the next two stores in these amounts: 5, 5
 * - The 10 products of type 2 are distributed to the last two stores in these amounts: 5, 5
 * The maximum number of products given to any store is max(5, 5, 5, 5, 5, 5, 5) = 5.
 *
 * Example 3:
 *
 * Input: n = 1, quantities = [100000]
 * Output: 100000
 * Explanation: The only optimal way is:
 * - The 100000 products of type 0 are distributed to the only store.
 * The maximum number of products given to any store is max(100000) = 100000.
 */

public class Koko_MinimizeMaxProductDistributedToAnyStore {
    public int minimizedMaximum(int n, int[] q) {
        // this is exact same 875. Koko Eating Bananas
        int l = q.length;
        if(n < l) return -1; //solution not possible
        int max = 0, sum = 0;
        for(int i =0;i<l;i++){
            max = Math.max(max, q[i]);
            sum += q[i];
        }
        // if n == l then each store gets all the items of a particulat type so
        // whatever is the max quanity of any type of item is the answer
        if(n == l) return max;

        // n > l so more than 1 store can get similar type of item
        int low = 1;
        int high = max;
        while(low < high){ //we are using l<h so that we dont exceed h when doing mid+1
            int mid = (low+high)/2;
            if(distributionPossible(q, mid, n)){
                // lets try with samller
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return high;
    }

    boolean distributionPossible(int[] q, int x, int n){
        int storesWhoReceivedTheItem = 0;
        for(int i=0;i<q.length;i++){
            storesWhoReceivedTheItem += (int) Math.ceil((double)q[i]/x);
        }
        return storesWhoReceivedTheItem <= n;
    }
}
