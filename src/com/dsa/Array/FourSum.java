package com.dsa.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FourSum {
    public FourSum() {
//        int[] arr = {1,1,1,2,2,2,3,3,3,4,4,4,5,5};
        int[] arr = {1,2,-1,-2,2,0,-1};
        fourSumElement(arr, 0);
        fourSumElementWithoutHash(arr, 0);
    }

    public void fourSumElement(int[] arr, int target){
        int n = arr.length;
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0;i < n ; i++){
            for(int j = i+1; j < n ; j++){
                if(arr[j] == arr[i])
                    continue;
                for(int k = j+1; k<n;k++){
                    if(arr[j] == arr[k])
                        continue;
                    int val =target-(arr[i] + arr[j] + arr[k]);
                    if(map.contains(val)){
                        System.out.println("Four SUM elements : "+arr[i]+" "+arr[j]+" "+arr[k]+" "+val);
                        return;
                    }
                    else{
                        map.add(arr[k]);
                    }
                }
            }
            if(i == n-1){
                System.out.println("No Elements found");
                return;
            }
        }
    }

    public void fourSumElementWithoutHash(int[] arr, int target){
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i< n; i++){
            for(int j = i+1; j < n ;j++){
                for(int k = n-1; k>j+1 ; k--){
                    int val = target - (arr[i] + arr[j] + arr[k]);
                    if( val > k)
                        continue;
                    int third = arr[k];
                }
            }
        }
    }

}
