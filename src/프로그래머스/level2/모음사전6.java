package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전6 {

    static char[] arr = {'A','E','I','O','U'};
    static int answer;
    static int count;

    public static int solution(String word){
        answer = 0;
        count = 0;

        dfs("", word);

        return answer;
    }

    static void dfs(String str, String target){
        if(str.length() > 5) return;

        if(answer != 0) return;

        if(str.length() > 0){
            count++;
            if(str.equals(target)){
                answer = count;
                return;
            }
        }

        for(int i=0;i<arr.length;i++){
            dfs(str + arr[i], target);
        }
    }

    public static void main(String[] args) throws Exception{
        String word = "I";
        System.out.println(solution(word));
    }

}
