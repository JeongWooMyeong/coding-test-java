package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class N과M_6 {
    static int n, m;
    static int[] arr;
    static int[] arr2;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        arr2 = new int[m];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtrack(1, 0);

        System.out.print(sb);

    }

    static void backtrack(int start, int depth){
        if(depth == m){
            for(int i=0;i<m;i++){
                sb.append(arr2[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                arr2[depth] = arr[i];
                backtrack(i+1, depth+1);
                visited[i] = false;
            }
        }

    }

}
