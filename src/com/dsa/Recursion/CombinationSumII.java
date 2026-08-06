import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;

public class CombinationSumII {

    public static String[][] map = {{"a","b","c"},{"d","e","f"},{"g","h","i"},
                                    {"j","k","l"},{"m","n","o"},{"p","q","r","s"},
                                    {"t","u","v"},{"w","x","y","z"}};
    public static void main(String[] args) {
        int[] num = {1,2,2};
        int target = 8;
//        System.out.println(getCombination(num, new ArrayList<>(), target, 0));
        Arrays.sort(num);
//        System.out.println(getCombinationII(num, new ArrayList<>(), target, 0));
//        System.out.println(getCombinationII_2(num, new ArrayList<>(), target, 0));
//        System.out.println(getCombinationII_2(num, new ArrayList<>(), target, 0));
//        System.out.println(SubsetI(num, 0,  0));
//        System.out.println(SubSetII(num,new ArrayList<>(), 0));
//        System.out.println(SubSetII_2(num,new ArrayList<>(), 0));
//        getUniqueSubSets(num);
//        System.out.println(CombinationSumIII(3,8, new ArrayList<>(), 1));
//        System.out.println(LetterCombinationsOfPhoneNumber("", "23"));
//        createSubStrings("","abc");

//        String[][] board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
//        String word = "ABCCED";
//        System.out.println(findStart(word, board));

//        boolean[][] board = new boolean[4][4];
//        NQueens(board, 0);

//        int[][] maze = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
//        int[][] vis = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
//        vis[0][0] = 1;
//        RatInAMaze(maze, 0,0,vis, "");

        String ws = "takeyouforward";
        String[] wd = {"take","forwards", "you"};

        System.out.println(WordSearch(ws,wd,""));

    }

