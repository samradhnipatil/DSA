package com.dsa.GreedyApproach;

import java.util.*;

public class MeetingInARoom {
    public MeetingInARoom() {
        int[] start = {0,3,1,5,5,8};
        int[] end = {5,4,2,9,7,9};

        int max = CountMaxMeetings(start, end);
        System.out.println("Maximum meetings : " + max);
    }

    public class meet{
        private int s;
        private int e;
        private int pos;

        public meet(int s, int e, int pos){
            this.s = s;
            this.e = e;
            this.pos = pos;
        }
    }
    public int CountMaxMeetings(int[] start, int[] end){
        ArrayList<meet> map = new ArrayList<>();
        int i = 0;
        while(i < start.length){
            map.add(i, new meet(start[i], end[i], i));
            i++;
        }

        Comparator<meet> comparator = new Comparator<meet>() {
            @Override
            public int compare(meet o1, meet o2) {
                if(o1.e > o2.e)
                    return 1;
                else
                    return -1;
            }
        };

        Collections.sort(map, comparator);

        int j = 1;
        int count = 1;
        int freeTime = map.getFirst().e;

        System.out.print("Map Before : ");
        for(int p = 0 ; p < map.size() ; p++){
            System.out.println(map.get(p).e + " ");
        }

        while(j < map.size()){
            var x = map.get(j);
            if(x.s > freeTime){
                count++;
                freeTime = x.e;
                j++;
            }
            else{
                map.remove(j);
            }
        }
        System.out.print("Map After : ");
        for(int p = 0 ; p < map.size() ; p++){
            System.out.print(map.get(p).e + " ");
        }
        return count;
    }


}
