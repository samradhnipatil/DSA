package com.dsa.LinkedList;

public class DeleteNodeFromCircularList {
    public DeleteNodeFromCircularList() {
    }

    public Node DeleteNode(Node h, int target){
        if(h.val == target){
            Node t = h;
            while(t.next != h) {
                t = t.next;
            }
            t.next = h.next;
            h = h.next;
            return h;
        }
        Node temp = h;
        while(temp.next != h){
            if(temp.next.val == target){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return h;
    }
}
