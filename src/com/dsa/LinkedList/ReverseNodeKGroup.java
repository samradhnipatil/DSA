package com.dsa.LinkedList;

import javax.swing.*;

public class ReverseNodeKGroup {
    public ReverseNodeKGroup() {
        Node head = new Node(2);
        head.next = null;
        Node tempHead = head;
        head.Insertion(head, 6);
        head.Insertion(head, 5);
        head.Insertion(head, 3);
        head.Insertion(head, 7);
        head.Insertion(head, 1);
        head.Insertion(head, 10);
        head.Insertion(head, 11
        );

        Node h = ReverseGroup(3,tempHead);
        while( h!= null ){
            System.out.print(h.val+ " ");
            h = h.next;
        }
    }

    public Node ReverseGroup(int k , Node h){
        if(h == null || k == 1)
            return h;
        Node dummy = new Node(0);
        dummy.next = h;
        Node prev = dummy;
        Node curr = dummy;
        Node nex;
        int len = 0;
        while(curr.next != null){
            curr =  curr.next;
            len++;
        }
        while(len >= k){
            curr = prev.next;
            nex = curr.next;
            System.out.println("Len_"+ len);
            System.out.println(curr.val +"_"+ curr.next.val);
            for(int i = 1; i < k; i++){
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            len -= k;
        }
        return dummy.next;
    }
}
