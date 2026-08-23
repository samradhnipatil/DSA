package com.dsa.StackAndQueue.MonotonicStackAndQueue;

import java.util.Arrays;

import static com.dsa.StackAndQueue.MonotonicStackAndQueue.LargestRectangleInAHistogram.getMaximumArea;
import static com.dsa.StackAndQueue.MonotonicStackAndQueue.LargestRectangleInAHistogram.getMaximumAreaII;

public class MaximumRectangles {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(getMaximumRectangle(arr));
    }

    public static int getMaximumRectangle(int[][] arr) {
        int max = 0;
        int[] temp = new int[arr[0].length];
        Arrays.fill(temp, 0);
        for(int i = 0; i < arr.length; i++){
            for(int t = 0 ;t < arr[0].length;t++) {
                temp[t] = arr[i][t] == 0 ? 0 : (arr[i][t] + temp[t]);
            }
            max = Math.max( max, getMaximumAreaII(temp));
        }
        return max;
    }
}
