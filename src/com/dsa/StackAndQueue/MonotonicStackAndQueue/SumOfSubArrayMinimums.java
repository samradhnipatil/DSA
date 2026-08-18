package com.dsa.StackAndQueue.MonotonicStackAndQueue;
import java.util.*;

public class SumOfSubArrayMinimums {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};;
        System.out.println(getSumOfMinimums(arr));
    }

    public static int getSumOfMinimumsII(int[] arr) { // brute force
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i; j < arr.length ; j++){
                min = Math.min(min,arr[j]);
                sum += min;
            }
        }
        return sum;
    }

    public static long getSumOfMinimums(int[] arr) {  // optimal
        long sum = 0;
        int[] prev =  getPrevSmallerElementInd(arr);
        int[] next =  getNextSmallerElementInd(arr);

        for(int i =0; i < arr.length; i++){
            int l = i - prev[i];
            int r = next[i] - i;

            sum += ((long) l * r * arr[i]);
        }

        return sum;
    }

    public static int[] getNextSmallerElementInd(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            if(!stack.isEmpty()) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
            }
            if(!stack.isEmpty())
                ans[i] = stack.peek();
            else
                ans[i] = arr.length;
            stack.push(i);
        }
        return ans;
    }

    public static int[] getPrevSmallerElementInd(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(!stack.isEmpty()) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
            }
            if(!stack.isEmpty())
                ans[i] = stack.peek();
            else
                ans[i] = -1;
            stack.push(i);
        }
        return ans;
    }
}
