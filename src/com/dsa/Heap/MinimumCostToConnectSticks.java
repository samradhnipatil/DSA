package com.dsa.Heap;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public static void main(String[] args) {
        MinimumCostToConnectSticks min = new MinimumCostToConnectSticks();
        int[] len = { 1,8,3,5};
        System.out.println(min.getMinimumCostToStick(len));
    }

    public MinimumCostToConnectSticks(){

    }

    private int getMinimumCostToStick(int[] len){
        PriorityQueue<Integer> que = new PriorityQueue<>(
                Integer::compare
        );

        if(len.length == 0)
            return 0;

        for(int i : len){
            que.offer(i);
        }
        int fir = que.isEmpty() ? 0 : que.poll();
        int sum = 0;
        while(!que.isEmpty() && fir != 0){
            int sec = que.poll();
            sum = (fir + sec) + sum;
            fir = fir + sec;
        }
        return sum;
    }
}
