package com.dsa.StackAndQueue.MonotonicStackAndQueue;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] build = { 4,8,5,2,25 };
        System.out.println(calculateTrappedRainWater(build));
    }

    public static int calculateTrappedRainWater(int[] height){
        int water = 0;

        int[] preMax = new int[height.length];
        int[] suffMax = new int[height.length];
        preMax[0] = height[0];
        int pmax = preMax[0];
        for(int i = 1; i < height.length; i++){
            preMax[i] = Math.max(pmax,height[i]);
            pmax = preMax[i];
        }

        suffMax[height.length-1] = height[height.length-1];
        int smax = suffMax[height.length-1];
        for(int i = height.length-1; i >= 0; i--){
            suffMax[i] = Math.max(smax,height[i]);
            smax = suffMax[i];
        }

        for(int i = 0 ; i < height.length; i++){
            water += Math.min(preMax[i], suffMax[i]) - height[i];
        }
        return water;
    }
}
