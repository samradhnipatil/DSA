package com.dsa.Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CombinationSum {
    public CombinationSum() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(6);
        arr.add(7);
        ArrayList<ArrayList<Integer>> ans = Combination(arr,7);
        System.out.println(ans.toString());
    }

    public ArrayList<ArrayList<Integer>> Combination(ArrayList<Integer> arr, int target)
    {
        ArrayList<ArrayList<Integer>> finalArr = new ArrayList<ArrayList<Integer>>();
        FindCombination(0,arr,target,finalArr,new ArrayList<Integer>());
        return finalArr;
    }

    public void FindCombination(int index,ArrayList<Integer> arr, int target, ArrayList<ArrayList<Integer>> finalArr, ArrayList<Integer> temp){
        if(index == arr.size()){
            if(target == 0){
                finalArr.add(new ArrayList<>(temp));
            }
            return;
        }

        if(arr.get(index) <= target){
            temp.add(arr.get(index));
            FindCombination(index,arr, target - arr.get(index), finalArr,temp);
            temp.removeLast();
        }
        FindCombination(index+1, arr, target,finalArr,temp);
    }
}
