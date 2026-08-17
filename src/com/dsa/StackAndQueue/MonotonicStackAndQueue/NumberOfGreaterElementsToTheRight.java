package com.dsa.StackAndQueue.MonotonicStackAndQueue;
import java.util.*;

public class NumberOfGreaterElementsToTheRight {

    public static void main(String[] args) {
           int[] arr = {3,4,2,7,5,8,10,6};
           int[] que = {0,5};
           System.out.println(Arrays.toString(getNumberOfGreaterElementsToTheRight(arr, que)));
    }

    public static int[] getNumberOfGreaterElementsToTheRight (int[] arr, int[] que){
        int[] ans = new int[que.length];
        for(int i = 0; i < que.length; i++){
            for(int j = i; j < arr.length; j++){
                if(arr[j] > arr[que[i]]){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
