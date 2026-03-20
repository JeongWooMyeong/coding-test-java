package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 암호만들기2 {
    static int L, C;
    static char[] letters;
    static StringBuilder sb = new StringBuilder();
    static char[] result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        letters = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters);

        result = new char[4];
        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int depth, int start){
        if(depth == L){
            if(isValid(result)){
                sb.append(new String(result)).append("\n");
            }
            return;
        }

        for(int i=start;i<C;i++) {
            result[depth] = letters[i];
            dfs(depth + 1, i + 1);
        }

    }

    static boolean isValid(char[] arr){
        int vowel = 0; int notvowel = 0;
        for(char c : arr){
            if("aeiou".indexOf(c) >= 0) vowel++;
            else notvowel++;
        }

        return vowel >= 1 && notvowel >= 2;
    }

}
