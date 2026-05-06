package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class n진수게임 {

    public static String solution(int n, int t, int m, int p){
        //n 진수 t : 차례대로 나타낸 문자열 m 참가하는 인원, 튜브의 순서
        int maxLen = t * m;
        StringBuilder sb = new StringBuilder();
        for(int num=0;num<=maxLen;num++){
            sb.append(Integer.toString(num, n));
        }

        String result = sb.toString().toUpperCase();

        StringBuilder re = new StringBuilder();
        int rr = p -1;

        for(int i=0;i<result.length();i++){
            if(i % m == rr) re.append(result.charAt(i));
            if(re.length() == t) break;
        }

        return re.toString();
    }

    public static void main(String[] args) throws Exception{
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;

        System.out.println(solution(n, t, m, p));

    }

}
