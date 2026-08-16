package com.dsa.StackAndQueue.PrefixInfixPostfix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrefixToInfix {

    public static void main(String[] args) {
        String pref = "^a*bc";
        System.out.println(convertToInfix(pref));
    }

    public static String convertToInfix(String prefix){

        Stack<String> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);

        int i = 0;
        StringBuilder str = new StringBuilder(prefix);
        str.reverse();

        while( i < str.length()){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                stack.push(Character.toString(c));
            }
            else {
                if(stack.size() >= 2){
                    String fir = stack.peek();
                    stack.pop();
                    String sec = stack.peek();
                    stack.pop();
                    stack.push("("+ fir + c + sec + ")");
                }
            }
            i++;
        }

        StringBuilder ans = new StringBuilder(stack.peek());
        return ans.toString();
    }
}
