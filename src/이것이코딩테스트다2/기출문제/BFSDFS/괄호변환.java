package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 괄호변환 {
    public static void main(String[] args) throws Exception{
        String s = "(()())()";
        System.out.println(solution(s));
    }
    //메인 로직
    static String solution(String p){
        //1. 빈 문자열이면 그대로 반환
        if(p.equals("")) return  "";

        //2. 균형잡힌 u, v 분리 - 이부분 뭔말인지 모르겠음 왜 나누는지
        String[] uv = splitUV(p);
        String u = uv[0];
        String v = uv[1];

        //3. u가 올바른 괄호 문자열이면
        if(isCorrect(u)){
            return u + solution(v);
        }

        //4. u가 올바르지 않으면
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");
        sb.append(reverse(u.substring(1, u.length()-1)));

        return sb.toString();
    }

    //올바른 괄호 문자열인지 체크
    static boolean isCorrect(String s){
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '(') cnt++;
            else{
                if(cnt == 0) return false;
                cnt--;
            }
        }
        return cnt == 0;
    }

    //균형잡힌 u, v 분리
    static String[] splitUV(String w){
        int left = 0, right = 0;
        for(int i=0;i<w.length();i++){
            if(w.charAt(i) == '(') left++;
            else right++;

            if(left == right){
                return new String[]{
                        w.substring(0, i + 1),  //u
                        w.substring(i + 1) //v
                };
            }
        }
        return new String[]{"", ""};
    }

    //괄호 뒤집기
    static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }

}
