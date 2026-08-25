package com.dsa.SlidingWindow_TwoPointer;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "ABCDEF";
        int k = 1;
        System.out.println(getLongestRepeatingCharacterReplacement(s, k));
    }

    public static int getLongestRepeatingCharacterReplacement (String s , int k) {
        int i = 0;
        int j = i+1;
        int max = 0 ;
        int m = k;
        while(j < s.length() && (s.length() - i) >= k) {
            char c = s.charAt(i);
            if(c == s.charAt(j)){
                j++;
            } else {
                if(m > 0){
                    m--;
                    j++;
                } else {
                    max = Math.max(max, (j-i));
                    while(s.charAt(i) == c){
                        i++;
                    }
                    m=k;
                    j = i+1;
                }
            }
        }
        return Math.max(max, (j-i));
    }
}
