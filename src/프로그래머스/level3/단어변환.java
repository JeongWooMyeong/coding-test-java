package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단어변환 {

    static class Node{
        String word;
        int count;

        public Node(String word, int count){
            this.word = word;
            this.count = count;
        }

    }

    public static int solution(String begin, String target, String[] words){
        int answer = 0;

        answer = bfs(begin, target, words);

        return answer;
    }

    static int bfs(String begin, String target, String[] words){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited  = new boolean[words.length];
        q.offer(new Node(begin, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.word.equals(target)) return cur.count;
            for(int i=0;i<words.length;i++){
                if(!visited[i] && canChange(cur.word, words[i])){
                    visited[i] = true;
                    q.offer(new Node(words[i], cur.count+1));
                }
            }
        }

        return 0;
    }

    static boolean canChange(String begin, String word){
        int diff =0;

        if(begin.length() == word.length()){
            for(int i=0;i<begin.length();i++){
                if(begin.charAt(i) != word.charAt(i)) diff++;
            }

            if(diff == 1) return true;

        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};

        System.out.println(solution(begin, target, words));
    }

}
