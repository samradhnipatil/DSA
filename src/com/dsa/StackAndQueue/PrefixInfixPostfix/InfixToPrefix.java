package com.dsa.StackAndQueue.PrefixInfixPostfix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args) {
        String infix = "((a-(b/c))*((a/k)-l))";
        System.out.println(toPrefix(infix));
    }

    public static String toPrefix(String infix){
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);
        map.put('(', 0);
        map.put(')', 0);
        int i = 0;
        StringBuilder str = new StringBuilder();
        for(int j = infix.length() -1 ; j >= 0; j--){
            if(infix.charAt(j) == '(')
                str.append(')');
            else if(infix.charAt(j) == ')')
                str.append('(');
            else
                str.append(infix.charAt(j));
        }
        while(i < str.length()) {
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                ans.append(c);
            }
            else{
                if(c == '('){
                    stack.push(c);
                }
                else if( c == ')'){
                    while(!stack.isEmpty() && stack.peek() != '('){
                        ans.append(stack.peek());
                        stack.pop();
                    }
                    stack.pop();
                }
                else {
                    while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) {
                        ans.append(stack.peek());
                        stack.pop();
                    }
                    stack.push(c);
                }
            }
            i++;
        }

        while(!stack.isEmpty()){
            ans.append(stack.peek());
            stack.pop();
        }
        return ans.reverse().toString();
    }
}
