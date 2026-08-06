package com.dsa.Array;
import java.io.*;
import java.util.*;
public class OverlappingSubInterval {
    public OverlappingSubInterval() {
        int[][] intervals = {{1,2},{2,5},{8,9},{2,4},{6,7},{9,11},{8,10},{15,18},{16,17}};
        findTheInterval(intervals);
    }

    public void findTheInterval(int[][] intervals){
        sortByColumn(intervals, 0);
        int[][] finalIntervals = new int[4][2];
        int start = intervals[0][0];
        int end = intervals[0][1] ;
        int finalIndex = 0;
        for(int i = 1; i< intervals.length ;i++){
            if(start > intervals[i][0] && end >= intervals[i][0])
                start = intervals[i][0];
            if(end >= intervals[i][0] && end < intervals[i][1])
                end = intervals[i][1];
            if(start < intervals[i][0] && end < intervals[i][1] ){
                int[] sunInter = {start, end};
                finalIntervals[finalIndex++] = sunInter;
                start = intervals[i][0];
                end = intervals[i][1];
            }
            int[] sunInter = {start, end};
            finalIntervals[finalIndex] = sunInter;
        }
        System.out.println(Arrays.deepToString(finalIntervals));
    }

    public void sortByColumn(int[][] m , int c){
        Arrays.sort(m, Comparator.comparingInt(x -> x[c]));
    }
}
