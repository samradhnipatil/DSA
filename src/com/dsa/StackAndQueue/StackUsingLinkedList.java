package com.dsa.StackAndQueue;

public class StackUsingLinkedList {

    public static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    public Node head = null;

    public void push(int num) {
        if(isEmpty()){
            head = new Node(num);
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(num);
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        Node temp = head;
        Node prev = null;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        int ans = temp.data;
        if(prev != null)
            prev.next = null;
        else
            head = null;
        return ans;
    }

    public int peek() {
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean isEmpty() {
        return (head == null);
    }
}
