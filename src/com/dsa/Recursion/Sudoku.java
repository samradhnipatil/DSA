package com.dsa.Recursion;

import java.util.Arrays;
import java.util.Objects;

public class Sudoku {
    public Sudoku() {
        String[][] board = {{"5","3",".","6","7","8","9",".","2"},
                            {"6","7","2","1","9","5","3","4","8"},
                            {".","9","8","3","4","2","5","6","7"},
                            {"8","5","9","7","6","1","4","2","3"},
                            {"4","2","6","8","5","3","7","9","1"},
                            {"7","1","3","9",".","4","8",".","6"},
                            {"9","6",".","5","3","7","2","8","4"},
                            {"2","8","7","4","1","9","6","3","5"},
                            {"3","4","5","2","8","6","1","7","9"},};
        SolveSudoku(board);
        System.out.println(Arrays.deepToString(board));

    }

    public void SolveSudoku(String[][] board) {
        SudokuBoard(board);
    }

    public void SudokuBoard(String[][] board){
        for(int i = 0; i < board.length ; i++){
            for( int j = 0; j < board.length ;j++){
                if(Objects.equals(board[i][j], ".")){
                    for(int k = 1 ;k <= 9 ; k++){
                        if(IsValid(board,i,j,k)){
                            board[i][j] = String.valueOf(k);
                            SudokuBoard(board);
                        }
                    }
                    return;
                }
            }
        }
    }

    public boolean IsValid(String[][] board, int i, int j, int k){
        for(int x = 0 ; x < 9; x++){
            if(Objects.equals(board[i][x], String.valueOf(k)))
                return false;
            if(Objects.equals(board[x][j], String.valueOf(k)))
                return false;
            if(Objects.equals(board[3 * (i / 3) + i % 3][3 * (j / 3) + j % 3], String.valueOf(k)))
                return false;
        }
        return true;
    }
}
