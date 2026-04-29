package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
BFS 방식으로도 풀어볼려고
 */

public class 단어변환3 {
    static boolean[] visited;

    static class Word{
        String name;
        int count;

        public Word(String name, int count){
            this.name = name;
            this.count = count;
        }

    }

    public static int solution(String begin, String target, String[] words){
        int answer = bfs(begin, target, words);

        return answer;
    }

    static int bfs(String begin, String target, String[] words){
        visited = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));

        while(!q.isEmpty()){
            Word cur = q.poll();
            String name = cur.name;
            int count = cur.count;
            if(name.equals(target)) return count;

            for(int i=0;i<words.length;i++){
                if(!visited[i] && checkDiff(name, words[i])){
                    visited[i] = true;
                    q.offer(new Word(words[i], count+1));
                }
            }

        }
        //찾을 수 없을때 0 반환
        return 0;

    }

    static boolean checkDiff(String a, String b){
        int diff = 0;
        if(a.length() != b.length()) return false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

}
