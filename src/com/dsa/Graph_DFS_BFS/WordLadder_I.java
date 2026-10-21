package com.dsa.Graph_DFS_BFS;

import java.util.*;

public class WordLadder_I {
    public WordLadder_I(){}

    public static class Word{
        String w;
        int index;
        int level;

        public Word(String w,int index, int level){
            this.w = w;
            this.index = index;
            this.level = level;
        }
    }

    private int getTargetWord(HashSet<String> words, String start, String target){
        int l = Integer.MAX_VALUE;
        Queue<Word> queue = new LinkedList<>();
        int level = 1;
        queue.add(new Word(start, 0, level));

        while(!queue.isEmpty()) {
            Word word = queue.poll();
            if(word.w.equals(target) && l > word.level){
                l = word.level;
            }
            int j = word.index == (start.length()-1) ? 0 : word.index+1;

            if(word.w.charAt(word.index) != target.charAt(word.index)) {
                for(int i = 0; i < 26; i++) {
                    String temp = word.w.substring(0, word.index) + (char)('a'+ i ) + word.w.substring(word.index + 1);
                    if(words.contains(temp) && !temp.equals(word.w) ){
                        queue.add(new Word(temp, j, word.level+1));
                        words.remove(temp);
                    }
                }
            }
            else {
                if(!queue.contains(new Word(start, j, word.level)))
                    queue.add(new Word(start, j, word.level));
            }
        }
        if(l == Integer.MAX_VALUE)
            return 0;
        else return l;
    }

    public static void main(String[] args) {
        String[] words = {"des","der","dfr","dgt","dfs"};
        String start = "der";
        String target = "dfs";
        WordLadder_I wordLadderI = new WordLadder_I();
        System.out.println(wordLadderI.getTargetWord(new HashSet<>(List.of(words)), start,target));
    }
}
