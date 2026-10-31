package com.dsa.Graph_DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SwimInRisingWater {

    public SwimInRisingWater(){}

    private int getMinimumTimeToReachTheEnd(int[][] grid){

        int[][] time = new int[grid.length][grid[0].length];
        for(int[] p : time){
            Arrays.fill(p, Integer.MAX_VALUE);
        }

        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0, 0});
        time[0][0] = 0;

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int[] dir : dirs){
                int i = temp[0] + dir[0];
                int j = temp[1] + dir[1];
                int currT = time[temp[0]][temp[1]];

                if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && time[i][j] > currT) {
                    int newT =  Math.max(currT, grid[i][j]);
                    if(i == grid.length -1 && j == grid.length-1) {
                        min = Math.min(min, newT);
                    }
                    else {
                        queue.add(new int[]{i, j, newT});
                    }
                    time[i][j] =  newT;
                }

            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] grid = {{6, 1, 4},{2, 7, 3},{0, 5, 8}};
        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        System.out.println(swimInRisingWater.getMinimumTimeToReachTheEnd(grid));
    }
}
