package com.dsa.Graph_DFS_BFS;
import javax.management.ObjectName;
import java.util.*;

public class KahnsAlgo_topologicalSort {
    public KahnsAlgo_topologicalSort(){}

    private int[] getTopologicalSort(int[][] adj){
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[adj.length];

        for(int i = 0; i < adj.length;i++){
            for(int j : adj[i]){
                inDegree[j]++;
            }
        }

        for(int i = 0 ; i< inDegree.length; i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }
        int[] ans = new int[adj.length];
        int index = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans[index++] = curr;
            for(int i : adj[curr]){
                inDegree[i] = inDegree[i]-1;
                if(inDegree[i] == 0)
                    queue.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] adj =  {{},{},{3}, {1}, {0,1}, {0,2}};
        KahnsAlgo_topologicalSort kahnsAlgoTopologicalSort = new KahnsAlgo_topologicalSort();
        int[] ans = kahnsAlgoTopologicalSort.getTopologicalSort(adj);
        System.out.println(Arrays.toString(ans));
    }
}
