import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int[][] board = {{5,3,0,0,7,0,0,0,0},
                         {6,0,0,1,9,5,0,0,0},
                         {0,9,8,0,0,0,0,6,0},
                         {8,0,0,0,6,0,0,0,3},
                         {4,3,0,8,0,3,0,0,1},
                         {7,0,0,0,2,0,0,0,6},
                         {0,6,0,0,0,0,2,8,0},
                         {0,0,0,4,1,9,0,0,5},
                         {0,0,0,0,8,0,0,7,9}};
        sudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static boolean sudoku(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean empty = true;
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    row= i;
                    col = j;
                    empty = false;
                    break;
                }
            }
            if(!empty) {
                break;
            }
        }
        if(empty) {
            System.out.println(Arrays.deepToString(board));
            return true;
        }

        for(int ans = 1; ans <=9; ans++){
            if(isSafe(board, row, col, ans)){
                board[row][col] = ans;
                if(sudoku(board)){
                    return true;
                }
                else {
                    board[row][col] = 0;
                }
            }

        }
        return false;
    }

    public static boolean isSafe(int[][] board, int i, int j, int val){
        for(int r = 0; r < board.length; r++){
            if(board[i][r] == val)
                return false;
            if(board[r][j] == val)
                return false;
        }
        int sqrt = (int)Math.sqrt((double)board.length);
        int startRow = i - (i%sqrt);
        int startCol = j - (j%sqrt);
        for(int x = startRow; x < startRow+sqrt; x++){
            for(int y = startCol; y < startRow+sqrt; y++){
                if(board[x][y] == val)
                    return false;
            }
        }
        return true;
    }
}