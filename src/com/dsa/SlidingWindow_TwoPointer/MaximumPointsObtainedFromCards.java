package com.dsa.SlidingWindow_TwoPointer;

public class MaximumPointsObtainedFromCards {

    public static void main(String[] args) {
        int[] arr = { 9, 10, 1, 2, 3, 5 };
        int k = 5;
        System.out.println(getMaximumPointsObtainedFromCards(arr, k));
    }

    public static int getMaximumPointsObtainedFromCards(int[] arr, int k) {
        int s = -1;
        int e = arr.length;
        int sum = 0;

        while(s < e) {
            if(((arr.length -e)+(s+1)) == k) {
                return sum;
            }
            if(arr[s+1] > arr[e-1]){
                sum += arr[s+1];
                s++;
            } else {
                sum += arr[e-1];
                e--;
            }
        }
        return sum;
    }
}
