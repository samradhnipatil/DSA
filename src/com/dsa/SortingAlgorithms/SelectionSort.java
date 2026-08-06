package com.dsa.SortingAlgorithms;

public class SelectionSort {
    public SelectionSort() {
        int[] arr = {120,315,7,515,1,422};
        selection(arr);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void selection(int[] arr)
    {
        int unsortedPartition = arr.length;
        while(unsortedPartition > 1){
            int largest = 0;
            for(int i = 1; i < unsortedPartition; i++){
                if(arr[i] > arr[largest]){
                    largest = i;
                }
            }
            swap(arr,largest,unsortedPartition-1);

            unsortedPartition--;
        }

        for(int i = 0; i< arr.length ;i++){
            System.out.println(arr[i]);
        }
    }
}
