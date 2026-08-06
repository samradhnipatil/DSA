package com.dsa.LinkedList;

import java.util.HashMap;

public class ThreeSum {
    public ThreeSum() {
    }

    public void FindThreeNumber(Node h, int target) {
        Node t1 = h;
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(t1 != null){
            Node t2 = t1.next;
            while(t2 != null){
                int val = target - t1.val - t2.val;
                if(!map.containsKey(val))
                {
                    map.put(t2.val, i+1);
                    t2 = t2.next;
                    i++;
                }
                else{

                }
            }
        }
    }

}
