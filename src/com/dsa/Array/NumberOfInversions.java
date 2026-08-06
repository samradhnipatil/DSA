package com.dsa.Array;

public class NumberOfInversions {
    public NumberOfInversions() {
        int[] arr = {5,3,2,4,1};
        int count = mergeSort(arr, 0, arr.length -1);
        System.out.println(" Number of Inversions : " + count);
    }

    public int mergeSort(int[] arr, int low, int high){
        int count = 0;
        if(high - low < 2)
            return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr , mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public int merge(int[] arr , int low, int mid, int high){
        int count = 0;
        int[] temp = new int[arr.length];
        int index = 0;
        int i = low,j = mid+1;
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
               temp[index] = arr[i];
               i++;
               index++;
            }
            else{
                temp[index] = arr[j];
                j++;
                count += (mid - i) + 1;
                index++;
            }
        }

        while(i <= mid){
            temp[index++] = arr[i++];
        }
        while(j <= high){
            temp[index++] = arr[j++];
        }

        return count;
    }
}
