package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
단순 정렬해서 하는 방식은 통하지 않음
X
 */

public class 단어변환5 {

    public static int solution(String begin, String target, String[] words){
        Arrays.sort(words);

        //if(begin.equals(target))
        int answer = 0;
        String word = begin;

        for(int i=0;i<words.length;i++){
            if(match(words[i], word)){
                word = words[i];
                answer++;
                if(word.equals(target)){
                    break;
                }
            }
        }

        return answer;

    }

    static boolean match(String a, String b){
        if(a.length() != b.length()) return false;
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }

        return count == 1;
    }

    public static void main(String[] args) throws Exception{
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

}
