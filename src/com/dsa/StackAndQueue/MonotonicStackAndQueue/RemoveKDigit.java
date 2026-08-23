package com.dsa.StackAndQueue.MonotonicStackAndQueue;

import java.util.Stack;

public class RemoveKDigit {

    public static void main(String[] args) {
        String n = "654321";
        int k = 2;
        System.out.println(getMinNumber(n, k));
    }

    public static int getMinNumber(String n, int k){
        if(n.length() <= k)
            return 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();

        while(i < n.length()){
            int num = Integer.parseInt(Character.toString(n.charAt(i)));
            while(!stack.isEmpty() && stack.peek() > num && k >0){
                stack.pop();
                k--;
            }
            if(stack.size() < (n.length() - k))
                stack.push(num);
            i++;
        }
        String ans = "";
        while(!stack.isEmpty()) {
            ans = stack.pop().toString() + ans;
        }
        return Integer.parseInt(ans);
    }


}
