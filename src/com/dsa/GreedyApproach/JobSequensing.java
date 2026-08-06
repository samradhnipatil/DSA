package com.dsa.GreedyApproach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JobSequensing {
    public JobSequensing() {
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(0, new Job(1,4,40));
        jobs.add(1, new Job(2,1,40));
        jobs.add(2, new Job(3,1,30));
        jobs.add(3, new Job(4,1,10));

        int prof = MaximumProfit(jobs);
        System.out.println("Maximum Profit : " + prof);
    }

    public class Job{
        private int id;
        private int deadline;
        private int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    Comparator<Job> comparator = new Comparator<Job>() {
        @Override
        public int compare(Job o1, Job o2) {
            if(o1.profit <= o2.profit)
                return 1;
            else
                return -1;
        }
    };

    public int MaximumProfit(ArrayList<Job> jobs){
        int maxProfit = 0;
        jobs.sort(comparator);
        int n = jobs.size();
        ArrayList<Integer> map = new ArrayList<>(Collections.nCopies(n,-1));

        int i = 0;
        while(i < n){
            Job temp = jobs.get(i);
            int endDay = temp.deadline -1;
            while( endDay >= 0 && map.get(endDay) != -1){
                endDay--;
            }
            if(endDay >= 0 && map.get(endDay) == -1){
                map.set(endDay, temp.id);
                maxProfit+= temp.profit;
            }
            i++;
        }
        return maxProfit;
    }
}
