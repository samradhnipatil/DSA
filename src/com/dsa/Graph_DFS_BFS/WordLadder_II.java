package com.dsa.Graph_DFS_BFS;

import java.lang.reflect.Array;
import java.util.*;

public class WordLadder_II {
    public WordLadder_II(){}

    public static class Word{
        String w;
        ArrayList<String> seq;

        public Word(String w,ArrayList<String> seq){
            this.w = w;
            this.seq = seq;
        }
    }

    private ArrayList<ArrayList<String>> getTargetWord(HashSet<String> words, String start, String target) {
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(start, new ArrayList<>(Arrays.asList(start))));
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            Word word = queue.poll();
            for(int i = 0; i < word.w.length(); i++){
                if(word.w.charAt(i) != target.charAt(i)){
                    for(int j = 0; j < 26; j++){
                        String t = word.w.substring(0,i) + (char)('a'+j)+ word.w.substring(i+1);
                        if(words.contains(t) && (char)('a'+j) != word.w.charAt(i)) {
                            ArrayList<String> seq = (ArrayList<String>) word.seq.clone();
                            seq.add(t);
                            if(t.equals(target)){
                                ans.add(seq);
                            }
                            else {
                                queue.add(new Word(t, seq));
                            }
                        }
                    }
                }
            }
            words.remove(word.w);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "ayc", "ayz", "xyz"};
        String start = "abc";
        String target = "xyz";
        WordLadder_II wordLadderII = new WordLadder_II();
        System.out.println(wordLadderII.getTargetWord(new HashSet<>(List.of(words)), start,target));
    }
}
