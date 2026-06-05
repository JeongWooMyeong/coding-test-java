package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전5 {

    static char[] vowel = {'A','E','I','O','U'};
    static int answer = 0;
    static int count = 0;
    //static boolean[] visited;
    static int n;

    public static int solution(String word){
        //visited = new boolean[vowel.length];
        dfs("", word);

        return answer;
    }

    static void dfs(String str, String target){
        if(str.length() > 5) return;

        if(str.length() > 0){
            count++;
            if(str.equals(target)){
                answer = count;
                return;
            }
        }

        for(int i=0;i<vowel.length;i++){
            dfs(str + vowel[i], target);
        }

    }

    public static void main(String[] args) throws Exception{
        String word = "AAAAE";
        System.out.println(solution(word));
    }

}
