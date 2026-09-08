package com.dsa.Heap;

public class CheckIfArrayIsAMinHeap {

    public static void main(String[] args) {
        int[] heap = { 10,20,30,21,23,31,35 };
        MinHeap minHeap = new MinHeap();
        System.out.println(minHeap.checkIfMinHeap(heap, 0) ? "The given Heap is a Min Heap" : "The given Heap is NOT a Min Heap");
    }
    public static class MinHeap {
        public MinHeap(){

        }

        private int getLeft(int[] heap, int i){
            return (2 * i + 1) < heap.length ? (2*i+1) : Integer.MAX_VALUE;
        }

        private int getRight(int[] heap, int i){
            return (2 * i + 2) < heap.length ? (2*i+2) : Integer.MAX_VALUE;
        }
        private boolean checkIfMinHeap(int[] heap, int i){
            if(i >= heap.length / 2)
                return true;
            if(getLeft(heap, i) < heap.length && heap[getLeft(heap, i)] < heap[i]){
                return false;
            }
            if(getRight(heap, i) < heap.length && heap[getRight(heap, i)] < heap[i]){
                return false;
            }

            return checkIfMinHeap(heap, getLeft(heap,i)) && checkIfMinHeap(heap, getRight(heap, i));
        }
    }
}
