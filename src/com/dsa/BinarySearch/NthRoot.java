package com.dsa.BinarySearch;

public class NthRoot {
    public NthRoot() {
        int N = 3;
        int M = 27;
        int ans = FindMid(N,M);
        System.out.println("Nth Root of "+ M + ": "+ ans);
    }

    public int FindMid(int N, int M){
        double mid = 0.0;
        double low = 1;
        double high = M;
        double  x = 1e-6;
        while((high - low) > x){
            mid = (high + low) / 2.0;
            if(Multiply(mid, N) > M){
                high = mid;
            }
            else{
                low = mid;
            }
        }
        if(Multiply(Math.floor(mid * 100000)/100000, N) == M)
            return (int)mid;
        else
            return -1;
    }

    public double Multiply(double num, int N){
        double ans = 1.0;
        for(int i = N; i > 0 ; i--){
            ans = ans * num;
        }
        return ans;
    }
}
