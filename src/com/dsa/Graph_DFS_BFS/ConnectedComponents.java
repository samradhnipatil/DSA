package com.dsa.Graph_DFS_BFS;
import java.lang.reflect.Array;
import java.util.*;

public class ConnectedComponents {

    public ConnectedComponents(){}

    private HashMap<Integer, ArrayList<Integer>> createAdjacencyList(int[][] edges, int ver){
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int k = 0; k < ver; k++){
            adj.put(k, new ArrayList<>());
        }

        for(int[] i : edges){
            int u = i[0];
            int v = i[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    private int countConnectedComponents(HashMap<Integer, ArrayList<Integer>> edges, int v, int start) {
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
        int[][] edges = {{0,1},{1,2},{3,4}};
        int v = 5;
        ConnectedComponents connectedComponents = new ConnectedComponents();
        HashMap<Integer, ArrayList<Integer>> adj = connectedComponents.createAdjacencyList(edges, v);

        System.out.println(connectedComponents.countConnectedComponents(adj, v, 0));
    }
}
