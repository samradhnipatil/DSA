package com.dsa.StackAndQueue;

import java.util.LinkedList;
import java.util.Stack;

public class Executor {

    public static void main(String[] args) {
//        String[] cmd = {"StackQueue", "push", "push","pop","peek","pop","isEmpty"};
//        int[] arr = {0,4,8,0,0,0,0};
//
//        QueueUsingStack qs = new QueueUsingStack();
//
//        for(int i = 0; i < cmd.length;i++){
//            switch (cmd[i]) {
//                case "StackQueue" -> qs.stack = new Stack<>();
//                case "push" ->  qs.push(arr[i]);
//                case "pop" -> System.out.println("Popped element : " + qs.pop());
//                case "peek" -> System.out.println("Peeked element : " + qs.peek());
//                case "isEmpty" -> System.out.println("Is Queue empty: " +  qs.isEmpty());
//            }
//        }
//
//        String[] cmd2 = {"QueueStack", "push", "push","pop","top", "isEmpty"};
//        int[] arr2 = {0,4,8,0,0,0};
//
//        StackUsingQueue sq = new StackUsingQueue();
//
//        for(int i = 0; i < cmd2.length;i++){
//            switch (cmd2[i]) {
//                case "QueueStack" ->sq.queueStack = new LinkedList<>();
//                case "push" -> sq.push(arr2[i]);
//                case "pop" -> System.out.println("popped element : " + sq.pop());
//                case "top" -> System.out.println("Top element : " + sq.peek());
//                case "isEmpty" -> System.out.println("Is Stack empty: " + sq.isEmpty());
//            }
//        }
//
//        String[] cmd3 = {"push", "push","pop","peek","pop","isEmpty"};
//        int[] arr3 = {4,8,0,0,0,0};
//
//        StackUsingLinkedList sll = new StackUsingLinkedList();
//        for(int i = 0; i < cmd3.length;i++){
//            switch (cmd3[i]) {
//                case "push" ->  sll.push(arr3[i]);
//                case "pop" -> System.out.println("Popped element : " + sll.pop());
//                case "peek" -> System.out.println("Peeked element : " + sll.peek());
//                case "isEmpty" -> System.out.println("Is Queue empty: " + sll.isEmpty());
//            }
//        }

//        String[] cmd4 = {"push", "push","pop","peek","pop","isEmpty"};
//        int[] arr4 = {4,8,0,0,0,0};
//
//        QueueUsingLinkedList qll = new QueueUsingLinkedList();
//        for(int i = 0; i < cmd4.length;i++){
//            switch (cmd4[i]) {
//                case "push" ->  qll.push(arr4[i]);
//                case "pop" -> System.out.println("Popped element : " + qll.pop());
//                case "peek" -> System.out.println("Peeked element : " + qll.peek());
//                case "isEmpty" -> System.out.println("Is Queue empty: " + qll.isEmpty());
//            }
//        }

        String[] cmd5 = {"MinStack", "push", "push","push","getMin","pop","top","getMin"};
        int[] arr5 = {0,-2,0,-3,0,0,0,0};

        MinStack ms = new MinStack();
        for(int i = 0; i < cmd5.length;i++){
            switch (cmd5[i]) {
                case "MinStack" ->  ms.stack = new MinStack.stackStruct[10];
                case "push" ->  ms.push(arr5[i]);
                case "pop" -> System.out.println("Popped element : " + ms.pop());
                case "top" -> System.out.println("Peeked element : " + ms.peek());
                case "getMin" -> System.out.println("Minimum element : " + ms.getMin());
            }
        }
    }
}
