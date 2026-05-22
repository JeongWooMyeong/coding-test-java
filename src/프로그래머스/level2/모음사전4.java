package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전4 {
    static int answer;
    static int count;

    public static int solution(String word){
        answer = 0;
        count = 0;
        char[] c = {'A','E','I','O','U'};

        dfs(new StringBuilder(), c, word);

        return answer;


    }

    static void dfs(StringBuilder path, char[] c, String word){
        if(path.length() > 0){
            count++;
            if(path.toString().equals(word)){
                answer = count;
                return;
            }
        }

        if(path.length() == 5) return;


        for(int i=0;i<c.length;i++){
            //String builder 안쓰고 string으로 써도됌
            path.append(c[i]);
            dfs(path, c, word);
            path.deleteCharAt(path.length()-1);
        }

    }

    public static void main(String[] args) throws Exception{
        String word = "AAAAE";
        System.out.println(solution(word));
    }

}
