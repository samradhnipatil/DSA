package com.dsa.SlidingWindow_TwoPointer;

public class BinarySubArrayWithSum {

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0, 1 };
        int goal = 0;
//        System.out.println(getBinarySubArrayWithSum(arr, goal));
        System.out.println(getBinarySubArrayWithSum_Optimal(arr, goal));
    }

    public static int getBinarySubArrayWithSum(int[] arr, int goal) {  // Partial
        int c = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while( i <= j && j < arr.length) {
            if((sum + arr[j]) <= goal) {
                sum += arr[j];
                if(sum == goal) {
//                    System.out.print("i: " + i + ", j :" + j+ "----------");
//                    for(int k = i; k <= j; k++) {
//                        System.out.print( arr[k] + ", " );
//                    }
//                    System.out.println();
                    c++;
                }
                j++;
            }
            else {
                sum -= arr[i];
                i++;
            }
        }
        return c;
    }

    public static int getBinarySubArrayWithSum_Optimal(int[] arr, int goal) {
        int c1 =  getBinarySubArrayWithSum_LesserThanGoal(arr, goal);
        int c2 = getBinarySubArrayWithSum_LesserThanGoal(arr, goal-1);
//        System.out.println(c1);
//        System.out.println(c2);
        return c1-c2;
    }
    public static int getBinarySubArrayWithSum_LesserThanGoal(int[] arr, int goal){
        // count the subArrays with <= goal
        int i = 0;
        int j = 0;
        int c = 0;
        int sum = 0;
        if( goal < 0)
            return 0;
        while( j < arr.length) {
            sum += arr[j];
//            System.out.println("Sum : "+ sum + ", j : " + j + ", i : " + i);
            while( sum > goal) {
                sum -= arr[i];
                i++;
            }

//            System.out.println("c : " + c + ", j : " + j + ", i : " + i);
            c += (j-i+1);
            j++;
        }
        return c;
    }
}
