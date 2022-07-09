package com.company;

import java.util.ArrayList;

public class Google_EncodeDecodeString {
    public String encode(String[] a){
        String ans = "";
        for(String s : a){
            int l = s.length();
            ans += (l + "/" + s);
        }
        return ans;
    }

    public String[] decode(String a){
        ArrayList<String> x = new ArrayList<>();
        int i =0;
        while(i<a.length()){
            int indexOfDelimiter = a.indexOf("/", i);
            int l = Integer.parseInt(a.substring(i, indexOfDelimiter));
            int start = indexOfDelimiter+1;

            x.add(a.substring(start, start+l));
            i = start + l;
        }
        String[] ans = new String[x.size()];
        for(int g =0;g<x.size();g++){
            ans[g] = x.get(g);
        }
        return ans;
    }
}
