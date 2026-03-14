package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class N과M_5 {
    static int n, m;
    static int[] arr, arr2;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        arr2 = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtrack(0);

        System.out.print(sb);

    }

    static void backtrack(int depth){
        if(depth == m){
            for(int i=0;i<m;i++){
                sb.append(arr2[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]) {
                visited[i] = true;
                arr2[depth] = arr[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }

    }

}
