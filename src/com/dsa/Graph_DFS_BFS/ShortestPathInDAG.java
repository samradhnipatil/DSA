package com.dsa.Graph_DFS_BFS;

import java.util.Arrays;

public class ShortestPathInDAG {

    public ShortestPathInDAG(){}

    private int[] getShortestPathInDAG(int[][] edges, int v, int sum, int w, int[] path){

        if(path[v] == -1 || (path[v] != -1 && path[v] > (sum+w)))
            path[v] = sum + w;

        for(int[] i : edges){
            if(i[0] == v){
                path = getShortestPathInDAG(edges, i[1], path[v], i[2], path);
            }
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,2}, {0,2,1}};
        int v = 4;
        int[] path = new int[v];
        Arrays.fill(path, -1);
        ShortestPathInDAG shortestPathInDAG = new ShortestPathInDAG();
        System.out.println(Arrays.toString(shortestPathInDAG.getShortestPathInDAG(edges,0,0,0, path)));
    }
}
