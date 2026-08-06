package com.dsa.StackAndQueue;

import java.util.Arrays;
import java.util.HashMap;

public class LRU {
    public int size;
    public int capacity;
    public class DoubleNode{
        int[] data;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode(int[] data){
            this.data = data;
        }
    }
    public DoubleNode head;
    public DoubleNode tail;

    public LRU(int size){
        this.size = size;
        head = new DoubleNode(new int[]{-1,-1});
        tail = new DoubleNode(new int[]{-1,-1});
        head.next = tail;
        tail.prev = head;
    }


    HashMap<Integer, DoubleNode> hashMap = new HashMap<>();

    public void put(int[] data) {
        if(this.size == capacity) {
            DoubleNode remove = tail.prev;
            remove.prev.next = tail;
            tail.prev = remove.prev;
            capacity--;
        }
        DoubleNode newNode = new DoubleNode(data);
        DoubleNode temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        temp.prev = newNode;
        newNode.next = temp;
        capacity++;
        hashMap.put(data[0], newNode);
    }

    public int get(int key) {
        if(!hashMap.containsKey(key))
            return -1;

        DoubleNode val = hashMap.get(key);
        val.prev.next = val.next;
        val.next.prev = val.prev;

        DoubleNode temp = head.next;
        head.next = val;
        val.prev = head;
        temp.prev = val;
        val.next = temp;

        return val.data[1];
    }

    public void getData(){
        while(head.next != tail){
            System.out.println(Arrays.toString(head.next.data));
            head = head.next;
        }
    }
}

