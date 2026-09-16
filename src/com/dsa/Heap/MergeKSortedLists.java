package com.dsa.Heap;

import com.dsa.Array.MergeSortedArrays;

import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args){
        ArrayList<Node> heads = new ArrayList<>();
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        heads.add(head1);

        Node head2 = new Node(-4);
        head2.next = new Node(-3);
        heads.add(head2);

        Node head3 = new Node(-5);
        head3.next = new Node(-3);
        head3.next.next = new Node(1);
        head3.next.next.next = new Node(2);
        head3.next.next.next.next = new Node(3);
        head3.next.next.next.next.next = new Node(4);
        heads.add(head3);

        Merge merge = new Merge();
        Node ans = merge.mergeLists(heads);

        while(ans != null){
            System.out.print("-> "+ ans.val);
            ans = ans.next;
        }
    }

    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static class Merge{

        public Merge(){

        }

        private Node mergeLists(ArrayList<Node> list){
            PriorityQueue<Node> minHeap = new PriorityQueue<>(
                    (a,b) -> Integer.compare(a.val, b.val)
            );

            for(Node i : list){
                if(i != null)
                    minHeap.offer(i);
            }

            Node ans = new Node(0);
            Node tail = ans;
            while(!minHeap.isEmpty()){
                Node small = minHeap.poll();
                ans.next = small;
                ans = ans.next;

                if(small.next != null){
                    minHeap.offer(small.next);
                }
            }
            return tail.next;
        }
    }
}
