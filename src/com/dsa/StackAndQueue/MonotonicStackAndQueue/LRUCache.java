package com.dsa.StackAndQueue.MonotonicStackAndQueue;

import java.util.Arrays;
import java.util.HashMap;

public class LRUCache {

    public int capacity;

    public static class Node {
        public Node prev;
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val){
            this.val = val;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    public HashMap<Integer, Node> map = new HashMap<>();
    public Node head = null;
    public Node start = null;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }
    public static void main(String[] args) {
        int[][] cmd = {{1, 1, 1}, {1, 2, 2}, {2, 1}, {1, 3, 3}, {2, 2}, {1, 4, 4}, {2, 3}};

        LRUCache lruCache = new LRUCache(1);

        Object[] ans = new Object[cmd.length];

        for(int i = 0; i < cmd.length; i++) {
            if(cmd[i][0] == 1){
                lruCache.put(cmd[i][1], cmd[i][2]);
                ans[i] = null;
            }
            else if(cmd[i][0] == 2){
               ans[i] = lruCache.get(cmd[i][1]);
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    public void deleteNode(Node node ) {
        if(start == head) {
            this.head = null;
            this.start = null;
            return;
        } else if(node == this.start){
            // deleting the First Node
            node.next.prev = null;
            this.start = node.next;
        } else {
            // deleting any mid Node
//            System.out.println("Node : "+ node.val + " , Prev : " + node.prev + ", Next : " + node.next);
//            System.out.println("start : "+ this.start.val);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void insertNode(int num, int val) {
        Node newNode = new Node(num,val);
        if(head != null)
            this.head.next = newNode;
        newNode.prev = head;
        head = newNode;
    }

    public int get(int num){
        if(map.containsKey(num)){
           int val = map.get(num).val;
           deleteNode(map.get(num));
           insertNode(num, val);
           return val;
        }
        return -1;
    }

    public void put(int num, int val){
        if(map.containsKey(num)){
            // delete node from list and store at the end;
            deleteNode(map.get(num));
            insertNode(num, val);
            return;
        }
        if(map.size() == this.capacity){
            // delete the start Node of the LinkedList
            map.remove(this.start.key);
            deleteNode(this.start);
        }

        insertNode(num, val);

        map.put(num, this.head);

        if(map.size() == 1){
            this.start = this.head;
        }
    }
}
