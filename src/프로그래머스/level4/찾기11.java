package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 찾기11 {

    static String T;
    static String P;
    static int[] pi;
    static List<Integer> result;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = br.readLine();
        P = br.readLine();
        result = new ArrayList<>();
        sb = new StringBuilder();

        int L = P.length();
        pi = new int[L];

        for(int i=1,j=0;i<L;i++){
            while(j > 0 && P.charAt(i) != P.charAt(j)){
                j = pi[j-1];
            }

            if(P.charAt(i) == P.charAt(j)){
                j++;
            }

            pi[i] = j;
        }

        for(int i=0,j=0;i<T.length();i++){
            while(j > 0 && T.charAt(i) != P.charAt(j)){
                j = pi[j-1];
            }

            if(T.charAt(i) == P.charAt(j)){
                j++;
            }

            if(j == P.length()){
                result.add(i - P.length() + 2);
                j = pi[j-1];
            }
        }

        sb.append(result.size()).append("\n");
        for(int x : result){
            sb.append(x).append(" ");
        }

        System.out.print(sb);
    }

}
