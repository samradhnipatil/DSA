package com.dsa.StackAndQueue.PrefixInfixPostfix;

public class countDigits {
    public static void main(String[] args) {
        int num = 3;
        System.out.println(countDig(num));
    }

    public static int countDig(int num){
        int count = 0;
        while(num >0){
            count++;
            num /= 10;
        }
        return count;
    }
}
