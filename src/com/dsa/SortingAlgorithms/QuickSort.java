package com.dsa.SortingAlgorithms;

public class QuickSort {
    public QuickSort() {
        int[] arr = {120,315,7,515,1,422};
        quick(arr,0,arr.length-1);

        for(int i = 0; i< arr.length ;i++){
            System.out.println(arr[i]);
        }
    }

    public void quick(int[] array, int min, int max){
        if(max > min) {
            int pivotIndex = partictionArray(array,min,max);
            quick(array,min, pivotIndex-1);
            quick(array, pivotIndex+1,max);
        }
    }
    public int partictionArray(int[] array, int min, int max){
        int pivot = min;
        int i = min;
        int j = max;
        while(i < j){
            while (array[i] <= array[pivot] && i <= max-1)
                i++;
            while(array[j] > array[pivot] && j >= min+1)
                j--;
            if(i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[j];
        array[j] = temp;
        return j;
    }
}
