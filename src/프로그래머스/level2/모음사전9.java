package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전9 {

    static int[] weight;

    public static int solution(String word){
        weight = new int[5];
        int answer = 0;

        weight[4] = 1;
        for(int i=3;i>=0;i--){
            weight[i] = weight[i+1] * 5 + 1;
        }

        String vowel = "AEIOU";

        for(int i=0;i<word.length();i++){
            int idx = vowel.indexOf(word.charAt(i));
            answer += weight[i] * idx + 1;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        String word = "EIO";
        System.out.println(solution(word));

    }

}
