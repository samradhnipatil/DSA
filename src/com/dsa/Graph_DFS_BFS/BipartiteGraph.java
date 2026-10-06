package com.dsa.Graph_DFS_BFS;

import java.util.Arrays;

public class BipartiteGraph {

    public BipartiteGraph(){}

    private boolean checkIfTheGraphIsBipartite(int[][] adj, int v, int c , int[] col, boolean ans){
        if(col[v] == c)
            return true;
        else {
            if (col[v] != -1)
                return false;
        }

        col[v] = c;
        for(int i : adj[v]){
            ans = ans && checkIfTheGraphIsBipartite(adj, i, 1-c, col, ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] adj = {{1,3},{0,2},{1,4},{0,4},{2,3}};
        BipartiteGraph bipartiteGraph = new BipartiteGraph();
        int[] col = new int[adj.length];
        Arrays.fill(col, -1);
        System.out.println(bipartiteGraph.checkIfTheGraphIsBipartite(adj, 0, 0, col, true));
    }
}
