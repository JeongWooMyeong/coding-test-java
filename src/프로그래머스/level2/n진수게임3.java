package 프로그래머스.level2;

import java.util.*;
import java.io.*;
/*
Integer.toString(num, radix) -> 숫자를 n진수로 문자열로 변환
Integer.parseInt(string, raidx) -> string을 n진수로 해석하여 10진수로 변환임.. 주의하자.
 */

public class n진수게임3 {

    public static String solution(int n, int t, int m, int p){
        String result = "";

        for(int i=0;i<t*m;i++){
            String num = Integer.toString(i, n);
            result += num;
        }

        int turn = p-1;
        int count = 0;
        result = result.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<result.length();i++){
            if(i%m == turn){
                sb.append(result.charAt(i));
                count++;

                if(count == t) break;

            }

        }

        return sb.toString();

    }

    public static void main(String[] args) throws Exception{
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        System.out.println(solution(n,t,m,p));
    }

}
