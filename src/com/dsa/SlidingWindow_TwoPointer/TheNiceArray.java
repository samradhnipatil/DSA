package com.dsa.SlidingWindow_TwoPointer;

public class TheNiceArray {

    public static void main(String[] args) {
        int[] arr = { 41, 3, 5 };
        int k = 2;
        System.out.println(getTheCountOfNiceArray(arr, k));
    }

    public static int getTheCountOfNiceArray(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int c = 0;
        int m = k;
        while( j < arr.length) {
            if(arr[j] % 2 != 0 && m > 0) {
                    m--;
                    if( m == 0 ) {
                        c++;
                        while (arr[i] % 2 == 0) {
                            i++;
                        }
                        if (arr[i] % 2 != 0) {
                            m++;
                            i++;
                        }
                    }
                }
            j++;
        }
        return c;
    }
}
