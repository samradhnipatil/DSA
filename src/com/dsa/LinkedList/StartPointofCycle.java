package com.dsa.LinkedList;

public class StartPointofCycle {
    public StartPointofCycle() {
    }

    public Node StartNode(Node head){
        if(head == null)
            return head;
        Node f = head;
        Node s = head;
        Node entry = head;
        while(f.next.next != null && s.next != null){
            s = s.next;
            f = f.next.next;
            if(f == s)
                break;

        }
        if(f.next.next  == null)
            return null;
        while(entry != s && s!= null){
            entry = entry.next;
            s = s.next;
        }
        return entry;
    }
}
