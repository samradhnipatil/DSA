package com.dsa.StackAndQueue;

public class StackUsingArray {

    public static int pointer = -1;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String[] cmd = {"ArrayStack", "push", "push","top","pop","pop", "isEmpty"};
        int[] arr = {0, 5, 6,0,0,0, 0};
        int[] stack = new int[0];
        for(int i = 0; i < cmd.length;i++){
            if(cmd[i].equals("ArrayStack"))
                stack = new int[10];
            else if(cmd[i].equals("push"))
                push(arr[i], stack);
            else if(cmd[i].equals("pop"))
                System.out.println("popped element : "+ pop( stack));
            else if(cmd[i].equals("top"))
                System.out.println("Top element : "+top( stack));
            else if(cmd[i].equals("isEmpty"))
                System.out.println("Is Stack empty: "+isEmpty(pointer));
        }

    }

    public static void push(int num, int[] stack){
        if(pointer == stack.length){
            System.out.println("Stack is full!");
            return;
        }
        if(pointer == -1)
            pointer=0;
        stack[pointer] = num;
        pointer++;
    }

    public static int pop(int[] stack){
        if(isEmpty(pointer)){
            System.out.println("Stack is empty");
            return -1;
        }
        pointer--;
        return stack[pointer];
    }

    public static int top(int[] stack){
        if(isEmpty(pointer)){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[pointer-1];
    }

    public static boolean isEmpty(int pointer){
        return (pointer == 0);
    }
}
