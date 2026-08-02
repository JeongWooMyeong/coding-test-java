package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 단어변환16 {

    static boolean[] visited;
    static int n;
    static int answer;

    public static int solution(String begin, String target, String[] words){
        n = words.length;
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;

        dfs(begin, target, words, 0);

        if(answer == Integer.MAX_VALUE) return 0;

        return answer;
    }

    static void dfs(String start, String target, String[] words, int count){
        if(start.equals(target)){
            answer = Math.min(answer, count);
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i] && match(start, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
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

        String[] words = {"hot","dot","dog","lot","log","cog"};

        System.out.println(solution(begin,target,words));

    }

}
