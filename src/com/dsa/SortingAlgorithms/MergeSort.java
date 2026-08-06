package com.dsa.SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public MergeSort() {
        int[] array = new int[] {5,2,6,9,1,3};
        mergeSort(array,0,array.length);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
    public void mergeSort(int[] array, int start , int end){
        //System.out.println(start +", "+ end);
        if(end-start < 2)
            return;
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid,end);
        merge(array,start,mid,end);
    }

    public void merge(int[] array,int start, int mid, int end){
        if(array[mid-1] <= array[mid])
            return;
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end-start];
        while(i<mid && j<end){
            tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i,array, start+tempIndex, mid-i);

        System.arraycopy(tempArray, 0, array, start, tempIndex);

    }
}
