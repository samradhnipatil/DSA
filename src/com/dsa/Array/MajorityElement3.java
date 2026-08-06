package com.dsa.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement3 {
    public MajorityElement3() {
        int[] arr = {1,1,1,3,4,2,2,2};
        ArrayList<Integer> ls = majorityElement(arr);
    }

    public ArrayList<Integer> majorityElement(int[] arr){
        int n = arr.length;
        int x = n/2;
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ls = new ArrayList<>();
        int start = 0;
        for(int i = 0; i< n;i++){
            if(map.containsKey(arr[i])) {
                if(start == arr[i]) {
                    map.compute(arr[i], (k, val) -> (val + 1));
                    System.out.println("added ele: " + arr[i] +" "+ map.get(arr[i]));
                }
            }
            else{
                start = arr[i];
                map.put(arr[i], 1);
                System.out.println("added ele: " + arr[i] +" "+i);
            }
            if(map.get(arr[i]) > x){
                ls.add(arr[i]);
                System.out.println("Maj ele: " + arr[i]);
            }
            if(ls.size() == 2)
                break;
        }
        return ls;
    }
}
