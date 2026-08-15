package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 찾기3 {

    static String p;
    static String t;
    static int L;
    static int[] pi;
    static List<Integer> result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = br.readLine();
        p = br.readLine();
        result = new ArrayList<>();

        L = p.length();
        pi = new int[L];

        for(int i=1,j=0;i<L;i++){
            while(j > 0 && p.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }

            if(p.charAt(i) == p.charAt(j)){
                j++;
            }

            pi[i] = j;

        }

        for(int i=0,j=0;i<t.length();i++){
            while(j > 0 && t.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }

            if(t.charAt(i) == p.charAt(j)){
                j++;
            }

            if(j == p.length()){
                result.add(i - p.length() + 2);
                j = pi[j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");

        for(int x : result){
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

}
