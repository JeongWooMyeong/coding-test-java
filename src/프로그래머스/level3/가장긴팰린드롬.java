package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 가장긴팰린드롬 {
    public static int solution(String s){
        int maxLen = 1;
        //char[] c = s.toCharArray();

        for(int i=0;i<s.length();i++){
            maxLen = Math.max(maxLen, expand(s,i,i));
            maxLen = Math.max(maxLen, expand(s,i,i+1));
        }

        return maxLen;
    }

    static int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) throws Exception{
        String s = "abcdcba";
        System.out.println(solution(s));
    }

}
