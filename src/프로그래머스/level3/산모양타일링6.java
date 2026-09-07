package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 산모양타일링6 {

    static int[] a; //3번 타일 쓸 경우
    static int[] b; //1,2,4번 타일 쓸 경우
    static int mod = 10007;

    public static int solution(int n, int[] tops){
        a = new int[n+1];
        b = new int[n+1];

        a[1] = 1;
        if(tops[0] == 1) b[1] = 3;
        else b[1] = 2;

        for(int k=2;k<=n;k++){
            a[k] = (a[k-1] + b[k-1]) % mod;

            if(tops[k-1] == 1){
                b[k] = (2 * a[k-1] + 3 * b[k-1]) % mod;
            }else{
                b[k] = (a[k-1] + 2 * b[k-1]) % mod;
            }

        }

        return (a[n] + b[n]) % mod;
    }

    public static void main(String[] args) throws Exception{
        int n = 10;
        int[] tops = {0,0,0,0,0,0,0,0,0,0};

        System.out.println(solution(n, tops));
    }

}
