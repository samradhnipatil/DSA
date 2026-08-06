package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPermutation {
    public AllPermutation() {
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> ans = FindAllPermutations(arr);
        System.out.println(ans.toString());
    }

    public ArrayList<ArrayList<Integer>> FindAllPermutations(int[] arr){
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
         GetPermutations(0,arr, ans);
         return ans;
    }

    public void GetPermutations(int index, int[] arr, ArrayList<ArrayList<Integer>> ans){
        if(index == arr.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i = 0 ; i < arr.length; i++){
                ds.add(arr[i]);
            }
            ans.add(ds);
            return;
        }
        for(int i = index; i < arr.length; i++){
            swap(arr, i, index);
            GetPermutations(i+1, arr,ans);
            swap(arr, i, index);
        }
    }

    public void swap(int[] arr, int i, int  j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
