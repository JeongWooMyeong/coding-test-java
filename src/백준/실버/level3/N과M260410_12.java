package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class N과M260410_12 {
    static int N,M;
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

        Arrays.sort(arr);

        //같으 수를 여러번 골라도 된다 - prev 필요, visited는 필요 없음
        // 비내림차순 - starㅅ 필요
        dfs(0, 0);

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
            if(prev != arr[i]){
                selected[idx] = arr[i];
                prev = arr[i];
                dfs(i, idx+1);
            }
        }

    }
}
