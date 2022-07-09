package com.company.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an input string in the format String s = "abc{d,e}f{gh,ij}".
 * Expected output: [abcdfgh, abcdfij, abcefgh, abcefij]
 * This is exact output of echo abc{d,e}f{gh,ij} on a bash terminal. Braces can be nested.
 */

public class Google_BraceExpansion {
    public String[] process(String s){
        // base condition
        if(s.length() == 0) return new String[]{""};
        if(s.length() == 1) return new String[]{s};

        List<String> res = new ArrayList<>();
        if(s.charAt(0) == '{'){
            int i = 0;
            while(s.charAt(i) != '}') i++;

            // these are all the options which will act as prefix
            String[] left = s.substring(1, i).split(",");
            // all the suffixes
            String[] right = process(s.substring(i+1)); // DFS
            for(String prefix : left){
                for(String suffix : right){
                    res.add(prefix+suffix);
                }
            }
        }else{
            String left = s.substring(0, 1);
            String[] right = process(s.substring(1));
            for(String suffix : right) {
                res.add(left + suffix);
            }
        }

        Collections.sort(res);
        return res.toArray(new String[0]);
    }
}
