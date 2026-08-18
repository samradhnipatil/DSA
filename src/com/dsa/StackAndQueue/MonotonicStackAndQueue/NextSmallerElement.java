package com.dsa.StackAndQueue.MonotonicStackAndQueue;

import java.util.*;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {1,4,6,7,3,7,8,1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(getNextSmallerElement(arr)));
    }

    public static int[] getNextSmallerElement(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            if(!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
            }
            if(!stack.isEmpty())
                ans[i] = stack.peek();
            else
                ans[i] = -1;
            stack.push(arr[i]);
        }
        return ans;
    }
}
