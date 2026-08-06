package com.dsa.BinarySearch;

import com.dsa.GreedyApproach.JobSequensing;
import com.dsa.Main;

import java.util.Arrays;
import java.util.Comparator;

public class MatrixMedian {
    public MatrixMedian() {
        int[][] mat = {{1, 4, 9}, {2, 5, 6}, {3, 7, 8}};
        int median = FindMedian(mat,mat.length, mat[0].length);
        System.out.println(" Median : "+ median);
    }

    public int FindMedian(int[][] mat , int n, int m){
        n = mat.length;
        m = mat[0].length;
        int low = 0;
        int high = 0;

        for(int i = 0 ; i < n ;i++){
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m-1]);
        }
        int req = (low + high)/2;
        while(low <= high){
            int mid = ( high + low)/ 2;
            int smallerCount = CountSmaller(mid, mat, n,m);
            if(smallerCount <= req)
                low = mid +1;
            else
                high = mid -1;

        }
        return low;
    }

    public int CountSmaller(int num , int[][] mat,int n, int m){
        int c= 0;
        for(int i = 0; i < n ; i++){
            c += UpperBound(mat[i], num);
        }
        return c;
    }
    public int UpperBound(int[] mat, int num){
        int low = 0;
        int high = mat.length - 1;
        int ans = mat.length;
        while(low <= high){
            int mid = (high + low) /2;
            if(mat[mid] > num){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return  ans;
    }
}
