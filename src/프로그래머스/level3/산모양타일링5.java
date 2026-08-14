package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 산모양타일링5 {

    static long[] a;
    static long[] b;
    static int mod = 10007;

    public static int solution(int n, int[] tops){
        a = new long[n+1];
        b = new long[n+1];

        a[1] = 1;
        if(tops[0] == 1) b[1] = 3;
        else b[1] = 2;

        for(int k=2;k<=n;k++){
            a[k] = (a[k-1] + b[k-1])%mod;

            if(tops[k-1] == 1){
                b[k] = (2*a[k-1] + 3*b[k-1])%mod;
            }else{
                b[k] = (a[k-1] + 2*b[k-1])%mod;
            }

        }

        return (int)(a[n] + b[n]) % mod;
    }

    public static void main(String[] args) throws Exception{
        int n = 4;
        int[] tops = {1,1,0,1};
        System.out.println(solution(n, tops));
    }

}
