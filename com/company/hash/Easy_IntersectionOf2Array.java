package com.company.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Easy_IntersectionOf2Array {
    // TC ->O(len(nums1)+ len(num2)) SC-> O(len(nums1)+ len(num2))
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> ans  = new HashSet<>();

        for(int v : nums1) set1.add(v);
        for(int v : nums2) set2.add(v);

        for(int v : nums1) {
            if(set1.contains(v) && set2.contains(v) && !ans.contains(v)){
                ans.add(v);
            }
        }
        for(int v : nums2) {
            if(set1.contains(v) && set2.contains(v) && !ans.contains(v)){
                ans.add(v);
            }
        }

        int[] a = new int[ans.size()];
        int i =0;
        for(int v : ans) a[i++] = v;
        return a;
    }

    /**
     * FACEBOOK
     * If arrays are sorted do it in TC -> O(n) SC -> O(1)
     */

    public List<Integer> optimised(int[] arr1, int[] arr2){
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while(true){
            if(i > arr1.length-1) break;
            if(j > arr2.length-1) break;

            if(arr1[i]< arr2[j]){
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            }else{
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }

}
