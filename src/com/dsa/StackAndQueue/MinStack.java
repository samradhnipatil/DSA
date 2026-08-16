package com.dsa.StackAndQueue;

public class MinStack {

    public stackStruct[] stack = new stackStruct[0];
    public int pointer = -1;
    public static class stackStruct {
        public int num;
        public int min;

        public stackStruct(int num, int min){
            this.num = num ;
            this.min = min;
        }
    }
    public MinStack() {

    }

    public void push(int num) {
        if(pointer == stack.length -1){
            System.out.println("Stack is Full");
            return;
        }
        int min;
        if(isEmpty())
            min = num;
        else {
            min = stack[pointer].min;
            if (stack[pointer].min > num) {
                min = num;
            }
        }
        pointer++;
        stack[pointer] = new stackStruct(num, min);
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }

        int num = stack[pointer].num;
        pointer--;
        return num;
    }

    public int peek() {
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }

        return stack[pointer].num;
    }

    public boolean isEmpty() {
        return pointer == -1;
    }

    public int getMin() {
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[pointer].min;
    }
}
