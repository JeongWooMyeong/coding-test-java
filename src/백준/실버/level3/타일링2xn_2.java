package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class 타일링2xn_2 {
    static int n;
    static int[] d = new int[1001];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        d[1] = 1;
        d[2] = 3;
        for(int i=3;i<=n;i++){
            d[i] = (d[i-1] + 2 * d[i-2]) % 10007;
        }

        System.out.print(d[n]);

    }

}
