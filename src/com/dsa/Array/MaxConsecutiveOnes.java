package com.dsa.Array;

public class MaxConsecutiveOnes {
    public MaxConsecutiveOnes() {
        int[] arr = { 1,1,1,0,0,1,1,1,1,0,5,1,1};
        int m = ConsecutiveONES(arr);
        System.out.println("Max Consecutive ONES : " + m);
    }

    public int ConsecutiveONES(int[] arr){
        int max = 0;
        int n = arr.length;
        int i = 0;
        int count = 0;
        while( i < n){
            if(arr[i] == 1){
                count++;
            }
            else{
                max = Math.max(max , count);
                count = 0;
            }
            i++;
        }
        return max;
    }
}
