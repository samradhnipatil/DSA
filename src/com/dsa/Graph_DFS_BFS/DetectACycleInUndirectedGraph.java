package com.dsa.Graph_DFS_BFS;

import java.util.Stack;

public class DetectACycleInUndirectedGraph {

    public DetectACycleInUndirectedGraph(){}

    private boolean checkIfTheCycleExistsInAUndirectedGraph(int[][] adj, int start, int v){
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        int[] vis = new int[v];
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            if(vis[curr] == 1)
                return true;
            vis[curr] = 1;
            for(int i : adj[curr]){
                if(vis[i] != 1)
                    stack.add(i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] adj = {{1,2},{0},{0,3},{2}};
        int v = 4;
        DetectACycleInUndirectedGraph dec = new DetectACycleInUndirectedGraph();

        System.out.println(dec.checkIfTheCycleExistsInAUndirectedGraph(adj, 0, v) ? "Cycle exists" : "Cycle does not exists");
    }

}
