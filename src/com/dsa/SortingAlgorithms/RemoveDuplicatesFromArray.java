package com.dsa.SortingAlgorithms;

public class RemoveDuplicatesFromArray {
    public RemoveDuplicatesFromArray() {
        int[] arr = {1,1,1,2,2,3,3,3,4,5,6,6};

        System.out.println("Unique elements");
        int endLoc = RemoveDuplicates(arr);
        for(int i = 0 ; i <= endLoc ; i++){
            System.out.print(arr[i] + ", ");
        }
    }

    public int RemoveDuplicates(int[] arr){
        int n = arr.length;
        int i = 0;
        int j = i+1;
        while(j < n){
            if( arr[i] == arr[j]){
                j++;
            }
            else{
                arr[i+1] = arr[j];
                j++;
                i++;
            }
        }
        return i;
    }
}
