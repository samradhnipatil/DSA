package com.dsa.Heap;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] heap = { 11, 9, 8, 7, 3, 1 };
        int k = 4;
        MaxHeap maxHeap = new MaxHeap();
        System.out.println(maxHeap.getKthElement(heap, k));
    }

    public static class MaxHeap{
        public MaxHeap(){

        }

        private int getKthElement(int[] heap, int k){
            if( k > heap.length-1)
                return -1;
            for(int i = 0; i <= k-1; i++){
                maxHeapify(heap, heap.length - i);
                if(i == k-1)
                    break;
                int t = heap[0];
                heap[0] = heap[heap.length - 1 - i];
                heap[heap.length - i - 1] = t;
            }
            return heap[0];
        }

        private void maxHeapify(int[] heap, int n){
            for(int i = (heap.length/2)-1; i >= 0; i--){
                heapify(heap, n, i);
            }
        }

        private void heapify(int[] heap, int n , int i){
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int large = i;
            if(left < n && heap[left] > heap[large])
                large = left;
            if(right < n && heap[right] > heap[large])
                large = right;

            if(large != i){
                int t = heap[i];
                heap[i] = heap[large];
                heap[large] = t;

                heapify(heap, n , large);
            }
        }
    }
}
