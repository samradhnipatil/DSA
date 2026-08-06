package com.dsa.Array;

import java.util.HashMap;

public class ElementOccuringOnce {
    public ElementOccuringOnce() {
        int[] arr = {1,1,2,3,3,4,4};
        int unique = occurringOnce(arr);

        System.out.println("Unique element: " + unique);
    }

    public int occurringOnce(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int n = arr.length;
        while(i < n){
            if(map.containsKey(arr[i])){
                map.remove(arr[i]);
            }
            else{
                map.put(arr[i], i);
            }
            i++;
        }
        return map.keySet().iterator().next();
    }
}
