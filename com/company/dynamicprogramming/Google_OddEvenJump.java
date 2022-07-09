package com.company.dynamicprogramming;

import java.util.TreeMap;

/**
 * 975. Odd Even Jump
 * Hard
 *
 * You are given an integer array arr. From some starting index, you can make a series of jumps. The (1st, 3rd, 5th, ...) jumps in the series are called odd-numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the series are called even-numbered jumps. Note that the jumps are numbered, not the indices.
 *
 * You may jump forward from index i to index j (with i < j) in the following way:
 *
 *     During odd-numbered jumps (i.e., jumps 1, 3, 5, ...), you jump to the index j such that arr[i] <= arr[j] and arr[j] is the smallest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
 *     During even-numbered jumps (i.e., jumps 2, 4, 6, ...), you jump to the index j such that arr[i] >= arr[j] and arr[j] is the largest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
 *     It may be the case that for some index i, there are no legal jumps.
 *
 * A starting index is good if, starting from that index, you can reach the end of the array (index arr.length - 1) by jumping some number of times (possibly 0 or more than once).
 *
 * Return the number of good starting indices.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [10,13,12,14,15]
 * Output: 2
 * Explanation:
 * From starting index i = 0, we can make our 1st jump to i = 2 (since arr[2] is the smallest among arr[1], arr[2], arr[3], arr[4] that is greater or equal to arr[0]), then we cannot jump any more.
 * From starting index i = 1 and i = 2, we can make our 1st jump to i = 3, then we cannot jump any more.
 * From starting index i = 3, we can make our 1st jump to i = 4, so we have reached the end.
 * From starting index i = 4, we have reached the end already.
 * In total, there are 2 different starting indices i = 3 and i = 4, where we can reach the end with some number of
 * jumps.
 */
public class Google_OddEvenJump {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int ans = 1;
        // here Pair will act has memoization/DP
        TreeMap<Integer, Pair> map = new TreeMap<>();
        // the last index will always be a good spot (odd+even jumps) because we can always reach end from there
        map.put(arr[n-1], new Pair(true, true));
        //  we loop from right to left and count
        for(int i = n-2;i>=0;i--){
            // now we need to check that from arr[i] can make odd jump
            Integer oddKey = map.ceilingKey(arr[i]); // key greater or equal that arr[i]
            // for even jump from arr[i]
            Integer evenKey = map.floorKey(arr[i]); // key greater or equal that arr[i]

            boolean oddJump = false, evenJump = false;
            if(oddKey != null){
                Pair o = map.get(oddKey);
                // so we made a odd jump from arr[i] and to check if this was a good jump
                // meaning will this eventually take us to end index for this we will use DP/memoizatoion
                // since next jump will be even we will check our DP
                oddJump = o.even;
            }
            if(evenKey != null){
                Pair o = map.get(evenKey);
                // so we made a even jump from arr[i] and to check if this was a good jump
                // meaning will this eventually take us to end index for this we will use DP/memoizatoion
                // since next jump will be odd we will check our DP
                evenJump = o.odd;
            }

            // a index is good if we start from this index and can reach the end
            // since the 1st jump is odd we look at oddJump to see if its possible or not
            if(oddJump) ans++;
            map.put(arr[i], new Pair(evenJump, oddJump));
        }
        return ans;
    }

    private class Pair{
        // here even/odd store that from this position if we made a odd or even numbered jump will we reach end or not
        boolean even = false, odd = false;
        Pair(){}
        Pair(boolean e, boolean o){
            this.even = e;
            this.odd = o;
        }
    }
}
