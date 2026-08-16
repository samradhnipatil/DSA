package com.dsa.StackAndQueue.PrefixInfixPostfix;
import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "(a+(b*c))";
        System.out.println(toPostfix(infix));
    }

    public static String toPostfix(String infix){
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

        for(int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if(!map.containsKey(c)){ // any Alphabet
                ans.append(c);
            } else{
                if(c == ')'){
                    while(!stack.isEmpty() && stack.peek() != '('){
                        ans.append(stack.peek());
                        stack.pop();
                    }
                    stack.pop();
                } else if(c == '('){
                    stack.push(c);
                }
                else {
                    while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) {
                        ans.append(stack.peek());
                        stack.pop();
                    }
                    stack.push(c);
                }
            }
        }

        while(!stack.isEmpty()){
            ans.append(stack.peek());
            stack.pop();
        }
        return ans.toString();
    }
}
