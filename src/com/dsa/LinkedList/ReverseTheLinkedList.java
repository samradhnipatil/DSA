package com.dsa.LinkedList;

public class ReverseTheLinkedList {

    public ReverseTheLinkedList() {
        Node head = new Node(2);
        head.next = null;
        Node tempHead = head;
        head.Insertion(head, 6);
        head.Insertion(head, 5);
        head.Insertion(head, 3);
        head.Insertion(head, 7);
        head.Insertion(head, 1);

        System.out.println("Given Linked List : ");
        while(tempHead != null){
            System.out.print( tempHead.val + " ");
            tempHead = tempHead.next;
        }
        System.out.println("\nReversed Linked List : ");
        Node newHead = reverseTheList(head);
         while(newHead != null){
             System.out.print( newHead.val + " ");
             newHead = newHead.next;
         }
    }

    public Node reverseTheList(Node head){
        Node newHead = null;
        while(head != null){
            Node n = head.next;
            head.next = newHead;
            newHead = head;
            head = n;
        }
        return newHead;
    }
}
