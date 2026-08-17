package com.dsa.StackAndQueue.MonotonicStackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 7, 6, 0};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(getNextGreaterElementII(arr)));
    }

    public static int[] getNextGreaterElementII(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i = arr.length-1; i >= 0; i--){
            if(!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if(!stack.isEmpty())
                ans[i] = stack.peek();
            else
                ans[i] = -1;
            stack.push(arr[i]);
        }

        for(int i = ans.length-1; i >= 0; i--){
            if(ans[i] == -1){
                while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if(!stack.isEmpty())
                    ans[i] =  stack.peek();
            }
        }
        return ans;

    }
}