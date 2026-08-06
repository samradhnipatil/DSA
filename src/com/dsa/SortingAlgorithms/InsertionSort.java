package com.dsa.SortingAlgorithms;

public class InsertionSort {
    int[] arr = new int[] {120,315,7,515,1,422};
    public InsertionSort() {
        insertion(arr);
    }

    public void shift(int[] arr, int index){
        int temp = arr[index];
        while(index > 0 && temp < arr[index-1]){
            arr[index] = arr[index - 1];
            index--;
        }
        arr[index] = temp;
    }
    public void insertion(int[] arr){
        int unsortedPartition = arr.length;
        for(int i = 0; i < unsortedPartition -1;i++ ){
            if(arr[i] > arr[i+1]){
                shift(arr,i+1);
            }
        }
        for(int i = 0; i< arr.length ;i++){
            System.out.println(arr[i]);
        }
    }

}
