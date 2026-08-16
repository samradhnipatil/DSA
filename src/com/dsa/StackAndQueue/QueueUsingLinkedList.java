package com.dsa.StackAndQueue;

public class QueueUsingLinkedList {
    public StackUsingLinkedList.Node head = null;

    public QueueUsingLinkedList() {

    }

    public void push(int num){
        if(isEmpty()){
            head = new StackUsingLinkedList.Node(num);
            return;
        }

        StackUsingLinkedList.Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = new StackUsingLinkedList.Node(num);

    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Queye is Empty");
            return -1;
        }
        int ans = head.data;
        head =  head.next;
        return ans;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queye is Empty");
            return -1;
        }
        return head.data;
    }

    public boolean isEmpty(){
        return (head == null);
    }
}
