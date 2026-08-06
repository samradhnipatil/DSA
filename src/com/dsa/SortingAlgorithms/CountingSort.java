package com.dsa.SortingAlgorithms;

public class CountingSort {
    public CountingSort() {
    }

    public static void countSort(int[] array, int min, int max){
        int n = array.length ;
        int[] countingArray = new int[(max - min) + 1];
        for(int i = 0; i < countingArray.length; i++) {
            countingArray[i] = 0;
        }
        for(int i = 0;i< n; i++){
            countingArray[array[i]-min]++;
        }
        System.out.println("countingArray");
        for(int i = 0;i< countingArray.length; i++){
            System.out.println(countingArray[i]);
        }

        int j = 0;
        for(int i = 0;i< countingArray.length; i++){
            while(countingArray[i] > 0 ){
                array[j++] = i + min;
                countingArray[i]--;
            }
        }
    }
}
