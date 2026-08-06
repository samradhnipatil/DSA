package com.dsa.Array;
import java.util.HashMap;

public class FindLongestSubstringwithoutRepeatingLetter {
    public FindLongestSubstringwithoutRepeatingLetter() {
        String str = "abcaabcdba";
        int max = findSubstring(str);
        System.out.println("Max length of str : " + max);
    }

    public int findSubstring(String s){
        int n = s.length();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r < n){
            if(map.containsKey(s.charAt(r)))
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            map.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r -l + 1);
            r++;
        }
        return maxLen;
    }
}
