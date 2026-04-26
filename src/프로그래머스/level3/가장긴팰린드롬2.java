package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
이건 그냥 내가 생각한 완전탐색
논리는 맞는데 시간 초과 되네..
 */

public class 가장긴팰린드롬2 {
    public static int solution(String s){
        int answer = 0;

        if(s.length() < 2) return s.length();

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i,j+1);
                if(isPalindrome(sub)){
                    if(sub.length() > answer){
                        answer = sub.length();
                    }
                }
            }
        }


        return answer;
    }

    static boolean isPalindrome(String sub){
        int left= 0; int right = sub.length()-1;

        while(left <= right){
            if(sub.charAt(left) != sub.charAt(right)) return false;
            left++;
            right--;
        }

        return true;

    }

    public static void main(String[] args) throws Exception{
        String s = "abcdcba";
        System.out.println(solution(s));
    }

}
