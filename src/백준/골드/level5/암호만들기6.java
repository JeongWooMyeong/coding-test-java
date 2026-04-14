package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 암호만들기6 {
    static int L, C;
    static char[] arr;
    static char[] result;
    static StringBuilder sb = new StringBuilder();

    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        //순열 백트래킹 테스트
        visited = new boolean[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            arr[i] = st.nextToken().charAt(0);
        }
        //알파벳 순 정렬
        Arrays.sort(arr);

        dfs(0, 0);
        //dfs2(0);

        System.out.println(sb.toString());


    }

    static void dfs(int idx, int depth){
        if(depth == L){
            if(isValid(result)){
                sb.append(new String(result)).append("\n");
            }

            return;
        }
        //조합 백트래킹
        for(int i=idx;i<C;i++){
            result[depth] = arr[i];
            dfs(i+1, depth+1);
        }


    }
    //순열 테스트
    static void dfs2(int depth){
        if(depth == L){
            if(isValid(result)){
                sb.append(new String(result)).append("\n");
            }

            return;
        }
        //순열 백트래킹 (모든 경우를 다돌아야해서 idx 필요 없음)
        for(int i=0;i<C;i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                dfs2(depth+1);
                visited[i] = false;
            }
        }


    }

    static boolean isValid(char[] result){
        int vowel = 0;  //모음 개수
        int nvowel = 0; //모음 아닌거 개수
        for(char c : result){
            //없으면 -1 리턴
            if("aeiou".indexOf(c) >= 0 ) vowel++;
            else nvowel++;
        }

        return vowel >= 1 && nvowel >= 2;
    }

}
