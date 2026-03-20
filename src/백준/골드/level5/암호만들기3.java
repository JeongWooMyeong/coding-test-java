package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 암호만들기3 {
    static int L, C;    //L 알파벳 조합 개수 , 알파벳 수
    static char[] letters;
    static char[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        letters = new char[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters);

        dfs(0, 0);  //depth, idx

        System.out.println(sb);


    }

    static void dfs(int depth, int start){
        if(depth == L){
            if(isValid(result)){
                sb.append(new String(result)).append("\n");
            }
            return;
        }

        for(int i=start;i<C;i++){
            result[depth] = letters[i];
            dfs(depth+1, i+1);
        }

    }

    static boolean isValid(char[] arr){
        int vowel = 0;
        int nvowel = 0;

        for(char c : arr){
            if("aeiou".indexOf(c) >= 0) vowel++;
            else nvowel++;
        }

        return vowel >= 1 && nvowel >=2;
    }

}
