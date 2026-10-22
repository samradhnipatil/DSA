package com.dsa.Graph_DFS_BFS;

import java.util.*;

public class CheapestFlightWIthInKStops {

    public CheapestFlightWIthInKStops(){}

    private int getTheCheapestFlight(int[][] flights, int s, int d, int k, int n){

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            adj.get(flight[0]).add(new ArrayList<>(Arrays.asList(flight[1], flight[2])));
        }

        Queue<int[]> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        queue.add(new int[]{s,0,-1});

        while(!queue.isEmpty()) {
            int[] t = queue.poll();
            if( t[0] == d)
                min = Math.min(min, t[1]);

            for(ArrayList<Integer> cities : adj.get(t[0])){
                if(t[2] + 1 <= k){
                   queue.add(new int[]{cities.getFirst(), t[1]+ cities.get(1) , t[2]+1});
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int s = 0;
        int d = 2;
        int k = 1;
        int n = 3;

        CheapestFlightWIthInKStops cheapestFlightWIthInKStops= new CheapestFlightWIthInKStops();
        System.out.println(cheapestFlightWIthInKStops.getTheCheapestFlight(flights,s,d,k,n));
    }
}
