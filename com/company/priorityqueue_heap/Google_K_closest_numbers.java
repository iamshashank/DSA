package com.company.priorityqueue_heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Google_K_closest_numbers {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)->{
            if(a.diff != b.diff) return a.diff - b.diff;
            return a.el - b.el;
        });

        for(int v : arr) q.add(new Pair((int)Math.abs(x-v), v));

//        SMALL OPTIMIZATION WE ONLY KEEP K ELEMENTS IN QUEUE
//        for(int v : arr){
//            if(q.size() < k){
//                q.add(new Pair((int)Math.abs(x-v), v));
//            }else{
//                int dx = (int)Math.abs(v-x);
//                if(dx < q.peek().diff){
//                    q.remove();
//                    q.add(new Pair((int)Math.abs(x-v), v));
//                }
//            }
//        }

        for(int i=0;i<k;i++) ans.add(q.remove().el);
        Collections.sort(ans);
        return ans;
    }

    class Pair{
        int diff, el;
        Pair(int diff, int el){
            this.diff = diff;
            this.el = el;
        }

        public String toString(){
            return el+" : "+diff;
        }
    }
}
