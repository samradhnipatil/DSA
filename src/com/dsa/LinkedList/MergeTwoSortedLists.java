package com.dsa.LinkedList;

public class MergeTwoSortedLists {
    public MergeTwoSortedLists() {
        Node head1 = new Node(1);
        head1.next = null;
        Node t1 = head1;
        head1.Insertion(head1, 5);
        head1.Insertion(head1, 7);
        head1.Insertion(head1, 9);

        Node head2 = new Node(2);
        head2.next = null;
        Node t2 = head2;
        head2.Insertion(head2, 3);
        head2.Insertion(head2, 6);
        head2.Insertion(head2, 8);

        Node ans = mergeListExtraSpace(t1,t2);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        System.out.println();
        Node ans2 = mergeListExtraSpace(t1,t2);
        while(ans2 != null){
            System.out.print(ans2.val + " ");
            ans2 = ans2.next;
        }

    }

    public Node mergeListExtraSpace(Node h1, Node h2) {
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;

        Node newNode = new Node(0);
        Node head = newNode;
        if(h1.val > h2.val){
            newNode.val = h2.val;
            h2 = h2.next;
        }
        else{
            newNode.val = h1.val;
            h1 =h1.next;
        }
        head = newNode;
        while(h1 != null && h2!= null){
            Node h = null;
            if(h1.val < h2.val){
                h = new Node(h1.val);
                h1 = h1.next;
            }
            else{
                h = new Node(h2.val);
                h2 = h2.next;
            }
            newNode.next = h;
            newNode = newNode.next;
        }

        if(h1 != null){
            newNode.next = h1;
        }
        if(h2 != null){
            newNode.next = h2;
        }
        return head;
    }

    public Node mergeList(Node h1, Node h2){
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;
        if(h1.val > h2.val){
            Node temp = h1;
            h1 = h2;
            h2 = temp;
        }
        Node head = h1;
        while(h1 != null && h2 != null){
            Node tmp = null;
            while(h1 != null && h1.val <= h2.val){
                tmp = h1;
                h1 = h1.next;
            }
            tmp.next = h2;

            Node temp = h1;
            h1 = h2;
            h2 = temp;
        }
        return head;
    }
}
