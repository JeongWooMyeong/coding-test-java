package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 모음사전7 {

    static char[] arr = {'A','E','I','O','U'};
    static int[] weight = {781, 156, 31, 6, 1};

    public static int solution(String word){
        int answer = 0;

        for(int i=0;i<word.length();i++){
            int idx = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[j] == word.charAt(i)){
                    idx = j;
                    break;
                }
            }

            answer += idx * weight[i] + 1;
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        String word = "I";
        System.out.println(solution(word));
    }

}
