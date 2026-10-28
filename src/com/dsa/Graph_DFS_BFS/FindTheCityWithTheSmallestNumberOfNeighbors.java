package com.dsa.Graph_DFS_BFS;

import java.util.Arrays;

public class FindTheCityWithTheSmallestNumberOfNeighbors {

    public FindTheCityWithTheSmallestNumberOfNeighbors(){}

    private int getCityWithMinimumNeighbors(int[][] edges, int n , int threshold ){
        int[][] dist = new int[n][n];

        for(int[] edge : edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        for(int i = 0; i < n;i++){
            for(int j = 0; j < n ;j++){
                if( i != j && dist[i][j] == 0)
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int min = 0;
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++) {
                int count = 0;
                for(int j =0; j < n; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], (dist[i][k] + dist[k][j]));
                        if(dist[i][j] <= threshold)
                            count++;
                    }
                }
                min  = Math.max(min,count);
            }
        }
        int c = 0;
        for(int i = 0; i < n;i++){
            int count = 0;
            for(int j = 0; j < n ;j++){
                if( i != j && dist[i][j] <= threshold) {
                    count++;
                }
            }
            c = Math.max(c, count);
        }
        System.out.println(min);
        return c;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int n = 4;
        int threshold = 4;
        FindTheCityWithTheSmallestNumberOfNeighbors find = new FindTheCityWithTheSmallestNumberOfNeighbors();
        System.out.println(find.getCityWithMinimumNeighbors(edges, n , threshold));
    }
}
