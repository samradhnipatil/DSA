package com.dsa.Graph_DFS_BFS;
import java.util.*;

public class NoOfEnclaves {

    public NoOfEnclaves(){}

    public static class Node{
        int i ; int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    private int countTheNoOfEnclaves(int[][] land){
        int count = 0 ;
        int[][] vis = new int[land.length][land[0].length];
        for(int i = 1; i < land.length-1; i++){
            for(int j = 1; j < land[0].length-1; j++){
                if(land[i][j] == 1 && vis[i][j] != 1)
                    count += markTheLand(land, i, j, vis);
            }
        }
        return count;
    }

    private int markTheLand(int[][] land, int i, int j, int[][] vis){
        int l = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i,j));
        boolean bound = false;
        while(!que.isEmpty()) {
            Node node = que.poll();
            vis[node.i][node.j] = 1;
            if(isBoundary(land, node.i, node.j)){
                bound = true;
            }
            else{
                l++;
            }
            if(isValid(land, node.i-1, node.j, vis)){
                que.add(new Node(node.i-1, node.j));
            }
            if(isValid(land, node.i, node.j+1, vis)){
                que.add(new Node(node.i, node.j+1));
            }
            if(isValid(land, node.i+1, node.j, vis)){
                que.add(new Node(node.i+1, node.j));
            }
            if(isValid(land, node.i, node.j-1, vis)){
                que.add(new Node(node.i, node.j-1));
            }
        }
        if(!bound)
            return l;
        else return 0;
    }

    private boolean isValid(int[][] land, int i , int j, int[][] vis){
        int r = land.length;
        int c = land[0].length;

        return i >= 0 && j >= 0 && i < r && j < c && land[i][j] == 1 && vis[i][j] != 1;
    }

    private boolean isBoundary(int[][] land, int i , int j){
        int r = land.length-1;
        int c = land[0].length-1;
        return i == 0 || j == 0 || i == r || j == c;
    }

    public static void main(String[] args) {
        int[][] land = {{0, 0, 0, 1},{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        NoOfEnclaves noOfEnclaves = new NoOfEnclaves();
        System.out.println(noOfEnclaves.countTheNoOfEnclaves(land));
    }
}
