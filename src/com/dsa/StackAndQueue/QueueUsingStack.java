package com.dsa.StackAndQueue;

import java.util.LinkedList;
import java.util.Stack;

public class QueueUsingStack {

        public Stack<Integer> stack;
        public Stack<Integer> temp = new Stack<>();

        public void push(int n){
            // FIFO
            if(stack.isEmpty()){
                while(!temp.isEmpty()){
                    stack.push(temp.pop());
                }
            }
            stack.push(n);
        }

        public int pop(){
            // stack - LIFO
            // queue - FIFO
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            else if(stack.isEmpty() && !temp.isEmpty()) {
                return temp.pop();
            }
            else if(!stack.isEmpty() && temp.isEmpty()) {
                while(stack.size() != 1)
                    temp.push(stack.pop());
                return stack.pop();
            }
            return -1;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            else if(stack.isEmpty() && !temp.isEmpty()) {
                return temp.peek();
            }
            else if(!stack.isEmpty() && temp.isEmpty()) {
                while(!stack.isEmpty())
                    temp.push(stack.pop());
                return temp.peek();
            }
            return -1;
        }

        public boolean isEmpty() {
            return stack.isEmpty() && temp.isEmpty();
        }

}
