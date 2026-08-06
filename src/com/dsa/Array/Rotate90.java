package com.dsa.Array;

import java.util.Arrays;

public class Rotate90 {
    public Rotate90() {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotateTheMatrix(mat);
    }

    public void rotateTheMatrix(int[][] mat){
        int r = mat.length;
        int c = mat[0].length;
        for(int i = 0; i < r - 1 ; i++){
            for(int j = i+1 ;j < c ; j++){
                if( i == j )
                    continue;
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse the rows
        for(int i = 0 ; i < r ;i++){
            int end = mat[i].length-1;
            for(int start = 0; start < c/2; start++){
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                end--;
            }
        }
        System.out.println(Arrays.deepToString(mat));
    }
}
