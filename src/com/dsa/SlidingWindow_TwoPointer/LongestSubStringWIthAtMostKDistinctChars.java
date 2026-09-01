package com.dsa.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LongestSubStringWIthAtMostKDistinctChars {

    public static void main(String[] args) {
        String s = "abccab";
        int k  = 4;
        System.out.println(getLongestSubStringWIthAtMostKDistinctChars(s, k));
    }

    public static int getLongestSubStringWIthAtMostKDistinctChars(String s, int k) {
        int i = 0;
        int j = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while( j < s.length()) {
            map.computeIfPresent(s.charAt(j), (c, v) -> v == 0 ? 1 :v + 1);
            j++;
            if (map.size() == k) {
                max = Math.max(max, (j-i));
                char t = s.charAt(i);
                while(map.containsKey(t) && map.get(t) > 0){
                    if(i < s.length()) {
                        map.computeIfPresent(s.charAt(i), (c, v) -> v - 1);
                        if(map.get(s.charAt(i)) == 0)
                            map.remove(t);
                    }
                    i++;
                }
            }
        }
        return Math.max(max, (j-i));
    }
}
