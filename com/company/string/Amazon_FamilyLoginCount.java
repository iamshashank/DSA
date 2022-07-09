package com.company.string;

import java.util.HashMap;
import java.util.List;

/**
 * Q1. Given a list of strings, count number of pairs of strings where one string is increment of another. For eg 'abc', 'bcd'. Each character of 'abc' when incremented gives 'bcd'.
 * Edit : it is a list of strings. Ex logins : ["bag","cbh","sfe", "red","cbh"]. In this case there are 3 such pairs
 * at indices (0,1), (0,4,), (3,2). This should return 3
 */

public class Amazon_FamilyLoginCount {
    public int countFamilyLogins(String[] logins)
    {
        int Ret = 0;
        //Record the previous conversion of scanned items
        HashMap<String, Integer> dLoginsPrev = new HashMap<>();
        //Record the next conversion of scanned items
        HashMap<String, Integer> dLoginsNext = new HashMap<>();


        for(int i = 0;i < logins.length; i++) {
            String w = logins[i];
            //Not sure if there are multiple duplicated items, so using value as count
            //check if current item could be the next item of scanned items.
            if(dLoginsPrev.containsKey(w)) {
                Ret += dLoginsPrev.get(w);
            }
            //Not sure if there are multiple duplicated items, so using value as count
            //check if current item could be the previous item of scanned items.
            if(dLoginsNext.containsKey(w)) {
                Ret += dLoginsNext.get(w);
            }

            StringBuilder sbloginPrev = new StringBuilder(w);
            StringBuilder sbloginNext = new StringBuilder(w);

            for(int j = 0; j < sbloginPrev.length(); j++) {
                sbloginPrev.setCharAt(j, (char)(((sbloginPrev.charAt(j) - 'a' - 1 + 26) % 26) + 'a'));
            }
            for(int j = 0; j < sbloginNext.length(); j++) {
                sbloginNext.setCharAt(j, (char)(((sbloginNext.charAt(j) - 'a' + 1) % 26) + 'a'));
            }
            System.out.println(w + "<P>" + sbloginPrev);
            System.out.println(w + "<N>" + sbloginNext);
            //Record the prevsion conversion to scanned dictionary
            if(dLoginsPrev.containsKey(sbloginPrev.toString())) {
                int t = dLoginsPrev.getOrDefault(sbloginPrev.toString(), 0);
                dLoginsPrev.put(sbloginPrev.toString(), t+1);
            } else {
                dLoginsPrev.put(sbloginPrev.toString(), 1);
            }

            //Record the next conversion to scanned dictionary
            if(dLoginsNext.containsKey(sbloginNext.toString())) {
                int t = dLoginsNext.getOrDefault(sbloginNext.toString(), 0);
                dLoginsNext.put(sbloginNext.toString(), t+1);
            } else {
                dLoginsNext.put(sbloginNext.toString(), 1);
            }

        }

        return Ret;
    }

    public int countLogins(String[] logins){
        HashMap<String, Integer> cmap = new HashMap<>();
        for(int i=0;i<logins.length;i++){
            String w = logins[i];
            int t = cmap.getOrDefault(w, 0);
            cmap.put(w, t+1);
        }
        // now count how many family login pairs exists
        int ans = 0;
        for(String w : logins){
            // since we are checking for `w` reduce 1 from cmap so we dont count itself
            String r = rotate(w);
            ans += cmap.getOrDefault(r, 0);
        }
        return ans;
    }

    String rotate(String s){
        String ans = "";
        for(int i=0;i<s.length();i++){
            ans += (char)(((s.charAt(i) - 'a' + 1) %26) + 'a');
        }
        return ans;
    }
}
