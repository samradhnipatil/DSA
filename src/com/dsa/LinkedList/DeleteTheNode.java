package com.dsa.LinkedList;

public class DeleteTheNode {
    public DeleteTheNode() {
        Node n2 = new Node(5);
        n2.next = null;
        n2.Insertion(n2, 6);
        n2.Insertion(n2, 7);
        n2.Insertion(n2, 9);
    }

    public void DeleteNode(Node target){
        if(target != null && target.next != null){
            target.val = target.next.val;
            target.next = target.next.next;
        }
    }
}
