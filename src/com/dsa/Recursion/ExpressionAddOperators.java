import java.util.ArrayList;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        String exp = "0232";
        System.out.println(addOperatorInExpression(exp, "", 8));
    }

    public static ArrayList<String>  addOperatorInExpression(String exp, String ans, int target){
        if(exp.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(target == getAns(ans))
                list.add(ans);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(ans.isEmpty()){
            list.addAll(addOperatorInExpression(exp.substring(1), exp.substring(0,1), target));
            return list;
        }
        // Multiple
        list.addAll(addOperatorInExpression(exp.substring(1), ans +"*"+ exp.charAt(0), target));
        // Addition
        list.addAll(addOperatorInExpression(exp.substring(1), ans +"+"+ exp.charAt(0), target));
        // Subtraction
        list.addAll(addOperatorInExpression(exp.substring(1), ans +"-"+ exp.charAt(0), target));
        return list;
    }

    public static int getAns(String exp){
        int i = 0;
        while(i < exp.length() -1){
            if( i > 0 && exp.charAt(i) == '*'){
                int a = Integer.parseInt(exp.substring(i-1, i)) * Integer.parseInt(exp.substring(i+1, i+2));
                exp = exp.substring(0,i-1) +  a + exp.substring(i+2);
            }
            else {
                i++;
            }
        }
        if(exp.length() == 1)
            return Integer.parseInt(exp);
        int ans = Integer.parseInt(exp.substring(0,1));
        int j = 1;
        while(j < exp.length()-1) {
            if(exp.charAt(j) == '+'){
                ans += Integer.parseInt(exp.substring(j+1, j+2));
                j+=2;
            } else if (exp.charAt(j) == '-') {
                ans -= Integer.parseInt(exp.substring(j+1, j+2));
                j+=2;
            }
        }
        return ans;
    }
}
