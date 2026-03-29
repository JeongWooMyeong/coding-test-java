package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 괄호변환2 {
    public static void main(String[] args) throws Exception{
        String s = "()))((()";
        System.out.println(solution(s));
    }

    static String solution(String p){
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if("".equals(p)) return "";
        //문자열을 균형잡힌 괄호 문자열로 분리
        //u는 균형잡힌 문자열로 더이상 분리 할 수 없는 문자열
        String[] uv = SplitUV(p);
        String u = uv[0];
        String v = uv[1];
        //2. u가 올바른 괄호 문자열이라면 v에 대해 1단계부터 다ㅣ 수행
        if(isCorrect(u)){
            return u + solution(v);
        }
        //3. u가 올바른 괄호 문자열이 아니라면 아래 과정 수행
        //빈 문자열에 첫번째 문자로 (을 붙임
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");
        //첫번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        sb.append(reverse(p.substring(1, p.length()-1)));

        return sb.toString();
    }

    //1. 균형잡힌 괄호 문자열 u,v 분리
    static String[] SplitUV(String s){
        int left = 0;
        int right = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(') left++;
            else right++;

            if(left == right){
                return new String[]{
                        s.substring(0, i+1),
                        s.substring(i+1)
                };
            }

        }

        return new String[]{"",""};

    }

    static boolean isCorrect(String s){
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '(') cnt++;
            else{
                if(cnt == 0) return false;
                cnt--;
            }
        }

        return true;
    }

    static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(c == '(' ? ')' : '(');
        }

        return sb.toString();
    }

}
