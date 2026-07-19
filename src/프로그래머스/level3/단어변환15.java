package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단어변환15 {

    static boolean[] visited;
    static int n;

    static class Word{
        String name;
        int count;

        public Word(String name, int count){
            this.name = name;
            this.count = count;
        }

    }

    public static int solution(String begin, String target, String[] words){
        int answer = 0;
        n = words.length;

        answer = bfs(begin, target, words);

        return answer;
    }

    static int bfs(String begin, String target, String[] words){
        Queue<Word> q = new LinkedList<>();
        visited = new boolean[n];
        q.offer(new Word(begin, 0));

        while(!q.isEmpty()){
            Word cur = q.poll();
            String name = cur.name;
            int count = cur.count;

            if(name.equals(target)) return count;

            for(int i=0;i<words.length;i++){
                if(!visited[i] && match(name, words[i])){
                    visited[i] = true;
                    q.offer(new Word(words[i], count+1));
                }
            }

        }

        return 0;

    }

    static boolean match(String a, String b){
        if(a.length() != b.length()) return false;

        int count = 0;

        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }

        return count == 1;
    }

    public static void main(String[] args) throws Exception{
        String begin = "hit";
        String target = "cog";

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin,target,words));
    }

}
