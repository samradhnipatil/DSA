package com.dsa.Recursion;

public class MColorGraph {
    public MColorGraph() {
        int[][] edges = {{0,1},{1, 2},{2, 3},{0,3},{0,2}};
        int[] color = new int[edges.length];
        if(graphColoring(edges, color, edges.length, 3))
            System.out.println("Graph can be colored");
        else
            System.out.println("Graph can not be colored");
    }

    boolean graphColoring(int[][] edges, int[] color,int n, int m ) {
        boolean ans = colorGraph(edges,0,color,  m,  n);
        return ans;
    }

    public boolean colorGraph(int[][] edges,int node,int[] color, int m, int n){
        if(node == n){
            return true;
        }
        for(int i = 1; i <= m; i++){
            if(isPossible(edges, i, node,color)){
                color[node] = i;
                if(colorGraph(edges,node+1,color,m,n)){
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    public boolean isPossible(int[][] edges, int col, int node, int[] color){
        for(int i= 0; i < edges.length; i++){
            if(edges[i][0] == node){
                if(color[edges[i][1]] == col)
                    return false;
            }
            else if(edges[i][1] == node){
                if(color[edges[i][0]] == col)
                    return false;
            }
        }
        return true;
    }
}
