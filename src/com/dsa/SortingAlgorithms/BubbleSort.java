package com.dsa.SortingAlgorithms;

public class BubbleSort {
    public BubbleSort() {
        var arr = new int[] {120,315,7,515,1,422};
        bubbleSort(arr);
    }

    public boolean swap(int[] arr, int i, int j){
        if(arr[i] > arr[j]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            return true;
        }
        return false;
    }

    public void bubbleSort(int[] arr){
        boolean flag = true;
        int unSortedPartition  = arr.length;
        while(flag && unSortedPartition > 0){
            for(int i = 0; i < unSortedPartition-1 ;i++){
              flag = swap(arr,i,i+1);
            }
            unSortedPartition--;
        }

        for(int i = 0; i< arr.length ;i++){
            System.out.println(arr[i]);
        }
    }
}
