package com.dsa.Array;

public class FindElementIn2DArray {
    public FindElementIn2DArray() {
        int[][] arr = {{1,2,4},{5,8,9},{10,20,30}};
        findElement(arr, 20);
        withBinarySearch(arr, 20);
    }

    public void findElement(int[][] arr, int target){
        int row = arr.length;
        int col = arr[0].length;
        int targetRow = 0;
        int targetCol = 0;
        for(int i = 0 ; i < row ; i++){
            if(target >= arr[i][0] && target <= arr[i][col-1]){
                targetRow = i;
                break;
            }
        }
        for(int i = 0 ; i < col ; i++){
            if(target == arr[targetRow][i]){
                targetCol = i;
            }
        }
        System.out.println("Target element position : row- "+ targetRow+ " col- "+targetCol);
    }

    public void withBinarySearch(int[][] arr, int target){
        int row = arr.length;
        int col = arr[0].length;

        int low = 0;
        int high = (row * col) - 1;
        while(low < high){
            int mid = (low+high) / 2;

            int rpos = mid / col;
            int cpos = mid % col;

            if(arr[rpos][cpos] == target){
                System.out.println("Target element position with Binary search : row- "+ rpos+ " col- "+cpos);
                return;
            }
            else if(arr[rpos][cpos] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
    }
}
