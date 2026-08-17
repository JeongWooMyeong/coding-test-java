package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 찾기5 {

    static String text;
    static String pattern;
    static int[] pi;
    static List<Integer> result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        text = br.readLine();
        pattern = br.readLine();

        int L = pattern.length();
        pi = new int[L];
        result = new ArrayList<>();

        for(int i=1,j=0;i<L;i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j-1];
            }

            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
            }

            pi[i] = j;

        }

        for(int i=0,j=0;i<text.length();i++){
            while(j > 0 && text.charAt(i) != pattern.charAt(j)){
                j = pi[j-1];
            }

            if(text.charAt(i) == pattern.charAt(j)){
                j++;
            }

            if(pattern.length() == j){
                result.add(i - pattern.length() + 2);
                j = pi[j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(int x : result) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }

}
