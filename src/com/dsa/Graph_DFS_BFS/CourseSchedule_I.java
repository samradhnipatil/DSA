package com.dsa.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_I {
    public CourseSchedule_I(){}

    // Topological Sort / Kahn's Algorithm

    private boolean checkIfTheCourseCanBeCompleted(int[][] tasks, int v){
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
        return ans.size() == v;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,0}};
        int v = 2;

        CourseSchedule_I courseScheduleI = new CourseSchedule_I();
        System.out.println(courseScheduleI.checkIfTheCourseCanBeCompleted(arr, v) ? "Tasks completed" : "Task schedule is not possible");
    }
}
