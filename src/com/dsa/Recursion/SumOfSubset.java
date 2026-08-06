package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfSubset {
    public SumOfSubset() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);

        ArrayList<Integer> sum = FindSumOfSubset(arr);
        System.out.println(sum.toString());
    }

    public ArrayList<Integer> FindSumOfSubset(ArrayList<Integer> arr){
        ArrayList<Integer> sum = new ArrayList<>();
        CalculateSum(0,0,arr, arr.size(),sum);
        return sum;
    }

    public void CalculateSum(int ind , int sum, ArrayList<Integer> arr,int n, ArrayList<Integer> sumSub){
        if(ind == n){
            sumSub.add(sum);
            return;
        }

        CalculateSum(ind + 1,sum + arr.get(ind), arr,n, sumSub);
        CalculateSum(ind + 1,sum, arr,n, sumSub);
    }
}
