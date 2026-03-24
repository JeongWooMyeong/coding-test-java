package 백준.골드.level3;

import java.io.*;
import java.util.*;

public class 텀프로젝트 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] done;
    static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
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
        visited[cur] = true;
        int next = arr[cur];

        if(!visited[next]){
            dfs(next);
        }else if(!done[next]){
            //사이클 발견 -> 사이클에 속한 학생 수 카운트
            for(int i=next;i!=cur;i=arr[i]){
                count++;
            }
            count++;
        }
        done[cur] = true;
    }

}
