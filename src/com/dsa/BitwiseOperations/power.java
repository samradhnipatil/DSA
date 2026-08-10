package com.dsa.BitwiseOperations;

public class power {
    public static void main(String[] args) {
        System.out.println(pow(2,10));
        System.out.println(powII(2,10));
    }

    public static int pow(int n , int m){
        if(m == 1){
            return n;
        }
        if(m % 2 == 0){
            return pow(n*n, m/2);
        }
        else {
            return n * pow(n, m-1);
        }
    }

    public static double powII(int n , int m){
        double ans = 1.0;
        long m1 = m;
        if(m1 < 0)
            m1 = -1*m1;
        while(m1 > 0){
            if(m1 % 2 == 0){
                n = n * n;
                m1 = m1/2;
            }
            else {
                ans = ans * n;
                m1 = m1 -1;
            }
        }
        if( m < 0)
            ans = (double) (1.0) / (double) (ans);
        return ans;
    }
}
