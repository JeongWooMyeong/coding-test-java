package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 암호만들기4 {
    static char[] arr;
    static int L,C;
    static char[] result;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());   //만드는 암호 자리수
        C = Integer.parseInt(st.nextToken());   //주어지는 문자 개수

        arr = new char[C];
        result = new char[L];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            char c = st.nextToken().charAt(0);
            arr[i] = c;
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb.toString());

    }

    static void dfs(int idx, int depth){
        if(depth == L){
            if(isValid(result)){
                sb.append(new String(result)).append("\n");
            }
            return;
        }

        for(int i=idx;i<C;i++){
            result[depth] = arr[i];
            dfs(i+1, depth+1);
        }


    }

    static boolean isValid(char[] result){
        int vowel = 0;
        int nvowel = 0;

        for(char c : result){
            //indexOf 없으면 -1 출력
            if("aeiou".indexOf(c) >= 0) vowel++;
            else nvowel++;
        }

        return vowel >= 1 && nvowel >=2;
    }

}
