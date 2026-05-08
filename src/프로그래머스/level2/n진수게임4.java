package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class n진수게임4 {

    public static String solution(int n, int t, int m, int p){
        int maxLen = t * m;
        String result = "";

        for(int i=0;i<=maxLen;i++){
            result += convertN(i, n);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0;i<result.length();i++){
            if(i % m == p-1) {
                sb.append(result.charAt(i));
                count++;
                if(count == t) break;
            }

        }
        return sb.toString();

    }

    static String convertN(int num, int n){
        String digit = "0123456789ABCDEF";//16진수까지
        StringBuilder sb = new StringBuilder();

        if(num == 0) return "0";

        while(num > 0){
            int remainder = num % n;
            sb.append(digit.charAt(remainder));
            num /= n;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception{
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        System.out.println(solution(n,t,m,p));
    }

}
