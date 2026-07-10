package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전10 {

    static int answer;
    static char[] c = {'A','E','I','O','U'};
    //static boolean[] visited;
    static int count;

    public static int solution(String word){

        answer = 0;
        count = 0;

        dfs("" ,word);

        return answer;

    }

    static void dfs(String path, String word){
        if(path.length() > 5) return;

        if(answer != 0) return;

        if(path.length() > 0){
            count++;
            if(path.equals(word)){
                answer = count;
                return;
            }
        }

        for(int i=0;i<c.length;i++){
            dfs(path + c[i], word);
        }

    }

    public static void main(String[] args) throws Exception{
        String word = "AAAAE";
        System.out.println(solution(word));
    }


}
