package com.dsa.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class MinimumWindowSubSequence {

    public static void main(String[] args) {
        String s = "abcdebdde";
        String t = "bde";
        System.out.println( "Minimum Window SubSequence: " + getMinimumWindowSubSequence(s,t));

    }

    public static String getMinimumWindowSubSequence(String s, String t) {
        if(s.equals(t))
            return t;

        int i = 0;
        int j = 0;
        int l = 0;
        String ans = s+t;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int k =0; k < t.length(); k++) {
            map.put(t.charAt(k), 1);
        }
        while(j < s.length()) {
            if(map.containsKey(s.charAt(j)))
                map.computeIfPresent(s.charAt(j), (k,v) -> v-1);
            else
                map.put(s.charAt(j) , -1);

            if(s.charAt(j) == t.charAt(l)) {
                l++;
            }
            if( l == t.length()) {
                char c = t.charAt(0);
                while(map.get(c) <= 0) {
                    map.computeIfPresent(s.charAt(i), (k,v) -> v+1);
                    if(map.get(c) <= 0)
                        i++;
                }
                ans = ans.length() > (j-i+1) ? s.substring(i, j+1) : ans;
                i = j+1;
                l = 0;
                map.clear();
                for(int k =0; k < t.length(); k++) {
                    map.put(t.charAt(k), 1);
                }
            }
            j++;
        }
        return ans.length() > s.length() ? "" : ans;
    }
}
