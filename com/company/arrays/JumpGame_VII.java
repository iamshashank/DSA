package com.company.arrays;

/**
 * 1871. Jump Game VII
 * Medium
 *
 * You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:
 *
 *     i + minJump <= j <= min(i + maxJump, s.length - 1), and
 *     s[j] == '0'.
 *
 * Return true if you can reach index s.length - 1 in s, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "011010", minJump = 2, maxJump = 3
 * Output: true
 * Explanation:
 * In the first step, move from index 0 to index 3.
 * In the second step, move from index 3 to index 5.
 *
 * Example 2:
 *
 * Input: s = "01101110", minJump = 2, maxJump = 3
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     2 <= s.length <= 105
 *     s[i] is either '0' or '1'.
 *     s[0] == '0'
 *     1 <= minJump <= maxJump < s.length
 */


/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * Please Upvote if you find it helpful
 * The basic idea is that we can reach any '0' from range i + minJump to i + maxJump
 * so for example if we have
 * "0110110"
 * minJump =2 , maxJump=3 we can reach the end because we can reach 2nd index from 0 and the last one from the 2nd index
 *
 * so first we need to loop on the input string
 * we have 3 cases
 *
 *     we have a reachable 0
 *     we have a non-reachable 0
 *     we have a 1
 *
 * if we have a non-reachable 0 or 1 we skip it since we can't reach it anyway
 * however we need to distinguish between reachable and non-reachable 0 so we will mark reachable 0 with r
 */
public class JumpGame_VII {
    public boolean canReach(String s, int minJump, int maxJump) {
        // in this main thing is that from a given index i
        // we can travel to any index which is 0 and
        // is in between range (i+minJump)..(i+maxJump)
        int l = s.length();
        char[] c = s.toCharArray();
        if(c[0] != '0' || c[l-1] != '0') return false;
        c[0] = '#';
        int valueUpdateTill = 0;
        for(int i=0;i<c.length;i++){
            // for every 0 that we can reach from i we will udpate its value to `#` character
            if(c[i] != '#') continue;
            int min = Math.max(i+minJump, valueUpdateTill);
            int max = Math.min(i+maxJump, l-1);
            for(int j = min;j<=max;j++){
                if(c[j] == '0') c[j] = '#';
            }
            valueUpdateTill = max;
        }
        return c[l-1] == '#';
    }
}
