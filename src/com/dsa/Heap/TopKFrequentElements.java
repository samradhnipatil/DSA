package com.dsa.Heap;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] ele = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentElements.getTopKFrequentElements(ele, k)));
    }

    public TopKFrequentElements(){

    }

    public class Val{
        int ele;
        int count;

        public Val(int ele, int count){
            this.ele = ele;
            this.count = count;
        }
    }

    private int[] getTopKFrequentElements(int[] num, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : num){
            if(map.containsKey(i))
                map.computeIfPresent(i,(c,v)-> v+1);
            else
                map.put(i, 1);
        }

        PriorityQueue<Val> freq = new PriorityQueue<>(
                (a, b)-> Integer.compare(b.count, a.count)
        );

        for( int i : map.keySet()){
            freq.offer(new Val(i, map.get(i)));
        }

        int[] ans = new int[k];
        int i = k;
        while(k > 0 && !freq.isEmpty()){
            ans[i - k] = freq.poll().ele;
            k--;
        }
        return ans;
    }
}
