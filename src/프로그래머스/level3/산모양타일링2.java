package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 산모양타일링2 {

    public static int solution(int n, int[] tops){
        int answer = 0;
        int[] a = new int[n+1]; //완벽하게 i에서 끝나는 경우
        int[] b = new int[n+1]; //i에서 끝나지 않고 i+1 이어지는 경우
        int mod = 10007;

        a[1] = 1;
        if(tops[0] == 1) b[1] = 3;
        else b[1] = 2;

        for(int i=2;i<=n;i++){
            a[i] = a[i-1] + b[i-1] % mod;
            if(tops[i-1] == 1){
                b[i] = ((2 * a[i-1]) + (3 * b[i-1])) % mod;
            }else{
                b[i] = (a[i-1] + 2 * b[i-1]) % mod;
            }
        }


        return (a[n] + b[n]) % mod;
    }

    public static void main(String[] args) throws Exception{
        int n  = 4;
        int[] tops = {1,1,0,1};
        System.out.println(solution(n, tops));
    }

}