    public static ArrayList<ArrayList<Integer>> getCombination(int[] num, ArrayList<Integer> ans , int target , int index){
        if(index == num.length){
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            if( target == 0 ){
                list.add(new ArrayList<>(ans));
            }
            return list;
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if(target >= num[index]){
            ans.add(num[index]);
            list.addAll(getCombination(num, ans , target-num[index], index));
            ans.removeLast();
        }
        list.addAll(getCombination(num, ans, target, index+1));
        return list;
    }

    public static HashSet<ArrayList<Integer>> getCombinationII(int[] num, ArrayList<Integer> ans , int target, int index){
        if(index == num.length){
            HashSet<ArrayList<Integer>> list = new HashSet<>();
            if(target == 0){
                ArrayList<Integer> t = new ArrayList<>(ans);
                t.sort(Integer::compare);
                list.add(t);
            }
            return list;
        }
        HashSet<ArrayList<Integer>> list = new HashSet<>();

        if(target >= num[index]){
            ans.add(num[index]);
            list.addAll(getCombinationII(num, ans , target- num[index], index+1));
            ans.removeLast();
        }
        list.addAll(getCombinationII(num, ans , target, index+1));
        return list;
    }

    public static HashSet<ArrayList<Integer>> getCombinationII_2(int[] num, ArrayList<Integer> ans , int target, int index){
        if(index == num.length){
            HashSet<ArrayList<Integer>> list = new HashSet<>();
            if(target == 0){
//                ArrayList<Integer> t = new ArrayList<>(ans);
//                t.sort(Integer::compare);
                list.add(new ArrayList<>(ans));
            }
            return list;
        }
        HashSet<ArrayList<Integer>> list = new HashSet<>();

        if(target >= num[index]){
            ans.add(num[index]);
            list.addAll(getCombinationII_2(num, ans , target- num[index], index+1));
            ans.removeLast();
        }
        list.addAll(getCombinationII_2(num, ans , target, index+1));
        return list;
    }

    public static ArrayList<Integer> SubsetI(int[] num, int index, int sum){
        if(index == num.length){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(sum);
            list.sort(Integer::compare);
            return list;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(SubsetI(num, index + 1, sum + num[index]));
        list.addAll(SubsetI(num, index + 1, sum ));
        list.sort(Integer::compare);
        return list;
    }

    public static ArrayList<ArrayList<Integer>> SubSetII( int[] num, ArrayList<Integer> ans, int ind){ // Array with duplicate elements - Generate powerset with unique elements
        if(ind == num.length){
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//            System.out.println(ans);
            list.add(new ArrayList<>(ans));
            return list;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(SubSetII(num, ans, ind + 1));
        ans.add(num[ind]);
        list.addAll(SubSetII(num,ans, ind+1));
        ans.removeLast();
        return list;
    }

    public static HashSet<ArrayList<Integer>> SubSetII_2( int[] num, ArrayList<Integer> ans, int ind){ // Array with duplicate elements - Generate powerset with unique elements
        if(ind == num.length){
            HashSet<ArrayList<Integer>> list = new HashSet<>();
//            System.out.println(ans);
            list.add(new ArrayList<>(ans));
            return list;
        }
        HashSet<ArrayList<Integer>> list = new HashSet<>(SubSetII_2(num, ans, ind + 1));
        ans.add(num[ind]);
        list.addAll(SubSetII_2(num,ans, ind+1));
        ans.removeLast();
        return list;
    }

    public static void getUniqueSubSets(int[] num){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        int start = 0;
        int end = 0;
        for (int j = 0; j < num.length;j++) {
            if(j != 0 && num[j-1] == num[j]){
                start = end +1;
            }
            else{
                start = 0;
            }
            end = list.size() - 1;
            int size = list.size();

            for( int i = start; i < size; i++){
                ArrayList<Integer> t = new ArrayList<>(list.get(i));
                t.add(num[j]);
                list.add(t);
            }
        }

        System.out.println(list);
    }

    public static ArrayList<ArrayList<Integer>> CombinationSumIII(int k , int n, ArrayList<Integer> ans, int num ){
        if(num > 9 ){
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            if(n == 0 && k == 0){
                list.add(new ArrayList<>(ans));
//                System.out.println(ans);
            }
            return list;
        }
        // pick
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if( num <= n ){
            ans.add(num);
            list.addAll(CombinationSumIII(k-1, n-num, ans, num+1));
            ans.removeLast();
        }
        // not pick
        list.addAll(CombinationSumIII(k, n, ans, num+1));
        return list;
    }

    public static ArrayList<String> LetterCombinationsOfPhoneNumber(String p, String up) {
        if(up.isEmpty()){
            ArrayList<String>  list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        int ch = Integer.parseInt(up.substring(0,1));
        for(int i = 0; i < map[ch-2].length; i++){
            list.addAll(LetterCombinationsOfPhoneNumber(p + map[ch][i], up.substring(1)));
        }
        return list;
    }

    public static void createSubStrings(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        createSubStrings(p+ch, up.substring(1));
        createSubStrings(p, up.substring(1));
    }

    public static boolean findStart(String word , String[][] board){
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++) {
                if (Objects.equals(board[i][j], word.substring(0, 1))) {
                    return SearchWord(word.substring(1), i, j, board);
                }
            }
        }
        return false;
    }

    public static boolean SearchWord(String s, int i, int j, String[][] board){
        if(s.isEmpty()){
            return true;
        }
        if(i == board.length -1 && j == board[0].length)
            return false;
        // check valid index left
        if(isValid(board, i , j-1) && Objects.equals(board[i][j - 1], s.substring(0, 1))){
            return SearchWord( s.substring(1), i, j-1, board);
        }
        // check valid index up
        if(isValid(board, i-1 , j) && Objects.equals(board[i-1][j], s.substring(0, 1))){
            return SearchWord( s.substring(1), i-1, j, board);
        }
        // check valid index right
        if(isValid(board, i , j+1) && Objects.equals(board[i][j + 1], s.substring(0, 1))){
            return SearchWord( s.substring(1), i, j+1, board);
        }
        // check valid index down
        if(isValid(board, i+1 , j) && Objects.equals(board[i+1][j], s.substring(0, 1))){
            return SearchWord( s.substring(1), i+1, j, board);
        }
        return false;
    }

    public static  boolean isValid(String[][] b , int i, int j) {
        if( i >=0 && i < b.length && j >= 0 && j < b[0].length)
            return true;
        return false;
    }

    public static void NQueens(boolean[][] board, int i ){
        if(i == board.length){
            display(board);
            return;
        }

        for(int col = 0; col < board[0].length; col++){
            if(isSafe(i, col, board)){
                board[i][col] = true;
                NQueens(board, i+1);
                board[i][col] = false;
            }
        }
    }

    public static void display(boolean[][] b){
        for(int i = 0; i < b.length; i++){
            for(int j =0; j < b[0].length; j++){
                if(b[i][j])
                    System.out.print("Q ");
                else
                    System.out.print("_ ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe( int row, int col, boolean[][] b){
        for(int i = 0 ; i <= row; i++){
            if(b[i][col])
                return false;
        }
        for(int i = 0 ; i <= col; i++){
            if(b[row][i])
                return false;
        }
        int r = row;
        int c = col;
        while( r >= 0 && c >= 0){
            if(b[r][c])
                return false;
            r--;
            c--;
        }
        r = row;
        c = col;
        while(r >= 0 && c < b[0].length){
            if(b[r][c])
                return false;
            r--;
            c++;
        }
        return true;
    }

    public static void RatInAMaze(int[][] maze, int i, int j , int[][] vis, String path){
        if(i == maze.length -1 && j == maze[0].length -1){
            System.out.println(path);
            return;
        }

        // check left
        if(isValidPath(maze, i , j-1) && isSafe(maze, i, j-1 , vis)){
            vis[i][j-1] = 1;
            RatInAMaze(maze, i, j-1, vis, path+"L");
            vis[i][j-1] = 0;
        }
        // check up
        if(isValidPath(maze, i-1 , j) && isSafe(maze, i-1, j , vis)){
            vis[i-1][j] = 1;
            RatInAMaze(maze, i-1, j, vis, path+"U");
            vis[i-1][j] = 0;
        }
        // check right
        if(isValidPath(maze, i , j+1) && isSafe(maze, i, j+1 , vis)){
            vis[i][j+1] = 1;
            RatInAMaze(maze, i, j+1, vis, path+"R");
            vis[i][j+1] = 0;
        }
        // check down
        if(isValidPath(maze, i+1 , j) && isSafe(maze, i+1, j , vis)){
            vis[i+1][j] = 1;
            RatInAMaze(maze, i+1, j, vis, path+"D");
            vis[i+1][j] = 0;
        }
    }

    public static boolean isValidPath(int[][] maze , int i, int j ){
        return (i >= 0 && j >= 0 && i < maze.length && j < maze[0].length);
    }

    public static boolean isSafe(int[][] maze , int i, int j, int[][] vis){
        return (vis[i][j] == 0) && (maze[i][j] == 1);
    }

    public static boolean WordSearch(String ws, String[] wd, String s){
        if(ws.isEmpty()){
            return true;
        }

        boolean ans = false;
        for(int i = 0; i < wd.length; i++){
            if(s.equals(wd[i])){
                ans = WordSearch(ws, wd, "");
                return ans;
            }
            if(wd[i].startsWith(s)){
                String ch = ws.substring(0,1);
                ans = WordSearch(ws.substring(1), wd, s+ch);
                return ans;
            }
        }
        return ans;


    }























}
