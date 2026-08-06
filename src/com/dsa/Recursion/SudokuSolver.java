import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {

        int[][] board = {{5,3,0,0,7,0,0,0,0},
                         {6,0,0,1,9,5,0,0,0},
                         {0,9,8,0,0,0,0,6,0},
                         {8,0,0,0,6,0,0,0,3},
                         {4,0,0,8,0,3,0,0,1},
                         {7,0,0,0,2,0,0,0,6},
                         {0,6,0,0,0,0,2,8,0},
                         {0,0,0,4,1,9,0,0,5},
                         {0,0,0,0,8,0,0,7,9}};

        Sudoku(board, 0,0,board.length);
        SudokuSolver(board);
    }

    public static void Sudoku(int[][] board, int i , int j, int n) {
        if(i == board.length) {
            display(board);
            return;
        }

        if(j == board[0].length) {
            Sudoku(board, i+1, 0, n);
            return;
        }

        if(board[i][j] != 0){
            Sudoku(board, i, j+1, n);
            return;
        }
        for(int num = 1; num <= n; num++){
            if(isSafe(board,i,j,num)){
                board[i][j] = num;
                Sudoku(board, i, j+1, n);
                board[i][j] = 0;
            }
        }
    }

    public static boolean SudokuSolver(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for(int i = 0; i < board.length; i++){
            for (int j = 0 ; j< board.length; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty)
                break;
        }

        if(isEmpty){
            display(board);
            return true;
        }
        for( int num = 1; num <= 9; num++) {
            if(isSafe(board, row, col, num)){
                board[row][col] = num;
                if(SudokuSolver(board)) {
                    return true;
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] b, int i , int j, int num) {
        //check row;
        for(int col = 0; col < b.length; col++){
            if(b[i][col] != 0 && b[i][col] == num)
                return false;
        }
        //check col;
        for(int row = 0; row < b.length; row++){
            if(b[row][j] != 0 && b[row][j] == num)
                return false;
        }

        int sqrt = (int)Math.sqrt(b.length);
        int row = i - (i % sqrt);
        int col = j - (j % sqrt);

        for(int x = row; x < row+sqrt; x++){
            for(int y = col; y < col+sqrt ; y++){
                if(b[x][y] == num)
                    return false;
            }
        }

        // check box of eg. 3X3

        return true;
    }

    public static void display(int[][] b){
        for(int[] i : b ){
            System.out.println(Arrays.toString(i));
        }
    }
}
