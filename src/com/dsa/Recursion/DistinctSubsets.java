package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DistinctSubsets {
    public DistinctSubsets() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);

        HashSet<ArrayList<Integer>> set = FindUniqueSubsets(arr);
        System.out.println(set.toString());
    }

    public HashSet<ArrayList<Integer>> FindUniqueSubsets(ArrayList<Integer> arr){
        HashSet<ArrayList<Integer>> sets = new HashSet<>();
        int n = arr.size();
        ArrayList<Integer> subArr = new ArrayList<>();
        Subset(-1,subArr, arr,n,sets);
        return sets;
    }

    public void Subset(int ind,ArrayList<Integer> subArray, ArrayList<Integer> arr,int n, HashSet<ArrayList<Integer>> sets){
        if(ind > n){
            return;
        }
        else{
            sets.add(subArray);
            if(ind == n-1)
                return;
            ind++;
        }
        ArrayList<Integer> subArr = new ArrayList<>(subArray);
        subArr.add(arr.get(ind));
        Subset(ind,subArr,arr,n,sets);
        Subset(ind,subArray, arr, n, sets);
    }
}
