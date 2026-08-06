package com.dsa.Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PalindromeString {
    public PalindromeString() {
        String s = "aabb";
        ArrayList<ArrayList<String>> ans = Palindrome(s);
        System.out.println(ans.toString());
    }

    public ArrayList<ArrayList<String>> Palindrome(String s){
        ArrayList<ArrayList<String>> str = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<>();
        FindPalindrome(0,s,path,str);
        return str;
    }

    public void FindPalindrome(int index,String s, ArrayList<String> path, ArrayList<ArrayList<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length() ; i++ ){
            if(IsPalidrome(s, index, i)){
                path.add(s.substring(index, i+1));
                FindPalindrome(i+1,s,path,ans);
                path.removeLast();
            }
        }
    }

     public boolean IsPalidrome( String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
         return true;
     }
}
