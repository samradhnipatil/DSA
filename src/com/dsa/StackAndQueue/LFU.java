package com.dsa.StackAndQueue;

import java.util.Arrays;
import java.util.HashMap;

public class LFU {
    public int size;
    public int capacity;
    public class DoubleNode{
        int[][] data;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode(int[][] data){
            this.data = data;
        }
    }
    public DoubleNode head;
    public DoubleNode tail;

    public LFU(int size){
        this.size = size;
        head = new DoubleNode(new int[][]{{-1,-1},{0}});
        tail = new DoubleNode(new int[][]{{-1,-1},{0}});
        head.next = tail;
        tail.prev = head;
    }


    HashMap<Integer, DoubleNode> hashMap = new HashMap<>();

    public void put(int[] data, int count) {
        if(this.size == capacity) {
            DoubleNode remove = tail.prev;
            remove.prev.next = tail;
            tail.prev = remove.prev;
            capacity--;
        }
        DoubleNode newNode = new DoubleNode(new int[][] {data,{count}});
        DoubleNode temp = head.next;
        while(temp.data[1][0] > count){
            temp = temp.next;
        }

        temp.prev.next = newNode;
        newNode.prev = temp.prev;
        temp.prev = newNode;
        newNode.next =temp;

//        head.next = newNode;
//        newNode.prev = head;
//        temp.prev = newNode;
//        newNode.next = temp;
        capacity++;
        if(!hashMap.containsKey(data[0]))
            hashMap.put(data[0], newNode);
    }

    public int get(int key) {
        if(!hashMap.containsKey(key))
            return -1;

        DoubleNode val = hashMap.get(key);
        System.out.println("key : " + key);
        System.out.println("Val : " + Arrays.toString(val.next.data[0]) + ", Count : "+ Arrays.toString(val.next.data[1]));

        val.prev.next = val.next;
        val.next.prev = val.prev;

        capacity--;
        put(val.data[0],val.data[1][0] + 1);
        return val.data[0][1];
    }

    public void getData(){
        while(head.next != tail){
            System.out.println(Arrays.toString(head.next.data[0]) + ", Count : "+ Arrays.toString(head.next.data[1]));
            head = head.next;
        }
    }
}

