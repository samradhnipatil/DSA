package com.dsa.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimsAlgorithm_MST {

    public PrimsAlgorithm_MST(){}

    private int getMinimumSpanningTree(int[][][] adj, int n){

        PriorityQueue<int[]> que = new PriorityQueue<>(
                (a,b) -> Integer.compare(a[0],b[0])
        );

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int[] vis = new int[n];
        int sum = 0;

        que.add(new int[]{0, 0, -1});
        while(!que.isEmpty()){
            int[] t = que.poll();
            if(vis[t[1]] == 1)
                continue;

            vis[t[1]] = 1;
            sum += t[0];
            if(t[2] != -1)
                ans.add(new ArrayList<>(Arrays.asList(t[2], t[1])));

            for( int[] d : adj[t[1]]){
                if(vis[d[0]] != 1){
                    que.add(new int[]{d[1],d[0], t[1]});
                }
            }
        }
        System.out.println(ans);
        return sum;
    }

    public static void main(String[] args) {
        int[][][] adj = {{{1, 1}, {3, 4}}, {{0, 1}, {2, 2}}, {{1, 2}, {3, 3}}, {{0, 4}, {2, 3}}};
        int n = 4;
        PrimsAlgorithm_MST primsAlgorithmMst = new PrimsAlgorithm_MST();
        System.out.println(primsAlgorithmMst.getMinimumSpanningTree(adj, n));

    }
}
