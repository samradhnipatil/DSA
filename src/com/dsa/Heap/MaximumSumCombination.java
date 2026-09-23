package com.dsa.Heap;

import java.util.Collections;
import java.util.*;

public class MaximumSumCombination {

    public static void main(String[] args) {

        MaximumSumCombination sum = new MaximumSumCombination();
        int[] num1 = {3,4,5};
        int[] num2 = {2,6,3};
        int k = 2;
        System.out.println(Arrays.toString(sum.getMaximumSumCombinations(num1, num2,k)));
    }

    public MaximumSumCombination(){

    }

    private int[] getMaximumSumCombinations(int[] num1, int[] num2, int k){
        int[] ans = new int[k];
        PriorityQueue<Integer> q1 = new PriorityQueue<>(
                Collections.reverseOrder()
        );
        PriorityQueue<Integer> q2 = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        for(int i : num1)
            q1.offer(i);
        for(int i : num2)
            q2.offer(i);
        int i = k;
        while(!q1.isEmpty() && !q2.isEmpty() && k > 0){
            ans[i-k] = q1.peek() + q2.peek();
            k--;
            if(q1.peek() > q2.peek())
                q2.poll();
            else
                q1.poll();
        }
        return ans;
    }
}
