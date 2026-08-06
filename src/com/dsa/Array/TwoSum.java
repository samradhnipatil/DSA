package com.dsa.Array;

import java.util.HashMap;

public class TwoSum {
    public TwoSum() {
        int[] arr = {2,6,5,8,11};
        sumTwoElements(arr, 14);
    }

    public void sumTwoElements(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int val = target - arr[i];
            if(map.containsKey(val)){
                System.out.println("2 Sum Elements : "+arr[i] +" "+ val);
                break;
            }
            else{
                map.put(arr[i], i);
                if(i == arr.length-1)
                    System.out.println("No Elements found!");
            }
        }
    }
}
