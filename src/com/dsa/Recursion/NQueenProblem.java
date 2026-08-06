package com.dsa.Recursion;
import java.util.*;

public class NQueenProblem {
    public NQueenProblem() {
        ArrayList<ArrayList<ArrayList<String>>> ans = FindPattern(4);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i).toString());
        }
    }

    public ArrayList<ArrayList<ArrayList<String>>> FindPattern(int n) {
        ArrayList<ArrayList<ArrayList<String>>> ans = new ArrayList<>();
        ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<String> temp = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                temp.add("-");
            }
            board.add(temp);
        }
        HashSet<Integer> downDgnl = new HashSet<>(2 * n - 1);
        HashSet<Integer> hoz = new HashSet<>(n);
        HashSet<Integer> upDgnl = new HashSet<>(2 * n - 1);
        PlaceQueens(ans, board, 0, n, downDgnl, hoz, upDgnl);
        return ans;
    }

    public void PlaceQueens(ArrayList<ArrayList<ArrayList<String>>> ans, ArrayList<ArrayList<String>> board, int col, int n, HashSet<Integer> downDgnl, HashSet<Integer> hoz, HashSet<Integer> upDgnl) {
        if (col == n) {
            System.out.println(board.toString());
            ans.add(board);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (!hoz.contains(row) && !downDgnl.contains(row + col) && !upDgnl.contains((n - 1) + (col - row))) {
                board.get(row).set(col, "Q");
                hoz.add(row);
                downDgnl.add(row + col);
                upDgnl.add((n - 1) + (col - row));
                PlaceQueens(ans, board, col + 1, n, downDgnl, hoz, upDgnl);
                board.get(row).set(col, "-");
                hoz.remove(row);
                downDgnl.remove(row + col);
                upDgnl.remove((n - 1) + (col - row));
            }
        }
    }
}
