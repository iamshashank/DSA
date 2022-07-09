package com.company.priorityqueue_heap;

import java.util.*;

/**
 * Round 3: Coding Round
 * a) Given on-call rotation schedule for multiple people by: their name, start time and end time of the rotation:
 *
 * Abby 1 10
 * Ben 5 7
 * Carla 6 12
 * David 15, 17
 *
 * and given t = 9, return a list of names who are on call at time t.
 *
 * Expected output: [Abby, Carla]
 *
 * b) Return a rotation table without overlapping periods representing who are on call during that time. Return "Start time", "End time" and list of names:
 *
 * 1 5 Abby
 * 5 6 Abby, Ben
 * 6 7 Abby, Ben, Carla
 * 7 10 Abby, Carla
 * 10 12 Carla
 * 15 17 David
 */

public class Google_CallSchedule {
    public List<String>  processA(String[] a, int[][] b, int t){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<b.length;i++){
            if(t >= b[i][0] && t <= b[i][1]){
                ans.add(a[i]);
            }
        }
        return ans;
    }


    public void processB(String[] a, int[][] b){
        List<Event> ev = new ArrayList<>();

        for(int i=0;i<b.length;i++){
            ev.add(new Event(b[i][0], a[i], 0));
            ev.add(new Event(b[i][1], a[i], 1));
        }

        Collections.sort(ev, (x,y)->{
            if(x.time == y.time){
                // end time event should come first
                return y.type - x.type;
            }
            return x.time - y.time;
        });
        System.out.println(ev);

        List<Schedule> ans = new ArrayList<>();
        Set<String> activeUsers = new HashSet<>();
        activeUsers.add(ev.get(0).user);
        int prevStartTime = ev.get(0).time;
        for(int i=1;i<ev.size();i++){

            Event e = ev.get(i);
//            System.out.println(e);
            if(e.type == 0){
                if(e.time == prevStartTime || activeUsers.size() == 0){
                    activeUsers.add(e.user);
                    prevStartTime = e.time;
                }else {
                    // split and update prevStartTime
                    ans.add(new Schedule(prevStartTime, e.time, new ArrayList<>(activeUsers)));
                    prevStartTime = e.time;
                    activeUsers.add(e.user);
                }
            }else{
                List<String> u = new ArrayList<>();
                u.add(e.user);
                // if multiple users calls are ending at same time
                while(i+1 < ev.size() && ev.get(i+1).type == 1 && ev.get(i+1).time == e.time){
                    u.add(ev.get(++i).user);
                }

                ans.add(new Schedule(prevStartTime, e.time, new ArrayList<>(activeUsers)));
                prevStartTime = e.time;
                // remove the user from active users
                for(String t : u) activeUsers.remove(e.user);
            }
//            System.out.println(ans);
        }

        for(Schedule v : ans){
            System.out.println(v);
        }
    }

    private class Schedule{
        public int start, end;
        public List<String> users;
        Schedule(int start, int end, List<String> users){
            this.start = start;
            this.end = end;
            this.users = users;
        }

        public String toString(){
            return start+", "+end+", "+users;
        }
    }

    private class Event{
        public int time, type;
        public String user;
        Event(int t, String u, int type){
            this.time = t;
            this.user = u;
            this.type = type; // 0 is start time, 1 is end time
        }

        public String toString(){
            return time+":"+type+" "+user;
        }
    }
}
