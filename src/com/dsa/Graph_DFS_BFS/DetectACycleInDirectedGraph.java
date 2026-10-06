package com.dsa.Graph_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class DetectACycleInDirectedGraph {
    public DetectACycleInDirectedGraph(){

    }

    private boolean doesCycleExists(int[][] adj, int v, int[] vis){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()){
            int t = queue.poll();
            vis[t] = 1;
            for(int i : adj[t] ){
                if(vis[i] == 1)
                    return true;
                queue.add(i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        DetectACycleInDirectedGraph detectACycleInDirectedGraph = new DetectACycleInDirectedGraph();
        int[][] adj = { {1}, {2, 5}, {3}, {4}, {1}, {}};
        int[] vis = new int[adj.length];
        for(int i = 0; i < adj.length; i++){
            if(adj[i].length != 0 && vis[i] != 1)
                System.out.println(detectACycleInDirectedGraph.doesCycleExists(adj, i, vis) ? "Cycle Exists" : "Cycle does not exists");
        }
    }
}
