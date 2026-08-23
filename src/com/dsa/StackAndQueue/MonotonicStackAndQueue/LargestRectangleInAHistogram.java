package com.dsa.StackAndQueue.MonotonicStackAndQueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInAHistogram {

    public static void main(String[] args) {
        int[] h = {2, 1, 5, 6, 2, 3 };
        System.out.println(getMaximumArea(h));
        System.out.println(getMaximumAreaII(h));
    }

    public static int getMaximumArea(int[] h) {
        int maxArea = 0;
        int[] prevSmall = getPrevSmallestElement(h);
        int[] nextSmall = getNextSmallestElement(h);

        for(int i = 0; i < h.length; i++){
            maxArea = Math.max(maxArea, (nextSmall[i] - prevSmall[i] - 1) * h[i]);
        }
        return maxArea;
    }

    public static int[] getPrevSmallestElement(int[] arr){
        int i = 0 ;
        Stack<Integer> stack = new Stack<>();
        int[] prevSmall = new int[arr.length];
        while(i < arr.length){
            if(stack.isEmpty()){
                prevSmall[i] = -1;
            } else {
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                    stack.pop();
                }
                if(!stack.isEmpty())
                    prevSmall[i] = stack.peek();
                else
                    prevSmall[i] = -1;
            }
            stack.push(i);
            i++;
        }
        return prevSmall;
    }

    public static int[] getNextSmallestElement(int[] arr){
        int i = arr.length -1 ;
        Stack<Integer> stack = new Stack<>();
        int[] nextSmall = new int[arr.length];
        while(i >= 0){
            if(stack.isEmpty()){
                nextSmall[i] = arr.length;
            } else {
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                    stack.pop();
                }
                if(!stack.isEmpty())
                    nextSmall[i] = stack.peek();
                else
                    nextSmall[i] = arr.length;
            }
            stack.push(i);
            i--;
        }
        return nextSmall;
    }

    public static int getMaximumAreaII(int[] h){
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < h.length; i++){
            int l = i;
            while(!stack.isEmpty() && h[stack.peek()] >= h[i]){
                l = stack.pop();
            }
            stack.push(i);
            int j = i+1;
            int r = i;
            while( j < h.length && h[j] >= h[i]) {
                r = j;
                j++;
            }

            sum = Math.max(sum , (r - l+1) * h[i]);
        }
        return sum;
    }

}
