package com.dsa.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DijkstrasAlgo {

    public DijkstrasAlgo(){}

    private int[] getShortestPath(int[][] edges, int v, int source){
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i : edges){
            adj.get(i[0]).add(new ArrayList<>(Arrays.asList(i[1], i[2])));
            adj.get(i[1]).add(new ArrayList<>(Arrays.asList(i[0], i[2])));
        }
        int[] path = new int[v];
        Arrays.fill(path, Integer.MAX_VALUE);

        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        path[source] = 0;
        while(!que.isEmpty()){
            int t = que.poll();
            for(ArrayList<Integer> i : adj.get(t)){
                int p = path[t] + i.getLast();
                if(p < path[i.getFirst()]){
                    path[i.getFirst()] = p;
                    que.add(i.getFirst());
                }
            }
        }
        return path;
    }

    public static void main(String[] args) {
        int v = 3;
        int source = 0;
        int[][] edges = {{0,1,1}, {0,2,6},{1,2,3}};
        DijkstrasAlgo dijkstrasAlgo = new DijkstrasAlgo();
        System.out.println(Arrays.toString(dijkstrasAlgo.getShortestPath(edges,v,source)));
    }
}
