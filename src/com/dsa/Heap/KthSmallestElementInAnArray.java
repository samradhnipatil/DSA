package com.dsa.Heap;

import java.util.PriorityQueue;

public class KthSmallestElementInAnArray {

    public static void main(String[] args) {
        int[] heap = { 3,2,1,-5,6,4 };
        int k = 2;
        MinHeap minHeap = new MinHeap();
        System.out.println(minHeap.getKthSmallestElementInAnArray(heap, k));
        System.out.println(minHeap.getKthSmallestElementInAnArray_PriorityQueue(heap, k));
    }

    public static class MinHeap{
        public MinHeap(){

        }

        private int getKthSmallestElementInAnArray(int[] heap, int k){
            for(int i = 0; i < k; i++){
                minHeapify(heap, heap.length-i);
                if(i == k-1)
                    break;
                int t = heap[0];
                heap[0] = heap[heap.length-1-i];
                heap[heap.length - 1-i] = t;
            }
            return heap[0];
        }

        private void minHeapify(int[] heap, int n){
            for( int i = (heap.length/2)-1; i >= 0; i--){
                heapify(heap, i, n);
            }
        }

        private void heapify(int[] heap, int i, int n){
            int left = 2 * i +1;
            int right = 2 * i +2;

            int small = i;
            if(left < n && heap[left] < heap[small])
                small = left;
            if( right < n && heap[right] < heap[small])
                small = right;

            if(small != i){
                int t = heap[small];
                heap[small] = heap[i];
                heap[i] = t;

                heapify(heap, small, n);
            }
        }

        private int getKthSmallestElementInAnArray_PriorityQueue(int[] heap, int k){
            PriorityQueue<Integer> que = new PriorityQueue<>();

            for(int i : heap){
                que.add(i);
            }
            int i = 1;
            while(i < k && !que.isEmpty()){
                que.poll();
                i++;
            }
            return !que.isEmpty() ? que.peek() :  -1;
        }
    }
}
