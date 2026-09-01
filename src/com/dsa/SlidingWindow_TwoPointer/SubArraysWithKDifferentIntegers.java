package com.dsa.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class SubArraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 4 };
        int k = 3;
        System.out.println(getGoodSubArraysWithKElement(arr, k) - getGoodSubArraysWithKElement(arr, k-1));
    }

    public static int getGoodSubArraysWithKElement(int[] arr, int k) {
        if( k < 0)
            return 0;
        int i = 0;
        int j = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while( j < arr.length) {
            if(map.containsKey(arr[j])) {
                map.computeIfPresent(arr[j], (c,v) -> v+1);
            } else {
                if(map.size() == k) {
                    while(map.size() >= k && map.containsKey(arr[i]) && map.get(arr[i]) > 0){
                        map.computeIfPresent(arr[i], (c, v) -> v-1);
                        if(map.get(arr[i]) == 0)
                            map.remove(arr[i]);
                        i++;
                    }
                }
                map.put(arr[j], 1);
            }
            count += j-i+1;
            j++;
        }
        return count;
    }
}
