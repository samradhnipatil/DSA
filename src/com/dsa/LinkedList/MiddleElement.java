package com.dsa.LinkedList;

public class MiddleElement {
    public MiddleElement() {
        Node head = new Node(2);
        head.next = null;
        Node tempHead = head;
        head.Insertion(head, 6);
        head.Insertion(head, 5);
        head.Insertion(head, 3);
        head.Insertion(head, 7);
        head.Insertion(head, 1);
        head.Insertion(head, 10);

        System.out.println("Given Linked List : ");
        while(tempHead != null){
            System.out.print( tempHead.val + " ");
            tempHead = tempHead.next;
        }

        Node middle = TwoPointerMethod(head);
        System.out.println("\nMiddle element of the Linked List : " + middle.val);
    }

    public Node TwoPointerMethod(Node head){
        Node p1 = head;
        Node p2 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
