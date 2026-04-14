package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*
암호만들기에서 알파벳이 암호에서 증가하는 순서로 배열 -> 조합 abcd에서 acbd 불가능
 */

/*
이건 선택/비선택으로 해볼것임
 */

public class 암호만들기5 {
    static int L,C;
    static char[] arr;
    static List<Character> chosen = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            arr[i] = st.nextToken().charAt(0);
        }
        //알파벳 오름차순 정렬
        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb.toString());


    }

    static void dfs(int idx){
        if(idx == C){
            if(chosen.size() == L && isValid(chosen)){
                for(char c : chosen) sb.append(c);
                sb.append("\n");
            }

            return;
        }
        //현재 문자 선택
        chosen.add(arr[idx]);
        dfs(idx+1);
        //현재 문제 서낵하지 않음
        chosen.remove(chosen.size()-1);
        dfs(idx+1);


    }

    static boolean isValid(List<Character> chosen){
        int vowel = 0;
        int nvowel = 0;

        for(char c : chosen){
            if("aeiou".indexOf(c) >= 0) vowel++;
            else nvowel++;
        }

        return vowel >= 1 && nvowel >= 2;

    }

}
