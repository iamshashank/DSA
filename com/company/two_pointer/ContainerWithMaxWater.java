package com.company.two_pointer;

/**
 *
 * 11. Container With Most Water
 * Medium
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 */

public class ContainerWithMaxWater {
    public int maxArea(int[] h) {
        // 2 pointer approch
        int l = 0, r = h.length-1;

        int ans = 0;
        while(l<r){
            int area = Math.min(h[l], h[r]) * (r-l);
            ans = Math.max(ans,area);
            if(h[l] > h[r]){
                r--;
            }else{
                l++;
            }
        }
        return ans;
    }
}
