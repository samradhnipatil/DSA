package com.dsa.StackAndQueue;

import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        String p = "()()({}[]{{}})";
        System.out.println(isBalancedParenthesis(p));
    }

    public static boolean isBalancedParenthesis(String p){
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while( i < p.length()){
            char c = p.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else {
                    return false;
                }
            }
            else if(c == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                } else {
                    return false;
                }
            }
            else if(c == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                } else {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
