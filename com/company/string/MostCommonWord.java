package com.company.string;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>();
        HashSet<Character> invaldSym = new HashSet<>();
        invaldSym.add('!');
        invaldSym.add('?');
        invaldSym.add('\'');
        invaldSym.add(',');
        invaldSym.add(';');
        invaldSym.add('.');
        int maxTillNow = Integer.MIN_VALUE;
        String ans = null;
        for(int i=0;i<banned.length;i++) ban.add(banned[i].toLowerCase());
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = paragraph.split(" ");
        for(String w : arr){
            w = w.toLowerCase();
            int  i = w.length();
            while(i >= 0){
                if(Character.isLetter(w.charAt(i)))
                    break;
                else
                    i--;
            }
            w = w.substring(0,i+1);
            if(!ban.contains(w)){
                int v = map.getOrDefault(w, 0);
                map.put(w, v+1);
                if(v+1 > maxTillNow){
                    maxTillNow = v+1;
                    ans = w;
                }
            }
        }
        return ans;
    }
}
