package com.dsa.GreedyApproach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class MinimumPlatforms {
    public MinimumPlatforms() {
         double[] arr = {9.00,9.45,9.55,11.00,15.00,18.00};
        double[] dep = {9.20,12.00,11.30,11.50,19.00,20.00};
        int x = MinPlatforms(arr, dep);
        System.out.println(x);
    }

    public int MinPlatforms(double[] arrivals, double[] departs){
        // sort two array
        int i = 0, j = 0;
        int n1 = arrivals.length;
        Arrays.stream(arrivals).sorted();
        Arrays.stream(departs).sorted();
        int max = 0,count = 0;
        while(i < n1 && j < n1){
            if(arrivals[i] < departs[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        while(i < n1){
            count++;
            max = Math.max(max, count);
            i++;
        }
        while(j < n1){
            count--;
            max = Math.max(max, count);
            j++;
        }
        return max;
    }
}
