package com.dsa.StackAndQueue.MonotonicStackAndQueue;

import java.util.Stack;

public class SumOfRangesInSubArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(getSumOfRangesInSubArray(arr));
    }

    public static int getSumOfRangesInSubArray(int[] arr){
        int[] prevSmall = getPrevSmallestElement(arr);
        int[] nextSmall = getNextSmallestElement(arr);
        int[] prevGreat = getPrevGreatestElement(arr);
        int[] nextGreat = getNextGreatestElement(arr);

        int s = 0;
        int g = 0;
        for(int i = 0; i < arr.length; i++){
            int ls = i - prevSmall[i];
            int rs = nextSmall[i] - i;
            int lg = i - prevGreat[i];
            int rg = nextGreat[i] - i;

            s = s + (ls * rs * arr[i]);
            g = g + (lg * rg * arr[i]);
        }
        return g-s;
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

    public static int[] getPrevGreatestElement(int[] arr){
        int i = 0 ;
        Stack<Integer> stack = new Stack<>();
        int[] prevGreat = new int[arr.length];
        while(i < arr.length){
            if(stack.isEmpty()){
                prevGreat[i] = -1;
            } else {
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
                if(!stack.isEmpty())
                    prevGreat[i] = stack.peek();
                else
                    prevGreat[i] = -1;
            }
            stack.push(i);
            i++;
        }
        return prevGreat;
    }

    public static int[] getNextGreatestElement(int[] arr){
        int i = arr.length-1 ;
        Stack<Integer> stack = new Stack<>();
        int[] nextGreat = new int[arr.length];
        while(i >= 0){
            if(stack.isEmpty()){
                nextGreat[i] = arr.length;
            } else {
                while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                    stack.pop();
                }
                if(!stack.isEmpty())
                    nextGreat[i] = stack.peek();
                else
                    nextGreat[i] = arr.length;
            }
            stack.push(i);
            i--;
        }
        return nextGreat;
    }

}
