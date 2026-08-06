package com.dsa.GreedyApproach;

import java.util.Arrays;

public class AssignCookies {

    public AssignCookies() {
        int[] c = {1,5,3,3,4};
        int[] p = {4,2,1,2,1,3};
        int max = CountCookies(c, p);
        System.out.println("Maximum Number of children who gets cookie : " + max);
    }

    public int CountCookies(int[] children, int[] parent){
        int count = 0;
        int i = 0;
        int j = 0;
        Arrays.sort(children);
        Arrays.sort(parent);

        while( j < children.length & i < parent.length){

            while(children[j] > parent[i])
                i++;
            if(children[j] <= parent[i]){
                i++;j++;
                count++;
            }
        }
        return count;
    }
}
