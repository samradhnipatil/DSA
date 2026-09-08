package com.dsa.Heap;
import java.util.*;

public class ConvertAMinHeapToMaxHeap {

    public static void main(String[] args) {
        int[] heap = { -5,-4,-3,-2,-1 };
        MaxHeap maxHeap = new MaxHeap();
//        maxHeap.createMaxHeap(heap);
        maxHeap.maxHeapify(heap);
        System.out.println(Arrays.toString(heap));
    }
    public static class MaxHeap{

        public MaxHeap(){

        }

        private int getLeft(int[] heap, int i){
            return (2 * i +1) < heap.length ? (2 * i + 1) : Integer.MAX_VALUE;
        }

        private int getRight(int[] heap, int i){
            return (2 * i +2) < heap.length ? (2 * i +2) : Integer.MAX_VALUE;
        }

        private void swap(int[] heap, int i , int j){
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        private void convertToMaxHeap(int[] heap, int i){
            if( i >= heap.length/2)
                return;
            int left = getLeft(heap, i);
            int right = getRight(heap, i);
            if(heap[left] > heap[i] || heap[right] > heap[i]){
                int max = heap[left] > heap[right] ? left : right;
                swap(heap,i, max);
            }
            convertToMaxHeap(heap, left);
            convertToMaxHeap(heap, right);
        }

        private void createMaxHeap(int[] heap){
            int min = heap[0];
            heap[0] = heap[heap.length-1];
            heap[heap.length-1] = min;
            convertToMaxHeap(heap, 0);
        }

        private void maxHeapify(int[] heap){
            for(int i = ( heap.length / 2) -1; i >=0; i--){
                ;minHeapToMaxHeap(heap, i);
            }
        }

        private void minHeapToMaxHeap(int[] heap, int i){
            int left = getLeft(heap,i);
            int right = getRight(heap,i);
            int l = i;
            if(left < heap.length && heap[i] < heap[left])
                l = left;

            if(right < heap.length && heap[l] < heap[right])
                l = right;

            if(l != i){
                swap( heap, l, i);
                minHeapToMaxHeap(heap, l);
            }
        }
    }
}
