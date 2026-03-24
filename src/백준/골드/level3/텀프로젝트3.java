package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 텀프로젝트3 {
    static int T, n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] done;  //탐색 돌때까지
    static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=n;i++){
                if(!visited[i]) dfs(i);
            }

            sb.append(n - count).append("\n");


        }
        System.out.print(sb);
    }

    static void dfs(int cur){
        int next = arr[cur];
        visited[cur] = true;

        if(!visited[next]){
            dfs(next);
        }else if(!done[next]){
            for(int i=next;i!=cur;i=arr[i]){
                count++;
            }
            count++;
        }
        done[cur] = true;

    }

}
