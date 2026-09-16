package com.dsa.Heap;

import java.util.*;

public class ReplaceElementsByTheirRanks {

    public static void main(String[] args) {
        int[] heap = {20, 15, 26, 2, 98, 6};
        MinHeap min = new MinHeap();
        System.out.println(Arrays.toString(min.replaceElementWithRanks(heap)));
    }

    public static class Node {
        int val ;
        int index;
        public Node(int val , int index){
            this.val = val ;
            this.index = index;
        }
    }

    public static class MinHeap{
        public MinHeap(){

        }

        private int[] replaceElementWithRanks(int[] heap){
            PriorityQueue<Node> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));

            for(int i = 0; i< heap.length; i++){
                minheap.offer(new Node(heap[i], i));
            }
            int i = 1;
            while(!minheap.isEmpty()){
                Node small = minheap.poll();
                heap[small.index] = i;
                i++;
            }
            return heap;
        }
    }
}
