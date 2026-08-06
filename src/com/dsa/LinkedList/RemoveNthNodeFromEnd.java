package com.dsa.LinkedList;

public class RemoveNthNodeFromEnd {
    public RemoveNthNodeFromEnd() {
        Node head = new Node(2);
        head.next = null;
        Node t1 = head;
        Node t2 = head;
        head.Insertion(head, 3);
        head.Insertion(head, 6);
        head.Insertion(head, 8);
        head.Insertion(head, 5);
        head.Insertion(head, 9);

        RemoveNodeFromEnd(1, t1);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
        RemoveNodeFromEndTwoPointer(1, t2);
        while(t2 != null){
            System.out.print(t2.val + " ");
            t2 = t2.next;
        }
    }

    public void RemoveNodeFromEnd(int n, Node head){
        Node temp = head;
        int len = 0;
        while(temp != null){
            len+=1;
            temp = temp.next;
        }
        int index = len - n ;
        Node prev = null;
        while( index > 0 && head != null){
            prev = head;
            head = head.next;
            index--;
        }
        if(head != null)
            prev.next = head.next;
    }

    public void RemoveNodeFromEndTwoPointer(int n , Node head){
        Node p1 = head;
        Node p2 = head;
        while(n > 0){
            p1 = p1.next;
            n--;
        }
        while(p1.next != null){
            p1 =p1.next;
            p2 = p2.next;
        }
        p2.next  = p2.next.next;
    }
}
