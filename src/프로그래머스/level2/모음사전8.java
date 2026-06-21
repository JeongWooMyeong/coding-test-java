package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전8 {

    static char[] c = {'A','E','I','O','U'};
    static int answer = 0;
    static int count = 0;

    public static int solution(String word){
        dfs( "", c, word);

        return answer;
    }

    static void dfs(String path, char[] c, String target){
        if(path.length() > 5) return;

        if(answer != 0) return;

        if(path.length() > 0) {
            count++;
            if (path.equals(target)) {

                answer = count;
                return;
            }
        }

        for(int i=0;i<c.length;i++){
            dfs(path+c[i], c, target);
        }

    }

    public static void main(String[] args) throws Exception{
        String word = "AAAAE";
        System.out.println(solution(word));
    }

}
