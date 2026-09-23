package com.dsa.Heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class FindMedianOfTheStream {

    public static void main(String[] args) {
        String[] cmd = {"Median", "AddNum", "AddNum", "FindMedian", "AddNum", "FindMedian"};
        int[] vals = {0,1,6,0,3,0};
        FindMedianOfTheStream findMedianOfTheStream = new FindMedianOfTheStream();
        for(int i = 0; i < cmd.length; i++){
            if(cmd[i].equals("Median"))
                findMedianOfTheStream = new FindMedianOfTheStream();
            else if(cmd[i].equals("AddNum"))
                findMedianOfTheStream.addNum(vals[i]);
            else if(cmd[i].equals("FindMedian"))
                System.out.println(findMedianOfTheStream.findMedian());
        }

    }

    public PriorityQueue<Integer> que = new PriorityQueue<>();
    public FindMedianOfTheStream(){

    }

    private void addNum(int num) {
        que.offer(num);
    }

    private double findMedian() {
        Stack<Integer> temp = new Stack<>();
        double ans = 0;
        int len = que.size();
        while(temp.size() < len/2)
            temp.add(que.poll());

        if(!que.isEmpty() && !temp.isEmpty()) {
            if (len % 2 == 0)
                ans = (double) (temp.peek() + que.peek()) / 2;
            else
                ans = (double) que.peek();
        }

        while(!temp.isEmpty()){
            que.offer(temp.pop());
        }
        return ans;
    }
}
