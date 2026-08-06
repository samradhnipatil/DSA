package com.dsa.Array;

public class DuplicateElement {
    public DuplicateElement() {
        int[] arr = {1,2,3,4,1,5,7,6,8,9};
        // Brute force approach
        findDuplicateElementB(arr);
        //Optiomal
        findDuplicateElementO(arr);

    }

    public void findDuplicateElementB(int[] arr){
        int[] count = new int[arr.length-1];
        for(int i =0; i < arr.length ; i++){
            count[arr[i] -1]++;
        }
        for(int i =0; i< count.length ;i++){
            if(count[i] > 1)
                System.out.println("Duplicate Element {with using extra space} : "+ (i+1));
        }
    }

    public void findDuplicateElementO(int[] arr){
        int slow = arr[0];
        int fast = arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        while(slow!= fast);

        fast = arr[0];
        while(slow!= fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        System.out.println("Duplicate Element {without using extra space} : "+ slow);
    }
}
