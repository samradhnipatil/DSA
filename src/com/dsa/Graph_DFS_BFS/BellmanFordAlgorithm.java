package com.dsa.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BellmanFordAlgorithm {

    public BellmanFordAlgorithm(){

    }

    private int[] getShortestPath(int[][] edges, int v, int s){
        int[] path = new int[v];
        Arrays.fill(path, Integer.MAX_VALUE);
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(new ArrayList<>(Arrays.asList(edge[1], edge[2])));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        path[s] = 0;

        while(!queue.isEmpty()){
            int t = queue.poll();

            for(ArrayList<Integer> ad : adj.get(t)) {
                int p = path[t] + ad.get(1);
                int q = ad.getFirst();
                if(p < path[q]){
                    path[q] = p;
                    queue.add(q);
                }
            }
        }

        return path;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,5},{1,0,3},{1,2,-1},{2,0,1}}; //{{3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, 3}};

        int v = 3;
        int s = 21;
        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
        System.out.println(Arrays.toString(bellmanFordAlgorithm.getShortestPath(edges, v, s)));
    }
}
