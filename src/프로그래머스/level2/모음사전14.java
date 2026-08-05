package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전14 {

    static int answer;
    static char[] vowel = {'A','E','I','O','U'};
    static int n;
    static int count = 0;

    public static int solution(String word){
        n = word.length();

        answer = 0;
        dfs("", word);

        return answer;
    }

    static void dfs(String path, String word){
        if(path.length() > 5) return;
        if(answer != 0) return;

        if(path.length() > 0) {
            count++;
            if (word.equals(path)) {
                answer = count;
                return;
            }
        }


        for(int i=0;i<vowel.length;i++){
            dfs(path + vowel[i], word);
        }


    }

    public static void main(String[] args) throws Exception{
        String word = "AAAAE";
        System.out.println(solution(word));
    }


}
