package com.dsa.Heap;

public class ImplementMinHeap {
    public static void main(String[] args) {
         String[] cmd = { "initializeheap", "insert", "insert", "insert", "getMin", "heapSize", "isEmpty", "extractMin", "changeKey" , "getMin" };
         int[][] num =  {{},{4},{1},{10},{},{},{},{},{0,16},{}};

        MinHeap minH = new MinHeap();
        for(int i = 0; i < cmd.length; i++){
            if(cmd[i].equals("initializeheap")){
                minH.initializeHeap();
            } else if (cmd[i].equals("insert")) {
                minH.insert(num[i][0]);
            } else if (cmd[i].equals("getMin")) {
               System.out.println(minH.getMin());
            } else if (cmd[i].equals("heapSize")) {
                System.out.println(minH.heapSize());
            } else if (cmd[i].equals("isEmpty")) {
                System.out.println(minH.isEmpty() ? "Heap is empty!" : "Heap is not empty");
            } else if (cmd[i].equals("extractMin")) {
                System.out.println(minH.extractMin());
            } else if (cmd[i].equals("changeKey")) {
                minH.changeKey(num[i][0], num[i][1]);
            }
        }
    }
    public static class MinHeap {
        public MinHeap(){

        }
        public int[] minHeap = new int[0];
        public int pointer = 0;

        public void initializeHeap() {
            minHeap = new int[10];
        }

        public void insert(int key) {
            if(pointer == minHeap.length) {
                System.out.println("The heap is full!");
                return;
            }
            if(pointer == 0) {
                minHeap[pointer] = key;
                pointer++;
                return;
            }
            int k = pointer;
            minHeap[pointer] = key;
            pointer++;

            while(k != 0 && minHeap[getParent(k)] > minHeap[k]){
                swap(getParent(k), k);
                k = getParent(k);
            }
        }

        public void changeKey(int index, int newVal) {
            minHeap[index] = newVal;

            heapify(0);
        }

        public int extractMin() {
            if(isEmpty())
                return -1;
            int mini =  minHeap[0];
            minHeap[0] = minHeap[pointer-1];
            minHeap[pointer-1] = 0;
            heapify(0);
            return mini;
        }

        public boolean isEmpty() {
            return pointer == 0;
        }

        public int getMin() {
            if (pointer == 0)
                return -1;
            else
                return minHeap[0];
        }

        public int heapSize() {
            return pointer;
        }

        public int getParent(int ind) {
            if(pointer != 0){
                return (int)Math.floor((double) (ind-1)/2);
            };
            return Integer.MAX_VALUE;
        }

        public int left( int ind){
            return (2 * ind + 1) >= pointer ? Integer.MAX_VALUE : (2 * ind + 1);
        }
        public int right( int ind){
            return (2 * ind + 2) >= pointer ? Integer.MAX_VALUE : (2 * ind + 2);
        }

        public void swap(int i, int j) {
            int t = minHeap[i];
            minHeap[i] = minHeap[j];
            minHeap[j] = t;
        }

        public void heapify(int ind) {
            if((left(ind) == Integer.MAX_VALUE || (left(ind) != Integer.MAX_VALUE && left(ind) > minHeap[ind]))
                    && (right(ind) == Integer.MAX_VALUE || (right(ind) != Integer.MAX_VALUE && right(ind) > minHeap[ind]))) {
                return;
            }

            if(left(ind) < minHeap[ind] || right(ind) < minHeap[ind]){
                 int mini = Math.min(left(ind),right(ind));
                 swap(mini, ind);
                 heapify(mini);
            }
        }
    }
}
