package com.dsa.StackAndQueue.MonotonicStackAndQueue;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.HashMap;

public class LFUCache {

    public static void main(String[] args) {
       String[] cmd = {"LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"};
       int[][] vals = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {3}, {4, 4}, {1}, {3}, {4}};
        Object[] ans = new Object[cmd.length];
       LFUCache lfuCache = new LFUCache(0);
       for(int i = 0; i < cmd.length; i++){
           if(cmd[i].equals("LFUCache")) {
               lfuCache = new LFUCache(vals[i][0]);
               ans[i] = null;
           }
           else if(cmd[i].equals("put")) {
               lfuCache.put(vals[i][0], vals[i][1]);
               ans[i] = null;
           }
           else if(cmd[i].equals("get")) {
               int a = lfuCache.get(vals[i][0]);
               ans[i] = a;
           }
       }
       System.out.println(Arrays.toString(ans));
    }

    public static class Pair {
        public int key;
        public int val;
        public int count;
        public Pair(int key, int val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }

    public int capacity;
    public HashMap<Integer, Pair> map = new HashMap<>();
    PriorityQueue<Pair> queue = new PriorityQueue<>(
            (a, b) -> a.count - b.count
    );

    public LFUCache(int capacity){
        this.capacity = capacity;
    }

    public int deleteElement(int num) {
        this.queue.remove(map.get(num));
        int c = this.map.get(num).count;
        this.map.remove(num);
        return c;
    }

    public void insertElement(int num, int val, int count) {
        Pair p = new Pair(num, val, count);
        this.queue.add(p);
        this.map.put(num, p);
    }

    public int get(int num) {
        if(map.containsKey(num)) {
            int ans = map.get(num).val;
            int c = deleteElement(num);
            insertElement(num, ans,c+1 );
            return ans;
        }
        return -1;
    }

    public void put(int num, int val) {
        if(map.containsKey(num)){
            // delete the given node
            int c = deleteElement(num);
            insertElement(num, val, c+1);
            return;
        }

        if(map.size() == this.capacity) {
            //delete the node with the least count , if tie delete the LRU ie start of the Linked List
            if(!queue.isEmpty()) {
                Pair p = queue.poll();
                map.remove(p.key);
            }
        }

        insertElement(num,val,1);
    }
}
