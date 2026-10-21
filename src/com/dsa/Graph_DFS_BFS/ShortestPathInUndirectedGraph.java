package com.dsa.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ShortestPathInUndirectedGraph {

    public ShortestPathInUndirectedGraph(){}

    private HashMap<Integer, ArrayList<Integer>> getAdjVertices(int[][] edges){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] i : edges){
            if(map.containsKey(i[0])){
                map.computeIfPresent(i[0], (k,v)->{
                    v.add(i[1]);
                    return v;
                });
            }
            else
                map.put(i[0], new ArrayList<>(List.of(i[1])));

            if(map.containsKey(i[1])){
                map.computeIfPresent(i[1], (k,v)->{
                    v.add(i[0]);
                    return v;
                });
            }
            else
                map.put(i[1], new ArrayList<>(List.of(i[0])));
        }

        return map;
    }

    private int[] getShortestPathInUDG(HashMap<Integer, ArrayList<Integer>> map, int v, int sum, int[] path, int[] vis){
        if(v == 0)
            path[v] = 0;
        else if(path[v] == -1 || (path[v] != -1 && path[v] > (sum+1)))
            path[v] = sum + 1;

        for(Integer i : map.get(v)){
            if(vis[i] != 1) {
                vis[i] = 1;
                path = getShortestPathInUDG(map, i, path[v], path, vis);
                vis[i] = 0;
            }
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,0},{2,1},{0,3},{3,7},{3,4},{7,4},{7,6},{4,5},{4,6},{6,5}};
        int v = 8;
        int[] path = new int[v];
        Arrays.fill(path, -1);
        int[] vis = new int[v];
        ShortestPathInUndirectedGraph shortestPathInUndirectedGraph = new ShortestPathInUndirectedGraph();
        HashMap<Integer, ArrayList<Integer>> map = shortestPathInUndirectedGraph.getAdjVertices(edges);
        System.out.println(Arrays.toString(shortestPathInUndirectedGraph.getShortestPathInUDG(map,0,0, path, vis)));
    }
}
