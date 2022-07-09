package com.company.hash;

import java.util.HashMap;

public class Google_TimeToTypeAString {
    public int timeTaken(String keyboard, String text){
        HashMap<Character, Integer> k = new HashMap<>();
        for(int i=0;i<keyboard.length();i++){
            k.put(keyboard.charAt(i), i);
        }
        int ans = 0;
        char prevChar = keyboard.charAt(0); // intially keybora is at 1st char of keyborad
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            if(i != 0)
                prevChar = text.charAt(i-1);
            ans += Math.abs(k.get(c)-k.get(prevChar));
        }
        return ans;
    }
}
