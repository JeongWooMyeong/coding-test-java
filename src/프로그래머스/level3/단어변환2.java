package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
dfs로 풀음
 */

public class 단어변환2 {
    //단어 변환 횟수
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static int solution(String begin, String target, String[] words){

        visited = new boolean[words.length];
        dfs(0, begin, target, words);
        //무한값이면 target을 찾지 못함
        if(answer == Integer.MAX_VALUE) answer = 0;

        return answer;
    }

    static void dfs(int idx, String path, String target, String[] words){
        if(path.equals(target)){
            answer = Math.min(idx, answer);
            return;
        }

        for(int i=0;i<words.length;i++){
            if(checkDiff(words[i], path) && !visited[i]){
                visited[i] = true;
                dfs(idx+1, words[i], target, words);
                visited[i] = false;
            }
        }

    }

    static boolean checkDiff(String a, String b){
        if(a.length() != b.length()) return false;
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }
        //한글 자만 바꿀 수 있으므로
        return count == 1;
    }

    public static void main(String[] args) throws Exception{
        String begin = "hit";
        String target = "cog";

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

}
