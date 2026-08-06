package com.dsa.LinkedList;

import java.util.HashMap;

public class TwoSum {
    public TwoSum() {
        Node h = new Node(1);
        h.Insertion(h, 3);
        h.Insertion(h, 2);
        h.Insertion(h, 6);
        h.Insertion(h, 4);
        h.Insertion(h, 2);

        FindTwoNumber(h, 10);
    }

    public void FindTwoNumber(Node h, int target){
        if(h == null)
            return;
        Node temp = h;
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(temp != null){
            int val = target - temp.val;
            if(!map.containsKey(val)){
                map.put(temp.val, i);
                temp = temp.next;
                i++;
            }
            else {
                System.out.println("Numbers found "+val+ " and "+temp.val);
                return;
            }
        }
        System.out.println("No Numbers found.");
    }
}
