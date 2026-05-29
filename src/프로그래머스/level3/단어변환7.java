package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단어변환7 {
    static int answer;
    static boolean[] visited;

    static class Node{
        String word;
        int count;

        public Node(String word, int count){
            this.word = word;
            this.count = count;
        }

    }

    public static int solution(String begin, String target, String[] words){
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];

        answer = bfs(begin, target, words);


        return answer;

    }

    static int bfs(String begin, String target, String[] words){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin,0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            String now = cur.word;
            int count = cur.count;
            if(now.equals(target)) return count;
            for(int i=0;i<words.length;i++){
                if(!visited[i] && match(now, words[i])){
                    visited[i] = true;
                    q.offer(new Node(words[i],count+1));
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

        System.out.println(solution(begin, target, words));
    }

}
