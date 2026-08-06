package com.dsa.Array;
import java.util.*;

public class mergeOverlappingInterval {
    public mergeOverlappingInterval(){

        int[][] arr1 = {{5,7},{4,6},{1,3},{8,10}};

        System.out.println(Arrays.deepToString(merge(arr1)));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] top = stack.peek();
            int[] temp = intervals[i];
            if(top[1] >= temp[0]){
                stack.pop();
                int[] ans = new int[2];
                ans[0]= top[0];
                ans[1] = Math.max(top[0], temp[1]);
                stack.push(ans);
            }
            else{
                stack.push(temp);
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }

}