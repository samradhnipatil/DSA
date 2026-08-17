package com.dsa.StackAndQueue.MonotonicStackAndQueue;
import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        System.out.println(Arrays.toString(getNextGreaterElement(arr)));
    }

    public static int[] getNextGreaterElement(int[] arr){
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
        return ans;
    }
}
