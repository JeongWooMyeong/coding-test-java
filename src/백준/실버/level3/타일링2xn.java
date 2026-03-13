package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class 타일링2xn {
    static int n;
    static int[] d = new int[1001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        d[1] = 1;
        if(n >=2) d[2] = 2;

        for(int i=3;i<=n;i++){
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }

        System.out.print(d[n]);


    }
}
