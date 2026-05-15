package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 산모양타일링 {
    static int[] dp;

    public static int solution(int n, int[] tops){
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        a[1] = 1;
        if (tops[0] == 1) b[1] = 3;
        else b[1] = 2;

        for (int i = 2; i <= n; i++) {
            a[i] = (a[i - 1] + b[i - 1]) % 10007;
            if (tops[i - 1] == 1) {
                b[i] = (a[i - 1] * 2 + b[i - 1] * 3) % 10007;
            } else {
                b[i] = (a[i - 1] + b[i - 1] * 2) % 10007;
            }
        }
        return (a[n] + b[n]) % 10007;
    }

    public static void main(String[] args) throws Exception{
        int n  = 4;
        int[] tops = {1,1,0,1};
        System.out.println(solution(n, tops));
    }

}
