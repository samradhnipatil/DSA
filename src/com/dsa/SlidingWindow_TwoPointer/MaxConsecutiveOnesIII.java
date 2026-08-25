package com.dsa.SlidingWindow_TwoPointer;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] s = { 1, 1, 0, 0, 1 };
        int k = 3;
        System.out.println(getMaxConsecutiveOnes(s,k));
    }

    public static int getMaxConsecutiveOnes(int[] s, int k ){
        int max = 0;
        int i = 0;
        int j = 0;
        int m = k;
        while( j < s.length) {
            if(s[j] == 0) {
                if(m == 0) {
                    max = Math.max(max, (j-i));
                    while(i < j && s[i] != 0){
                        i++;
                    }
                    while(s[i] == 0 && m == 0) {
                        m++;
                        i++;
                    }
                }
                else {
                    j++;
                    m--;
                }
            }
            else {
                j++;
            }
        }
        return Math.max(max, (j-i));
    }
}
