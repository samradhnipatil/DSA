package com.dsa.SortingAlgorithms;

public class ShellSort {
    public ShellSort() {
        int[] arr = {120,315,7,515,1,422};
        shell(arr);
    }

    public void shell(int[] arr){
        for(int gap = arr.length/2 ; gap >0 ;gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while ( j >= gap && arr[j - gap] > temp ) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
        for(int i = 0; i< arr.length ;i++){
            System.out.println(arr[i]);
        }
    }
}
