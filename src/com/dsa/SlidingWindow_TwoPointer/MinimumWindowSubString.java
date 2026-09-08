package com.dsa.SlidingWindow_TwoPointer;
import java.util.*;

public class MinimumWindowSubString {

    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        System.out.println(getMinimumWindowSubString(s, t));
    }

    public static class q {
        char c;
        int ind;
        public q (char c, int ind) {
            this.c = c ;
            this.ind = ind;
        }
    }
    public static String getMinimumWindowSubString(String s, String t) {
        if(s.equals(t))
            return t;

        int i = 0;
        int j = 0;
        int count = 0;
        String ans = s + t;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int m = 0 ; m < t.length(); m++){
            map.put(t.charAt(m), 1);
        }
        while(j < s.length()) {
            if( map.containsKey(s.charAt(j))) {
                if(map.get(s.charAt(j)) > 0)
                    count++;
                map.computeIfPresent(s.charAt(j) , (k,v) -> v-1);
            } else {
                map.put(s.charAt(j), -1);
            }
            while(count == t.length()) {
                ans = ans.length() > (j-i+1) ? s.substring(i, j+1) : ans;
                map.computeIfPresent(s.charAt(i) , (k,v)-> v + 1);
                if(map.get(s.charAt(i)) > 0)
                    count--;
                i++;
            }
            j++;
        }
        return ans.length() > s.length() ? "" : ans;
    }

    public static String getMinimumWindowSubSequence(String s, String t) {
        if(s.equals(t))
            return t;

        int i = 0;
        int j = 0;
        int count = 0;
        String ans = s + t;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int m = 0 ; m < t.length(); m++){
            map.put(t.charAt(m), 1);
        }
        while(j < s.length()) {
            if( map.containsKey(s.charAt(j))) {
                if(map.get(s.charAt(j)) > 0)
                    count++;
                map.computeIfPresent(s.charAt(j) , (k,v) -> v-1);
            } else {
                map.put(s.charAt(j), -1);
            }
            while(count == t.length()) {
                ans = ans.length() > (j-i+1) ? s.substring(i, j+1) : ans;
                map.computeIfPresent(s.charAt(i) , (k,v)-> v + 1);
                if(map.get(s.charAt(i)) > 0)
                    count--;
                i++;
            }
            j++;
        }
        return ans.length() > s.length() ? "" : ans;
    }
}
