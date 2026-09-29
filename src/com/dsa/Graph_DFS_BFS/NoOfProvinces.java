package com.dsa.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class NoOfProvinces {

    public NoOfProvinces(){}

    private HashMap<Integer, ArrayList<Integer>> createAdjacencyList(int[][] edges, int ver){
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int k = 0; k < ver; k++){
            adj.put(k, new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < edges.length;j++){
                if(i != j && edges[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        return adj;
    }

    private int getNoOfProvinces(HashMap<Integer, ArrayList<Integer>> edges, int v, int start) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ver = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for(int i = 0; i < v; i++){
            ver.add(i);
        }
        int count = 0;
        stack.add(start);
        ver.remove(start);

        while(!ver.isEmpty()) {
            int node  = stack.pop();
            visited[node] = true;
            ver.remove(Integer.valueOf(node));
            for(int i : edges.get(node)){
                if(!visited[i]){
                    stack.add(i);
                }
            }

            if(stack.isEmpty()){
                count++;
                if(!ver.isEmpty())
                    stack.add(ver.getFirst());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] adj = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}};
        NoOfProvinces noOfProvinces = new NoOfProvinces();
        HashMap<Integer, ArrayList<Integer>> edges = noOfProvinces.createAdjacencyList(adj, adj.length);

        System.out.println(noOfProvinces.getNoOfProvinces(edges,adj.length, 0));
    }
}
