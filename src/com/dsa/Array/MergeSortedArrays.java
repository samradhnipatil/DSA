package com.dsa.Array;

import java.util.Arrays;

public class MergeSortedArrays {
    int[] arr1 = {0,5,7,9};
    int[] arr2 = {1,2,3,4,6,8};

    public MergeSortedArrays() {

        // Brute force Approach --> With using extra space
        mergeTwoArraysB(arr1,arr2);
        // optimal Approach --> Without using extra space
        mergeTwoArraysO(arr1,arr2);
    }

    public void mergeTwoArraysB(int[] arr1 , int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int[] arr = new int[m+n];
        int i = 0;
        int j = 0;
        int sort = 0;
        while(i < m && j < n){
            if(arr1[i] < arr2[j])
                arr[sort++] = arr1[i++];
            else
                arr[sort++] = arr2[j++];
        }
        while(i < m)
            arr[sort++] = arr1[i++];
        while(j < n)
            arr[sort++] = arr2[j++];

        int index = 0;
        while(index < sort){
            if(index < m) {
                arr1[index] = arr[index];
                index++;
            }
            else{
                arr2[index-m] = arr[index];
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public void mergeTwoArraysO(int[] arr1 , int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int i = m-1;
        int j = 0;
        while(i >= 0 && j < n){
            if(arr1[i] > arr2[j]) {
                swap(i, j);
                i--;
                j++;
            }
            else
                break;
        }
        // sort 2 arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public void swap(int i, int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
}
