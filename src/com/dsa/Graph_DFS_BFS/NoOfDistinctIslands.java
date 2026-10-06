package com.dsa.Graph_DFS_BFS;

import java.util.*;

public class NoOfDistinctIslands {
    public NoOfDistinctIslands(){}

    private int getDistinctIslands(int[][] land){
        int[][] vis = new int[land.length][land[0].length];
        HashSet<int[][]> set = new HashSet<>();
        int count  = 0;
        for(int i = 0; i < land.length ; i++){
            for(int j = 0 ; j < land[0].length; j++){
                if(vis[i][j] == 0 && land[i][j] == 1){
                    count += markTheIsland(land, vis, i, j, set);
                }
            }
        }
        return count;
    }

    private int markTheIsland(int[][] land, int[][] vis, int i, int j,HashSet<int[][]> set){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i, j});
        int[][] dirs = {{-1,0},{0,1}, {1,0},{0,-1}};

        int[][] island = new int[land.length][land[0].length];
        while(!que.isEmpty()){
            int[] t = que.poll();
            island[t[0] - i][t[1] - j] = 1;
            vis[t[0]][t[1]] = 1;

            for(int[] dir : dirs){
                int i1 = t[0] + dir[0];
                int j1 = t[1] + dir[1];

                if(i1 >= 0 && j1 >= 0 && i1 < land.length && j1 < land[0].length && land[i1][j1] == 1 && vis[i1][j1] != 1){
                    que.add(new int[]{i1,j1});
                }
            }
        }
        if(!set.contains(island)){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] land = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1},{1, 1, 0, 1, 1}};
        NoOfDistinctIslands no = new NoOfDistinctIslands();
        System.out.println(no.getDistinctIslands(land));
    }
}
