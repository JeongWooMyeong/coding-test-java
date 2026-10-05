package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 광고3 {

    static int L;
    static int[] pi;
    static String pattern;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        L = Integer.parseInt(br.readLine());
        pattern = br.readLine();

        pi = new int[L];

        for(int i=1,j=0;i<L;i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j-1];
            }

            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
            }

            pi[i] = j;
        }

        System.out.println(L - pi[L-1]);

    }

}
