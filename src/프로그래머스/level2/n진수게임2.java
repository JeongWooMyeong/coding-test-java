package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
n진수는 Integer.toString(num, n) 으로 변환 가능하지만
이걸 모를 수도 있으니 메서드로도 한번 구현해서 해보자
 */

public class n진수게임2 {

    public static String solution(int n, int t, int m, int p){
        int maxLen = t * m;
        StringBuilder sb = new StringBuilder();

        for(int num=0;num<maxLen;num++){
            sb.append(NBaseConverter(num, n));
        }

        String result = sb.toString();
        int me = p - 1;

        StringBuilder finals = new StringBuilder();

        for(int i=0;i<result.length();i++){
            if(i % m == me) finals.append(result.charAt(i));
            if(finals.length() == t) break;
        }

        return finals.toString();

    }

    static String NBaseConverter(int num, int n){
        String digits = "0123456789ABCDEF"; //최대 16진수까지 지원
        StringBuilder sb = new StringBuilder();
        //0일때 0반환
        if(num == 0) return "0";

        while(num > 0){
            //자리수
            int remainder = num % n;
            sb.insert(0, digits.charAt(remainder));    //아 이게 뒤어서부터 되니까 맨 앞으로 빼주는거군
            //다음 숫자로 넘어감
            num /= n;
        }

        return sb.toString();

    }

    public static void main(String[] args) throws Exception{
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;

        System.out.println(solution(n, t, m, p));

    }

}
