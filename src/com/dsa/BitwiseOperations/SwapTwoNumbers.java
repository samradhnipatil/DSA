package com.dsa.BitwiseOperations;

public class SwapTwoNumbers {

    public static void main(String[] args) {
        int num1 = -10;
        int num2 = 12;
        System.out.println("Num1 : "+ num1);
        System.out.println("Num2 : "+ num2);
        System.out.println("After Swapping");
        swapNumbers(num1,num2);
    }

    public static void swapNumbers(int num1, int num2) {

        int temp = num1 ^ num2;
        System.out.println("Num1 : "+ (temp ^ num1));
        System.out.println("Num2 : "+ (temp ^ num2));

    }
}
