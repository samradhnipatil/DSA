package com.dsa.Graph_DFS_BFS;

import java.util.*;

public class AlienDictionary {

    public AlienDictionary(){}

    private char[][] getCharacterInOrder(String[] words, int n , int k){
        char[][] edges = new char[n-1][2];

        for(int i = 1; i < n; i++){
            int i1 = 0;
            int i2 = 0;

            while(i1 < words[i-1].length() && i2 < words[i].length()){
                if(words[i-1].charAt(i1) != words[i].charAt(i2)){
                    edges[i-1] = new char[]{words[i-1].charAt(i1), words[i].charAt(i2)};
                    break;
                }
                else {
                    i1++;
                    i2++;
                }
            }
        }
        return edges;
    }

    private ArrayList<Character> getACharacterOrder(char[][] chars, int n, int k){
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        ArrayList<Character> ans = new ArrayList<>();

        for(int i = 0 ; i < chars.length; i++){
            if(inDegree.containsKey(chars[i][1]))
                inDegree.computeIfPresent(chars[i][1], (c, k1)-> k1+1);
            else
                inDegree.put(chars[i][1], 1);
        }

        for( Map.Entry <Character, Integer> val : inDegree.entrySet()){
            if(val.getValue() == 0)
                queue.add(val.getKey());
        }
        while(!queue.isEmpty()){
            char c = queue.poll();
            ans = new ArrayList<>();
            ans.add(c);
            for(char[] i : chars){
                if(i[0] == c){
                    inDegree.computeIfPresent(i[1],(k1,v1)-> v1-1);
                    if(inDegree.get(i[1]) == 0){
                        queue.add(i[1]);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"bcc","abcd","abca","cab","cad"};
        int k = 4;
        AlienDictionary alienDictionary = new AlienDictionary();
        char[][] chars = alienDictionary.getCharacterInOrder(words, words.length, k);

        System.out.println(alienDictionary.getACharacterOrder(chars, words.length, k));
    }
}
