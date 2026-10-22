package com.dsa.Graph_DFS_BFS;

import java.util.*;

public class MinimumMultiplicationsToReachEnd {

    public MinimumMultiplicationsToReachEnd(){}

    private int getTheMinimumNumberOFMultiplications(int[] arr, int start, int end){
        int div = 100000;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, 0});

        while(!queue.isEmpty()){
            int[] t = queue.poll();

            for (int i : arr) {
                int mul = (t[0] * i) % div;
                if(mul == end)
                    return t[1]+1;
                else if (mul <= end) {
                    queue.add(new int[]{mul, t[1] + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        int start = 7;
        int end = 66175;

        MinimumMultiplicationsToReachEnd multiplication = new MinimumMultiplicationsToReachEnd();
        System.out.println(multiplication.getTheMinimumNumberOFMultiplications(arr, start, end));
    }
}
