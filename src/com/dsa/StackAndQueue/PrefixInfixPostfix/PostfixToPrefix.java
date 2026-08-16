package com.dsa.StackAndQueue.PrefixInfixPostfix;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PostfixToPrefix {

    public static void main(String[] args) {
        String s = "abc*+d-";
        System.out.println(toPrefix(s));
    }

    public static String toPrefix(String s) {
        int i = 0;
        Stack<String> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);

        while(i < s.length()){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                stack.push(Character.toString(c));
            }
            else{
                if(stack.size() >= 2){
                    String fir = stack.pop();
                    String sec = stack.pop();
                    String temp = c + sec + fir;
                    stack.push(temp);
                }
            }
            i++;
        }

        StringBuilder ans = new StringBuilder(stack.peek());
        return ans.toString();
    }
}
