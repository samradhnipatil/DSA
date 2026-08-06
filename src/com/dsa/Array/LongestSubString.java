package com.dsa.Array;

public class LongestSubString {
    public LongestSubString() {
        int[] arr = { 101,21,22,23,24,28,29,30,19 };
        int subStr = findLongestSubstring(arr);
        System.out.println("Longest consecutive sub string : " + subStr);
    }

    public int findLongestSubstring(int[] arr){
        int j = 0;
        int n = arr.length;
        int maxLen = 0;

        int len = 1;
        while(j < n-1){
            if(arr[j] < arr[j+1] && (arr[j+1] - arr[j]) == 1){
                len++;
                j++;
            }
            else {
                if(len > maxLen) {
                    maxLen = len;
                }
                j++;
                len = 1;
            }
        }
        return maxLen;
    }
}
