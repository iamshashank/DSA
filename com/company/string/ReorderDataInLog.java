package com.company.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * 937. Reorder Data in Log Files
 * Easy
 *
 * You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
 *
 * There are two types of logs:
 *
 *     Letter-logs: All words (except the identifier) consist of lowercase English letters.
 *     Digit-logs: All words (except the identifier) consist of digits.
 *
 * Reorder these logs so that:
 *
 *     The letter-logs come before all digit-logs.
 *     The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
 *     The digit-logs maintain their relative ordering.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * Explanation:
 * The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
 * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 *
 * Example 2:
 *
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 */

public class ReorderDataInLog {
    public String[] reorderLogFiles(String[] logs) {
        int l = logs.length;
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<l;i++){
            String c = logs[i];
            int t = c.indexOf(' ');
            System.out.println('z' - c.charAt(t));
            if('z' - c.charAt(t+1) >= 0 && 'z' - c.charAt(t+1) <= 25 ){
                a.add(c);
            }else{
                b.add(c);
            }
            map.put(c, t);
        }
        Collections.sort(a, (x,y)->{
            int i = map.get(x)+1;
            int j = map.get(y)+1;
            int diff = x.substring(i).compareTo(y.substring(j));
            if(diff == 0){
                return x.substring(0,i-1).compareTo(y.substring(0,j-1));
            }
            return diff;
        });

        for(int i =0;i<l;i++){
            if(i<a.size()){
                logs[i] = a.get(i);
            }else{
                logs[i] = b.get(i-a.size());
            }
        }
        new ArrayList<String>().remove("abc");
        return logs;
    }
}
