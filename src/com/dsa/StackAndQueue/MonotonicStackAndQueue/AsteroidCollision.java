package com.dsa.StackAndQueue.MonotonicStackAndQueue;
import java.util.*;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] ast = { 5, 10, -5, -10, 8, -8, -3, 12 };
        System.out.println(Arrays.toString(getFinalAsteroidCollision(ast)));
    }

    public static int[] getFinalAsteroidCollision(int[] ast) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < ast.length) {
            if(stack.isEmpty() || ( stack.peek() > 0 && ast[i] > 0) || ( stack.peek() < 0 && ast[i] < 0)){
                stack.push(ast[i]);
                i++;
            }
            else {
                if( !stack.isEmpty() && (Math.abs(stack.peek()) == Math.abs(ast[i]))){
                    stack.pop();
                    i++;
                }
                else if(!stack.isEmpty() && (Math.abs(stack.peek()) < Math.abs(ast[i]))){
                    stack.pop();
                }
                else {
                    i++;
                }
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
