package com.dsa.Heap;

import java.lang.reflect.Array;
import java.util.*;
import java.util.PriorityQueue;

public class HandOfStraights {

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        Hands hands = new Hands();
        int groupSize = 3;
        System.out.println(hands.isNStraightHand(hand, groupSize));
        System.out.println(hands.getHandsOfStraight(hand, groupSize));
    }

    public static class Node {
        int val;
        int count ;

        public Node(int val, int count){
            this.val = val;
            this.count = count;
        }
    }

    public static class Hands{
        public Hands() {

        }

        private boolean getHandsOfStraight(int[] cards, int g){
            if( cards.length % g != 0)
                return false;
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i : cards){
                map.merge(i, 1, (k,v) -> v+1);
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(map.keySet());

            while(!queue.isEmpty()){

                while(!queue.isEmpty() && !map.containsKey(queue.peek()))
                    queue.poll();
                if(queue.isEmpty())
                    break;
                int first = queue.peek();

                for(int i = 0; i < g; i++){
                    int nextCard = first + i;

                    if(!map.containsKey(nextCard))
                        return false;

                    if(map.get(nextCard) == 1)
                        map.remove(nextCard);
                    else
                        map.computeIfPresent(nextCard, (k,v)-> v-1);
                }
            }
            return true;
        }

        private boolean isNStraightHand(int[] hand, int groupSize) {

            if (hand.length % groupSize != 0) {
                return false;
            }

            Map<Integer, Integer> freq = new HashMap<>();

            for (int card : hand) {
                freq.put(card, freq.getOrDefault(card, 0) + 1);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(freq.keySet());

            while (!pq.isEmpty()) {

                // Remove cards whose frequency became zero
                while (!pq.isEmpty() && !freq.containsKey(pq.peek())) {
                    pq.poll();
                }

                if (pq.isEmpty()) {
                    break;
                }

                int first = pq.peek();

                for (int i = 0; i < groupSize; i++) {

                    int card = first + i;

                    if (!freq.containsKey(card)) {
                        return false;
                    }

                    int count = freq.get(card);

                    if (count == 1) {
                        freq.remove(card);
                    } else {
                        freq.put(card, count - 1);
                    }
                }
            }

            return true;
        }
    }
}
