package com.dsa.Graph_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMatrix {
    public ShortestDistanceInBinaryMatrix(){}

    private int getShortestPathInBinaryMatrix( int[][] mat, int[] s, int[] d , int[][] vis){

        int[][] dirs = {{0,1}, {1,0},{-1,0},{0,-1}};

        if(mat[s[0]][s[1]] != 1 || mat[d[0]][d[1]] != 1 )
            return -1;

        int min = Integer.MAX_VALUE;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{s[0],s[1], 0});
        while(!que.isEmpty()){
            int[] t = que.poll();

            if(t[0] == d[0] && t[1] == d[1])
                min = Math.min(min, t[2]);

            for(int[] dir : dirs){
                int i = t[0] + dir[0];
                int j = t[1] + dir[1];

                if(i >= 0 && j >= 0 && i < mat.length & j < mat[0].length && mat[i][j] == 1 && vis[i][j] != 1){
                    vis[i][j] = 1;
                    que.add(new int[] {i, j, t[2]+1});
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean isValid(int[][] mat, int i , int j){
        return i >= 0 && j >= 0 && i < mat.length && j< mat[0].length && mat[i][j] ==1;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1, 1},{1, 1, 0, 1},{1, 1, 1, 1},{1, 1, 0, 0},{1, 0, 0, 1}};
        int[] s = {0,1};
        int[] d = {2,2};
         int[][] vis = new int[mat.length][mat[0].length];

        ShortestDistanceInBinaryMatrix matrix = new ShortestDistanceInBinaryMatrix();
        System.out.println(matrix.getShortestPathInBinaryMatrix(mat, s, d, vis));
    }
}
