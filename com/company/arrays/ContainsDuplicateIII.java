package com.company.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 * 220. Contains Duplicate III
 * Medium
 *
 * Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 2 * 104
 *     -231 <= nums[i] <= 231 - 1
 *     0 <= k <= 104
 *     0 <= t <= 231 - 1
 *
 */

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] n, int k, int t) {
        int l = n.length;
        // base case as i,j have to be distinct
        if(k==0) return false;

        ArrayList<Pair> a = new ArrayList<>();
        for(int i =0;i<l;i++){
            a.add(new Pair(n[i], i));
        }

        // trick is to sort the array in Nlog(N) so we can avoid break the nested loop if we know solution not possible and avoid O(N^2)
        Collections.sort(a, (p, q)->{
            if(p.v > q.v) return 1;
            if(p.v < q.v) return -1;
            return 0;
        });        Pair p1 = null, p2 = null;
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                // since the array is sorted a[j] - a[i] will always be positive
                p1 = a.get(i);
                p2 = a.get(j);
                if(p2.v-p1.v > t) break; // we wont find answer int this loop as array is sorted and diff will grow
                // if we reached here that means out 1st condition is ok
                if(Math.abs(p2.idx-p1.idx) <= k) return true;
            }
        }

        return false;
    }

    class Pair{
        long v;
        int idx;
        Pair(int v, int i){
            this.v = v;
            this.idx = i;
        }
    }
}
