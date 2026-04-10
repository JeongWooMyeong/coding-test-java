package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class N과M260410_1 {
    static int N,M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //1부터 N까지
        M = Integer.parseInt(st.nextToken());   //M개 고른

        arr = new int[M];
        visited = new boolean[N+1];

        dfs(0);

    }

    static void dfs(int idx){
        if(idx == M){
            for(int i=0;i<M;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[idx] = i;
                dfs(idx+1);
                visited[i] = false;
            }
        }


    }


}
