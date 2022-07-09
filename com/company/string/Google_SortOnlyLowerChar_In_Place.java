package com.company.string;

import java.lang.reflect.Array;
import java.util.*;

public class Google_SortOnlyLowerChar_In_Place {
    public String process(String a){
        int[] freq = new int[26];
        PriorityQueue<Character> q  = new PriorityQueue<>((x, y)->{return x.compareTo(y); });
        for(char c : a.toCharArray()) {
            if(Character.isLowerCase(c)) {
                freq[c - 'a']++;
            }
        }
//        System.out.println(Arrays.toString(freq));
        for(int i=0;i<26;i++){
            if(freq[i] > 0) q.add((char)(i+'a'));
        }
//        System.out.println(q);
        String ans = "";
        for(int i=0;i<a.length();i++){
            if(Character.isLowerCase(a.charAt(i))){
                ans += q.peek();

                // decrement freq
                freq[q.peek()-'a']--;
                if(freq[q.peek()-'a'] == 0) q.remove();
            }else{
                ans += a.charAt(i);
            }
        }
        return ans;
    }
}
