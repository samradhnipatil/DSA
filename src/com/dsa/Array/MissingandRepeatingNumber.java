package com.dsa.Array;

public class MissingandRepeatingNumber {
    public MissingandRepeatingNumber() {
        int[] arr = {4,2,3,1,1,6};
        // using maths formula
        findMissingandRepeatNumberMaths(arr);
        // using XOR method
        findMissingandRepeatNumberXOR(arr);
    }

    public void findMissingandRepeatNumberMaths(int[] arr){
        int arraySum = 0;
        int n = arr.length;
        for(int i =0; i< arr.length; i++){
            arraySum += arr[i];
        }
        int arraySquare = 0;
        for(int i =0; i< arr.length; i++){
            arraySquare += (arr[i] * arr[i]);
        }
        // sum of n numbers  and n2
        int sumN = (n*(n+1))/2;
        int sumSquare = (n* (n+1) * (2*n+1))/6;

        int x = sumN - arraySum;
        int y = sumSquare - arraySquare;

        int m = y/x;
        int duplicate = (x+m)/2;
        int missing = m - duplicate;

        System.out.println("Missing element : " + missing);
        System.out.println("Duplicate element : " + duplicate);
    }

    public void findMissingandRepeatNumberXOR(int[] arr){
        int xr = 0;
        int n = arr.length;
        // XOR all the elements and expected array
        for(int i =0; i < n ;i++){
            xr = xr ^ arr[i];
            xr = xr ^ (i+1);
        }

        int bitNo = 0;
        // check which of the bit in xr result is 1 eg: int 4 --> 1 0 0 , bit number 2 is 1 (indexing from right to left)
        while(true){
            if((xr ^ (1 << bitNo)) != 0)
                break;
            else
                bitNo++;
        }
        int one = 0;
        int zero = 0;

        // XOR the elements having ZERO at bitNo position and ONE at bitNo position in ACTUAL Array
        for(int i = 0 ; i < n ;i++){
            if((arr[i] ^ (1 << bitNo)) == 0)
                one = one ^ arr[i];
            else
                zero = zero ^ arr[i];
        }

        // XOR the elements having ZERO at bitNo position and ONE at bitNo position in EXPECTED Array
        for(int i = 1 ; i <= n ;i++){
            if((i ^ (1 << bitNo)) == 0)
                one = one ^ i;
            else
                zero = zero ^ i;
        }
        int count = 0;
        for(int i = 0;i < n ;i++){
            if(arr[i] == zero)
                count++;
        }

        if(count == 2) {
            System.out.println("Duplicate Element : " + zero);
            System.out.println("Missing Element : "+ one);
        }
        else{
            System.out.println("Duplicate Element : " + one);
            System.out.println("Missing Element : "+ zero);
        }
    }
}
