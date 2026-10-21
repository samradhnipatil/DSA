package com.dsa.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class FindTheShortestPath_1_n {

    public FindTheShortestPath_1_n(){

    }

    public class DS{
        int sum;
        ArrayList<Integer> path;

        public DS(int sum, ArrayList<Integer> path){
            this.sum = sum;
            this.path = path;
        }
    }

    private ArrayList<Integer> printTheShortestPathBetween_1_n(int n, int m , int[][] edges, int start){
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i : edges){
            adj.get(i[0]).add(new ArrayList<>(Arrays.asList(i[1], i[2])));
            adj.get(i[1]).add(new ArrayList<>(Arrays.asList(i[0], i[2])));
        }

        PriorityQueue<DS> que = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.sum, b.sum)
        );
        que.add(new DS(0, new ArrayList<>(Arrays.asList(start))));

        int sum = Integer.MAX_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();

        int[] pathVal = new int[n+1];
        Arrays.fill(pathVal, Integer.MAX_VALUE);
        pathVal[start] = 0;

        while(!que.isEmpty()) {
            DS ds = que.poll();
            int last = ds.path.getLast();
            int s = ds.sum;

            for(ArrayList<Integer> temp : adj.get(last)) {
                int val = s + temp.get(1);
                ArrayList<Integer> newPath = (ArrayList<Integer>) ds.path.clone();
                if(val < pathVal[temp.get(0)]) {
                    newPath.add(temp.getFirst());
                    pathVal[temp.getFirst()] = val;
                    que.add(new DS(val, newPath));
                }

                if(temp.getFirst() == n && val < sum){
                    ans = newPath;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] edges = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};
        int n = 5;
        int m = 6;
        int start = 1;

        FindTheShortestPath_1_n f = new FindTheShortestPath_1_n();
        System.out.println(f.printTheShortestPathBetween_1_n(n, m, edges, start));
    }
}
