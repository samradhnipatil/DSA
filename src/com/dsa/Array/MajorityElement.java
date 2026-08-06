package com.dsa.Array;

import java.util.HashMap;

public class MajorityElement {
    public MajorityElement() {
        int[] arr = {2,2,1,1,4,1,1};
        int majorEle = majorElement(arr);
        System.out.println("Major Element : "+ majorEle);

        // using moore's voting system
        int mooreEle = mooresElement(arr);
        System.out.println("Moore's Major Element : "+ mooreEle);
    }

    public int majorElement(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer > map = new HashMap<Integer, Integer>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                map.compute(j, (k, val) -> (val + 1));
                if(map.get(j) > n/2){
                    return j;
                }
            } else {
                map.put(j, 1);
            }
        }
        return 0;
    }

    public int mooresElement(int[] arr){
        int x = arr[0];
        int n = arr.length;
        int count = 1;
        int i = 1;
        while( i < n) {
            if (arr[i] == x)
                count++;
            else
                count--;
            if (count != 0)
                i++;
            else {
                x = arr[i + 1];
                count = 1;
                i = i + 2;
            }
        }
        if(count > 0)
            return x;
        else return 0;
    }
}
