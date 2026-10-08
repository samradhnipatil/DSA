package com.dsa.Graph_DFS_BFS;

import java.util.*;

public class CourseSchedule_II {
    public CourseSchedule_II(){}

    // Topological Sort / Kahn's Algorithm

    private int[] checkIfTheCourseCanBeCompleted(int[][] tasks, int v){
        int[] inDegree = new int[v];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < tasks.length; i++){
            inDegree[tasks[i][0]]++;
        }

        for(int i = 0; i< v; i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int t = queue.poll();
            ans.add(t);
            for(int[] i : tasks){
                if(i[1] == t) {
                    inDegree[i[0]] = inDegree[i[0]] - 1;
                    if(inDegree[i[0]] == 0)
                        queue.add(i[0]);
                }
            }
        }
        return ans.size() == v ? ans.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
    public static void main(String[] args) {
        int[][] arr = {{1,0},{2,1},{3,2}};
        int v = 4;

        CourseSchedule_II courseScheduleII = new CourseSchedule_II();
        System.out.println(Arrays.toString(courseScheduleII.checkIfTheCourseCanBeCompleted(arr, v)));
    }
}
