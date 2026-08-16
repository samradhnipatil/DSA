package com.dsa.StackAndQueue.PrefixInfixPostfix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PostfixToInfix {

    public static void main(String[] args) {
        String s = "abc*+";
        System.out.println(toInfix(s));
    }

    public static String toInfix(String s) {
        int i = 0;
        Stack<String> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);

        while(i < s.length()) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                stack.push(Character.toString(c));
            }
            else {
                if(stack.size() >= 2) {
                    String fir = stack.pop();
                    String sec = stack.pop();
                    String temp = "(" + sec + c + fir + ")";
                    stack.push(temp);
                }
            }
            i++;
        }
        return stack.pop();
    }
}
