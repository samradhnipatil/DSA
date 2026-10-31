package com.dsa.Graph_DFS_BFS;

public class NumberOfOperationsToMakeNetworkConnected {

    public final int[] rank;
    public final int[] parent;


    public NumberOfOperationsToMakeNetworkConnected(int n){
        rank = new int[n];
        parent = new int[n];

        for(int i = 0; i < n; i++){
            rank[i] = 0;
            parent[i] = i;
        }
    }

    private int getParent(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = getParent(parent[u]);
    }

    private int getNumberOfOpsToConnectNetwork(int[][] edges, int n){
        int extraEdge = 0;
        int island = 0;
        for(int[] edge : edges) {
            int pu =  getParent(edge[0]);
            int pv =  getParent(edge[1]);

            if(pu != pv) {
                if(rank[pu] > rank[pv])
                    parent[pv] = pu;
                else if(rank[pu] < rank[pv])
                    parent[pu] = pv;
                else {
                    island++;
                    parent[pv] = pu;
                    rank[pu]++;
                }
            }
            else {
                extraEdge++;
            }
        }
        if(extraEdge == 0 && island == 1 && edges.length == n-1)
            return 0;
        else if(extraEdge != 0 && extraEdge >= (island-1))
            return island-1;
        else
            return -1;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1}};
        int n = 4;
        NumberOfOperationsToMakeNetworkConnected ops = new NumberOfOperationsToMakeNetworkConnected(n);
        System.out.println(ops.getNumberOfOpsToConnectNetwork(edges, n));
    }
}
