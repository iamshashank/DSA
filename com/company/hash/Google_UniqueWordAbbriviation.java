package com.company.hash;

import java.util.HashSet;

public class Google_UniqueWordAbbriviation {
    HashSet<String> dict;
    public void process(String[] a){
        dict = new HashSet<>();
        for(String w: a){
            if(w.length() <= 2){
                dict.add(w);
            }else{
                dict.add(w.charAt(0)+""+(w.length()-2)+""+w.charAt(w.length()-1));
            }
        }
    }

    public boolean checkIfUniqueAbb(String w){
        if(w.length() <= 2) return !dict.contains(w);
        return !dict.contains(w.charAt(0)+""+(w.length()-2)+""+w.charAt(w.length()-1));
    }
}
