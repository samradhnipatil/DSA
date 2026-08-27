package com.dsa.SlidingWindow_TwoPointer;
import java.util.Arrays;

public class SubStringsContainingAllThreeChars {

    public static void main(String[] args) {
        String s = "ccbacc";
        System.out.println(getCountOfSubStringsWithAllThreeChars(s));
    }

    public static int getCountOfSubStringsWithAllThreeChars(String s){
        int count = 0;
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        int i = 0;
        while( i < s.length()){
            lastSeen[s.charAt(i) -'a'] = i;
            if( lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count = count + 1+ (Math.min(lastSeen[0] , Math.min(lastSeen[1] ,lastSeen[2] )));
            }
            i++;
        }
        return count;
    }
}
