package com.dsa.BitwiseOperations;
import java.util.*;

public class CountPrimeNumbersInRange {

    public static void main(String[] args) {
        int[][] num = {{1,7},{3,7}};
        System.out.println(getPrimeCount(num));
        System.out.println(getPrimeCountII(num));
        findPrimeFrom1toN(2,5);
    }
    
    public static ArrayList<Integer> getPrimeCount(int[][] num) {
        int c = 0;
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < num.length; i++){
            int count = 0;
            for(int j = num[i][0]; j <= num[i][1]; j++){
                if(map.containsKey(j)) {
                    if((boolean)map.get(j))
                        count++;
                }
                else {
                    c++;
                    if (j != 1 && isPrime(j)) {
                        map.put(j, true);
                        count++;
                    }
                    else{
                        map.put(j, false);
                    }
                }
            }
            list.add(count);
        }
        System.out.println("Run : " + c);
        return list;
    }
    
    public static boolean isPrime(int num) {
        int count = 0;
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                count +=2;
        }
        return count <= 2;
    }

    public static ArrayList<Integer> getPrimeCountII(int[][] num){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < num.length; i++){
            ans.add(findPrimeFrom1toN(num[i][0], num[i][1]));
        }
        return ans;
    }

    public static int findPrimeFrom1toN(int l ,int r){
        int[] num = new int[r+1];
        Arrays.fill(num,1);
        num[0] = 0;
        num[1] = 0;
        int count = 0;
        for(int i = l; i <= r; i++){
            if(num[i] == 1) {
                count++;
                for(int j = 2; j <= (r/i); j++){
                    num[i*j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(num));
        return count;
    }
}
