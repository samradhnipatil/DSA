package com.dsa.Graph_DFS_BFS;

import java.lang.reflect.Array;
import java.util.*;

public class Implement_DFS_BFS {

    public Implement_DFS_BFS(){

    }

    private HashMap<Integer, ArrayList<Integer>> createAdjacencyList(int[][] edges){
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int k = 0; k <= edges.length; k++){
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

    private ArrayList<Integer> dfs_usingRecursion(int node , HashMap<Integer, ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);

        for(int v : adj.get(node)){
            if(!visited[v]){
                dfs_usingRecursion(v, adj, visited, dfs);
            }
        }
        return dfs;
    }

    private ArrayList<Integer> dfs_usingStack(int start, HashMap<Integer, ArrayList<Integer>> edges){
        Stack<Integer> stack = new Stack<>();

        HashSet<Integer> vis = new HashSet<>();
        ArrayList<Integer> dfs = new ArrayList<>();
        stack.add(start);


        while(!stack.isEmpty()){
            int t = stack.pop();
            dfs.add(t);
            vis.add(t);
            for(int i : edges.get(t)){
                if(!vis.contains(i)){
                    stack.add(i);
                }
            }
        }
        return dfs;
    }

    private ArrayList<Integer> bfs_usingQueue(int node, HashMap<Integer, ArrayList<Integer>> edges){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[edges.size()+1];
        ArrayList<Integer> bfs = new ArrayList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int t = queue.poll();
            bfs.add(t);
            for(int i : edges.get(t)){
                if(!vis[i])
                    queue.add(i);
            }
            vis[t] = true;
        }
        return bfs;
    }

    public static void main(String[] args) {
        Implement_DFS_BFS implementDfsBfs = new Implement_DFS_BFS();
        int[][] edges = {{0,2}, {0,3},{0,1},{2,4}};

        HashMap<Integer, ArrayList<Integer>> adj = implementDfsBfs.createAdjacencyList(edges);
        //DFS
        System.out.println(implementDfsBfs.dfs_usingRecursion(0, adj, new boolean[edges.length +1], new ArrayList<>()));
        System.out.println(implementDfsBfs.dfs_usingStack(0, adj));
        // BFS
        System.out.println(implementDfsBfs.bfs_usingQueue(0, adj));

    }
}
