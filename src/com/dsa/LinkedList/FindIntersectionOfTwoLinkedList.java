package com.dsa.LinkedList;

import java.util.HashSet;

public class FindIntersectionOfTwoLinkedList {
    public FindIntersectionOfTwoLinkedList() {

    }

    public Node FindIntersectionHASHSET(Node h1, Node h2){
        HashSet<Node> map = new HashSet<>();
        map.add(h1);
        map.add(h2);
        while(h1.next != null && h2.next != null){
            if(!map.contains(h1.next)){
                map.add(h1.next);
            }
            else{
                return h1.next;
            }
            if(!map.contains(h2.next)){
                map.add(h2.next);
            }
            else{
                return h2.next;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }

    public Node FindIntersectionWITHLength(Node h1, Node h2){
        Node d1 = h1;
        Node d2 = h2;
        Node t1 = h1;
        Node t2 = h2;
        int len1 = 0;
        int len2 = 0;
        while(d1 != null){
            len1++;
            d1 = d1.next;
        }
        while(d2 != null){
            len2++;
            d2 = d2.next;
        }
        int skipLen = 0;
        if(len1 > len2){
            skipLen = len1-len2;
            while (skipLen > 0 && t1 != null){
                t1 = t1.next;
                skipLen--;
            }
        }
        else {
            skipLen = len2-len1;
            while (skipLen > 0 && t2 != null){
                t2 = t2.next;
                skipLen--;
            }
        }
        while(t1 != null && t2 != null && t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;
    }
    public Node FindIntersectionOptimal(Node h1, Node h2){
        Node d1 = h1;
        Node d2 = h2;
        while(d1 != d2 && d1 != null && d2 != null){
            d1 = d1.next;
            d2 = d2.next;
            if(d1 == null){
                d1 = h2;
            }
            if(d2 == null){
                d2 = h1;
            }
        }
        if(d1 == d2)
            return d1;
        else
            return null;
    }
}
