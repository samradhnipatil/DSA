package com.dsa.Graph_DFS_BFS;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {

    public NumberOfWaysToArriveAtDestination(){}

    private int getNumberOfWaysToReachDestinationInMinimumTime(int[][] roads, int n, int m ){
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            adj.get(road[0]).add(new ArrayList<>(Arrays.asList(road[1], road[2])));
            adj.get(road[1]).add(new ArrayList<>(Arrays.asList(road[0], road[2])));
        }
        int[] vis = new int[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int min = Integer.MAX_VALUE;
        int count = 0;
        while(!queue.isEmpty()) {
            int[] t = queue.poll();
            vis[t[0]] = 1;
            for(ArrayList<Integer> i : adj.get(t[0])){
                if(vis[i.getFirst()] != 1) {
                    int dist = t[1] + i.get(1);
                    if (i.getFirst() == n - 1) {
                        if (min > dist) {
                            min = dist;
                            count = 1;
                        } else if (dist == min) {
                            count++;
                        }
                    } else {
                        queue.add(new int[]{i.getFirst(), dist});
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] roads = {{0,5,8},{0,2,2},{0,1,1},{1,3,3},{1,2,3},{2,5,6},{3,4,2},{4,5,2}};
        int n = 6;
        int m = 8;

        NumberOfWaysToArriveAtDestination num = new NumberOfWaysToArriveAtDestination();
        System.out.println(num.getNumberOfWaysToReachDestinationInMinimumTime(roads, n, m));
    }
}
