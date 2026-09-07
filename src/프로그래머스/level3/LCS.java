package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class LCS {

    static char[] c1;
    static char[] c2;
    static Set<String> set1;
    static Set<String> set2;
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        c1 = str1.toCharArray();
        c2 = str2.toCharArray();

        set1 = new HashSet<>();
        set2 = new HashSet<>();
        answer = Integer.MIN_VALUE;

        visited = new boolean[c1.length];

        dfs(0, "",c1, set1);

        visited = new boolean[c2.length];

        dfs(0,"",c2, set2);

        for(String s1 : set1){
            for(String s2 : set2){
                if(s1.equals(s2)){
                    answer = Math.max(answer, s1.length());
                }
            }
        }

        System.out.println(answer);

    }

    static void dfs(int idx, String str, char[] arr, Set<String> set){

        if(idx == arr.length){
            set.add(str);
            return;
        }

        //선택하는 경우
        dfs(idx+1, str + arr[idx], arr, set);

        //선택하지 않는 경우
        dfs(idx+1, str, arr, set);

    }

}
