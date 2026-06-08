package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
DFS
 */

public class 단어변환8 {

    static int answer;
    static boolean[] visited;

    public static int solution(String begin, String target, String[] words){
        answer = Integer.MAX_VALUE;

        visited = new boolean[words.length];
        dfs(begin, 0, target, words);

        if(answer == Integer.MAX_VALUE) return 0;

        return answer;

    }

    static void dfs(String start, int count, String target, String[] words){

        if(start.equals(target)){
            answer = Math.min(answer ,count);
            return;
        }

        for(int i=0;i<words.length;i++){
            if(!visited[i] && match(start, words[i])){
                visited[i] = true;
                dfs(words[i], count + 1, target, words);
                visited[i] = false;
            }
        }

    }

    static boolean match(String a, String b){
        int count = 0;

        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }

        return count == 1;
    }


    public static void main(String[] args) throws Exception{
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin, target, words));
    }

}
