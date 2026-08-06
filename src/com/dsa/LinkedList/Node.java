package com.dsa.LinkedList;

public class Node{
    int val;
    Node next;

    public Node(int val)
    {
        this.val = val;
        this.next = null;
    }

    public Node Insertion(Node head, int val){
        Node h = head;
        if(h == null)
            return null;
        while(h.next != null){
            h = h.next;
        }
        Node newNode = new Node(val);
        newNode.next = null;
        h.next = newNode;
        return head;
    }
}

