package com.dsa.Array;

public class LongestSubarrayWithSum {
    int[] arr = {5,5,2,3,4,1,4,5,6,6,1,2,3,2,2};
    public LongestSubarrayWithSum() {
        int max = findSubarray(arr, 10);
        System.out.println(" Max length of subarray with sum 10 : " + max);
        int max1 = findSubarrayTwoPointer(arr, 10);
        System.out.println(" Max length of subarray with sum 10 (Two pointer approach) : " + max1);
    }

    public int findSubarray(int[] arr, int k){
        int maxLen = 0;
        int n = arr.length;
        for(int i = 0 ; i < n ;i++){
            int len = 0;
            int sum = 0;
            for(int j = i; j < n; j++){
                sum = sum + arr[j];
                if(sum == k ){
                    len = j - i + 1;
                    if(len > maxLen) {
                        maxLen = len;
                    }
                }
                if(sum > k)
                    break;
            }
        }
        return maxLen;
    }

    public int findSubarrayTwoPointer(int[] arr, int k){
        int n = arr.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxLen = 0;
        while(i <= j && j < n){
            sum += arr[j];
            if(sum == k){
                if(maxLen < (j-i+1)){
                    maxLen = j-i+1;
                }
            }
            else if(sum > k){
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return maxLen;
    }
}
