package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전3 {
    static int answer = 0;
    static int count = 0;

    public static int solution(String word){
        char[] c = {'A','E','I','O','U'};

        dfs(c, word, new StringBuilder());

        return answer;
    }

    static void dfs(char[] c, String word, StringBuilder sb){
        if(sb.length() > 0){
            count++;
            if(word.equals(sb.toString())){
                answer = count;
                return;
            }
        }

        if(sb.length() == 5) return;

        for(int i=0;i<c.length;i++){
            sb.append(c[i]);
            dfs(c, word, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) throws Exception{
        String word = "AAAAE";
        System.out.println(solution(word));
    }

}
