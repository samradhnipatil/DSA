package com.dsa.Graph_DFS_BFS;

import java.util.Arrays;

public class FloydWarshallAlgorithm {

    public FloydWarshallAlgorithm(){}

    private int[][] getShortestPathBetweenAllVertices(int[][] dist, int v){
//        int[][] path = new int[dist.length][dist[0].length];

        for(int i = 0 ; i < v ; i++) {
            for(int j = 0 ; j < v; j++){
                if( dist[i][j] == -1)
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int k = 0; k < v; k++){
            for(int i = 0; i < v; i++) {
                for(int j =0; j < v; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], (dist[i][k] + dist[k][j]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
//        int[][] dist = {{0, 2, -1, -1},{1, 0, 3, -1},{-1, -1, 0, 1},{3, 5, 4, 0}};
        int t = Integer.MAX_VALUE;
        int[][] dist = {{0, 3, t, t},{3, 0, 1, 4},{t, 1, 0, 1},{t, 4, 1, 0}};
        int v = 4;

        FloydWarshallAlgorithm floydWarshallAlgorithm = new FloydWarshallAlgorithm();
        System.out.println(Arrays.deepToString(floydWarshallAlgorithm.getShortestPathBetweenAllVertices(dist, v)));
    }
}
