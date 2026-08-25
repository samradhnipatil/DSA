package com.dsa.SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {
        String s = "abcddabac";
        System.out.println(getLongestSubStringWithoutRepeatingChars(s));
    }

    public static int getLongestSubStringWithoutRepeatingChars(String s) {
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        while(j < s.length()) {
            if(map.containsKey(s.charAt(j))){
                max = Math.max(max, (j-i));
                i = j;
            }
            else {
                map.put(s.charAt(j), j);
            }
            j++;
        }
        return max;
    }
}
