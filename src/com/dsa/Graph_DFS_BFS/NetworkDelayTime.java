package com.dsa.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NetworkDelayTime {

    public NetworkDelayTime(){}

    public int getNetworkDelayTime(int[][] nodes, int k , int n){

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] node : nodes){
            adj.get(node[0]).add(new ArrayList<>(Arrays.asList(node[1], node[2])));
        }

        int count = 0;
        int min = 0;
        int[] vis = new int[n+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k, 0});
        while(!queue.isEmpty()){
            int[] t = queue.poll();
            vis[t[0]] = 1;
            count++;
            for(ArrayList<Integer> d : adj.get(t[0])) {
                if(vis[d.getFirst()] != 1) {
                    int time = d.getLast() + t[1];
                    queue.add(new int[]{d.getFirst(), time});
                    min = Math.max(min, time);
                }
            }
        }
        return  count == n ? min : -1;
    }

    public static void main(String[] args) {
        int[][] nodes = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.getNetworkDelayTime(nodes, k, n));
    }
}
