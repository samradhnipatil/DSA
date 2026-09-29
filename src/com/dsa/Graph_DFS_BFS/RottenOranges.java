package com.dsa.Graph_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public RottenOranges(){}

    public static class Node{
        int i ; int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    private int checkRottenOrange(int[][] org){
        int minutes = 0;
        int fresh = 0;
        int rows = org.length;
        int cols = org[0].length;

        Queue<Node> queue = new LinkedList<>();
        int[][] vis = new int[org.length][org[0].length];
        for(int i = 0; i < org.length; i++){
            for(int j = 0; j < org[0].length; j++){
                if(org[i][j] == 2){
                    queue.offer(new Node(i, j));
                }
                else if(org[i][j] == 1)
                    fresh++;
            }
        }

        int[][] directions = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            // Process one level = one minute
            for (int i = 0; i < size; i++) {

                Node current = queue.poll();
                int row = current.i;
                int col = current.j;

                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check bounds and fresh orange
                    if (newRow >= 0 && newRow < rows &&
                            newCol >= 0 && newCol < cols &&
                            org[newRow][newCol] == 1) {

                        org[newRow][newCol] = 2;
                        fresh--;

                        queue.offer(new Node(newRow, newCol));
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    private boolean isValid(int[][] org, int i , int j , int[][] vis){
        int r = org.length;
        int c = org[0].length;

        return i >= 0 && j >= 0 && i < r && j < c && vis[i][j] != 1 ;
    }

    public static void main(String[] args) {
        int[][] org = {{0,1,2},{0,1,2},{2,1,1}};
        RottenOranges rottenOranges = new RottenOranges();
        System.out.println(rottenOranges.checkRottenOrange(org));
    }
}
