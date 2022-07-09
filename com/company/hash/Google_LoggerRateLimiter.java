package com.company.hash;

import java.util.HashMap;
import java.util.Map;

public class Google_LoggerRateLimiter {
    Map<String, Integer> map = new HashMap<>(); // msg : lst print timestamp
    int limiter = 10;
    /** Initialize your data structure here. */
    public Google_LoggerRateLimiter() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }else{
            if(timestamp - map.get(message) >= limiter){
                map.put(message, timestamp);
                return true;
            }
        }

        return false;
    }
}
