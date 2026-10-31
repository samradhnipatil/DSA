package com.dsa.Graph_DFS_BFS;

import java.util.*;

public class DisjointSet {

    private final ArrayList<Integer> rank = new ArrayList<>();
    private final ArrayList<Integer> parent = new ArrayList<>();
    private final ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(){}
    public DisjointSet( int n){
        for( int i = 0; i < n ; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    private int findTheUltimateParent(int u){
        if(parent.get(u) == u)
            return u;
        return parent.set(u, findTheUltimateParent(parent.get(u)));
    }

    private void unionByRank(int u, int v){
        int pu = findTheUltimateParent(u);
        int pv = findTheUltimateParent(v);

        if(pu == pv) return;
        if(rank.get(pu) < rank.get(pv))
            parent.set(pu, pv);
        else if(rank.get(pu) > rank.get(pv))
            parent.set(pv,pu);
        else{
            parent.set(pv,pu);
            rank.set(pu, rank.get(pu)+1);
        }
    }

    private void unionBySize(int u, int v){
        int pu = findTheUltimateParent(u);
        int pv = findTheUltimateParent(v);

        if(pu == pv) return;
        if(size.get(pu) < size.get(pv))
            parent.set(pu, pv);
        else if(size.get(pu) > size.get(pv))
            parent.set(pv,pu);
        else{
            parent.set(pv,pu);
            size.set(pu, size.get(pu)+size.get(pv));
        }
    }

    public static void main(String[] args) {
        int[][]  val = {{7}, {0, 1}, {1, 2}, {3, 4}, {5, 6},{4, 5}, {2, 6}};
        String[] cmd = {"DisjointSet","unionBySize","unionBySize","unionBySize","unionBySize","unionBySize","unionBySize"};
        DisjointSet disjointSet = new DisjointSet();
        for(int i = 0 ; i < cmd.length ; i++){
            switch (cmd[i]){
                case "DisjointSet" :
                    disjointSet = new DisjointSet(val[i][0]);
                    break;
                case "unionByRank":
                    disjointSet.unionByRank(val[i][0], val[i][1]);
                    break;
                case "unionBySize":
                    disjointSet.unionBySize(val[i][0], val[i][1]);
                    break;
                case "find":
                        System.out.println(disjointSet.findTheUltimateParent(val[i][0]) == disjointSet.findTheUltimateParent(val[i][1]) ? "True" : "False") ;
                default:
                    break;
            }
        }
    }
}
