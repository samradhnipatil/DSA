import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {

    public static void main(String[] args) {
        String  up="123";
        System.out.println(powerSet("", up));
        ArrayList<Integer> num =  new ArrayList<>(Arrays.asList(1,2,3));
        powerSetNum( new ArrayList<>(),num, 0, num.size());
    }

    public static ArrayList<String> powerSet(String p , String up){
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> list = new ArrayList<>();
        list.addAll(powerSet(p, up.substring(1)));
        list.addAll(powerSet(p+ch, up.substring(1)));
        return list;
    }

    public static void powerSetNum(ArrayList<Integer> p, ArrayList<Integer> up, int ind,  int n){
        if(ind == n) {
            System.out.println(p);
            return;
        }
        p.add(up.get(ind));
        powerSetNum(p, up, ind + 1, n);
        p.removeLast();
        powerSetNum(p, up, ind+1, n);
        return;
    }
}

