package com.dsa.StackAndQueue;
import java.util.*;

public class StackUsingQueue {

    public Queue<Integer> queueStack;
    public Queue<Integer> temp = new LinkedList<>();

    public void push(int num) {
        if (temp.isEmpty()) {
            queueStack.add(num);
        } else {
            temp.add(num);
        }
    }

    public int pop() {
        if (!queueStack.isEmpty()) {
            while (queueStack.size() != 1) {
                temp.add(queueStack.poll());
            }
            return queueStack.poll();
        } else if (!temp.isEmpty()) {
            while (temp.size() != 1) {
                queueStack.add(temp.poll());
            }
            return temp.poll();
        }
        return -1;
    }

    public int peek() {
        if (!queueStack.isEmpty()) {
            while (!queueStack.isEmpty()) {
                temp.add(queueStack.poll());
            }
            if (!temp.isEmpty())
                return temp.peek();
            else
                return -1;
        } else if (!temp.isEmpty()) {
            while (!temp.isEmpty()) {
                queueStack.add(temp.poll());
            }
            if (!queueStack.isEmpty())
                return queueStack.peek();
            else
                return -1;
        }
        return -1;
    }

    public boolean isEmpty() {
        return queueStack.isEmpty() && temp.isEmpty();
    }

}

