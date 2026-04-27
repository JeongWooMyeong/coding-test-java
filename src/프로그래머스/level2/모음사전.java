package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전 {
    static List<String> dict;
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public static int solution(String word){
        int answer = 0;

        dict = new ArrayList<>();
        dfs(0, "");

        for(int i=0;i<dict.size();i++){
            if(dict.get(i).equals(word)){
                answer = i+1;
            }
        }

        return answer;
    }

    static void dfs(int depth, String current){
        if(depth > 5) return;

        //System.out.println(current);
        if(!"".equals(current)) {
            dict.add(current);
        }

        for(char c : vowels){
            dfs(depth + 1, current + c);
        }
    }

    public static void main(String[] args) throws Exception{
        String word = "AAAAE";

        System.out.println(solution(word));

    }

}
