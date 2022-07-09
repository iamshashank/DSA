package com.company;

import java.util.ArrayList;

/**
 *
 * design a rate limiter for api call on a application level not user level
 * the entire application can only handle 10 req / sec
 *
 *
 * Approach:
 *
 *     Initialize a redis key for 100 with a TTL of one minute.
 *     Write the logic in following manner upon receiving each request
 *
 *     leftover_capacity = set(key)
 *     if(leftover_capacity < 0)
 *          raise RateLimitedVoilatedException
 *     end
 *
 * ## it is an atomic operation, which decrements the key by one, and returns the new value.. hence free from race conditions
 * def set(key)
 * $redis.call(DECR, key)
 * end
 *
 * By changing the cycle merely from GET-SET to SET-GET, you can eliminate the race condition..
 *
 *
 */

public class ApiRateLimiter {

    private class CustomLimiter{
        private ArrayList<Long> window;
        private long limit;
        public CustomLimiter(int limit){
            this.limit = limit;
            this.window = new ArrayList<>(limit);
        }

        public boolean stillUnderLimit(){
            long currTime = System.currentTimeMillis();
            trimWindow(currTime);
            if(window.size() < limit){
                window.add(currTime);
                return true;
            }else{
                return false;
            }
        }

        private void trimWindow(long currTime){
            // remove all old request
            while(!window.isEmpty() && (window.get(0) < currTime - 1000)){
                window.remove(0);
            }
        }
    }


    public int process() throws InterruptedException {
        CustomLimiter limiter = new CustomLimiter(10);
        for(int i=0;i<100;i++){
            Thread.sleep(20);
            if(limiter.stillUnderLimit()){
                System.out.println("Acceess granted");
            }else{
                System.out.println("Acceess denied");
            }
        }
        return 0;
    }

}
