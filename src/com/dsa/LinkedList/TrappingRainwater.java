package com.dsa.LinkedList;

public class TrappingRainwater {
    public TrappingRainwater() {
        int[] arr = {3,2,0,2,3,1,4,2,1,4,2};
        int water = TrappedWater(arr);

        System.out.println("Water Trapped : " + water);
    }

    public int TrappedWater(int[] array){
        if(array.length == 0)
            return 0;

        int i = 0;
        int j = array.length - 1;
        int leftMax = array[i];
        int rightMax = array[j];
        int count = 0;
        while(i <= j){
            if(leftMax < rightMax){
                if(array[i] < leftMax){
                    count += (leftMax - array[i]);
                }
                else{
                    leftMax = Math.max(leftMax,array[i]);
                }
                i++;
            }
            else{
                if(array[j] < rightMax){
                    count += (rightMax - array[j]);
                }
                else{
                    rightMax = Math.max(rightMax,array[j]);
                }
                j--;
            }
        }
        return count;
    }
}
