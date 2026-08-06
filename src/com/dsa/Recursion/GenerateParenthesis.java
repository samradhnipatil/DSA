import java.util.ArrayList;

public class GenerateParenthesis {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(GetParenthesis(0,0,n, ""));
    }

    public static ArrayList<String> GetParenthesis(int openN, int closeN, int n, String sol){
        if(openN == n && closeN == n){
            ArrayList<String> list = new ArrayList<>();
            list.add(sol);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(openN < n){
            list.addAll(GetParenthesis(openN+1, closeN, n, sol+"("));
        }
        if(closeN < n && openN > closeN && !sol.isBlank()){
           list.addAll(GetParenthesis(openN, closeN+1, n , sol+")"));
        }
        return list;
    }
}
