package com.dsa.Array;

public class CalculateThePower {
    public int ans = 1;
    public CalculateThePower() {
        int pow = calcPower(2,11);
        System.out.println("2 ^ 10 = " + pow);
    }

    public int calcPower(int x , int n ){
        int n1 = n;
        if(n < 0)
            n1 *= -1;
        while(n1 > 0){
            if( n1 % 2 == 1){
                ans = ans * x;
                n1 = n1-1;
            }
            else{
                x = x * x;
                n1 = n1/2;
            }
        }
        if(n < 0)
            ans = 1/ans;
        return ans;
    }
}
