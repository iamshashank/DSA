package com.company.priorityqueue_heap;

import java.util.PriorityQueue;

/**
 * Given T[] , an array that represents N agents and the time they need to serve customers . All N agents can serve at once
 * for M customers if they are waiting , they choose the agent with the least serving time .
 * If a New customer comes in , calculate the total wait time.
 */
public class Google_CustomerWaitTime {
    public int waitTime(int n, int m, int[] agents){
        PriorityQueue<Schedule> nextAvailableAt = new PriorityQueue<>((a, b)->{
            if(a.availableAt == b.availableAt) return a.timeToServe - b.timeToServe;
            return a.availableAt - b.availableAt;
        });

        for(int i =0;i<agents.length;i++) nextAvailableAt.add(new Schedule(i, 0, agents[i]));
        int totalWaitTime = 0;
        for(int i = 0;i<m;i++){
            Schedule agent = nextAvailableAt.remove();
            agent.availableAt = agent.availableAt + agent.timeToServe;
            agent.totalCustomerServed++;
            nextAvailableAt.add(agent);
        }
        // so now we see which agent will serve the m+1 th customer
        Schedule agent = nextAvailableAt.remove();
        return agent.totalCustomerServed*agent.timeToServe;
    }

    private class Schedule{
        int agentIndex, availableAt, timeToServe, totalCustomerServed = 0;
        Schedule(int i, int availableAt, int timeToServe){
            this.agentIndex = i;
            this.availableAt = availableAt;
            this.timeToServe = timeToServe;
        }
    }
}
