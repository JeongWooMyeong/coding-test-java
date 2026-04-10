package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class N과M260410_10 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(arr);

        dfs(0,0);

        System.out.print(sb.toString());



    }

    static void dfs(int start, int idx){
        if(idx == M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i=start;i<N;i++){
            if(!visited[i] && prev != arr[i]){
                selected[idx] = arr[i];
                visited[i] = true;
                //이거 빼먹음
                prev = arr[i];
                dfs(i+1, idx+1);
                visited[i] = false;
            }
        }

    }

}
