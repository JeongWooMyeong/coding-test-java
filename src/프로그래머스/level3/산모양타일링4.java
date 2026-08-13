package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 산모양타일링4 {

    static long[] a;
    static long[] b;
    static int mod = 10007;

    public static int solution(int n, int[] tops){
        //오른쪽아래 두칸 삼각형 채우는 경우 (겹침)
        a = new long[n+1];
        //삼각형 하나, 위아래 삼각형, 오른쪽위 두칸 삼각형
        b = new long[n+1];

        a[1] = 1;
        if(tops[0] == 1) b[1] = 3;
        else b[1] = 2;

        for(int i=2;i<=n;i++){
            a[i] = (a[i-1] + b[i-1]) % mod;

            if(tops[i-1] == 1){
                b[i] = (2 * a[i-1] + 3 * b[i-1]) % mod;
            }else{
                b[i] = (a[i-1] + 2 * b[i-1]) % mod;
            }

        }


        return (int)(a[n] + b[n]) % mod;
    }

    public static void main(String[] args) throws Exception{
        int n  = 4;
        int[] tops = {1,1,0,1};
        System.out.println(solution(n, tops));
    }

}
