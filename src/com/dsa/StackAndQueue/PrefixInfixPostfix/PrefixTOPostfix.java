package com.dsa.StackAndQueue.PrefixInfixPostfix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrefixTOPostfix {

    public static void main(String[] args) {
        String ans = "^a*bc";
        System.out.println(toPostfix(ans));
    }

    public static String toPostfix(String s){
        String ans = "";
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                ans = ans + c;
            }else {
                if(!stack.isEmpty() && map.get(c) >= map.get(stack.peek())){
                    ans = ans + stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
            i++;
        }
        while(!stack.isEmpty()){
            ans = ans + stack.peek();
            stack.pop();
        }
        return ans;
    }
}
