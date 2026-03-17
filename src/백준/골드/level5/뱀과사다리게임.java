package 백준.골드.level5;

import java.io.*;
import java.util.*;

public class 뱀과사다리게임 {
    static int n, m;    //사다리의 수, 뱀의 수
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1;i<=100;i++){
            board[i] = i;
        }

        //사다리 입력
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start] = end;
        }

        //뱀 입력
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start] = end;
        }

        System.out.println(bfs(1));

    }

    static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});   //시작, 주사위 횟수
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int count = cur[1];

            if(x == 100) return count;

            for(int dice=1;dice<=6;dice++) {
                int nx = x + dice;
                if (nx < 0 || nx > 100) continue;

                nx = board[nx];

                if(!visited[nx]){
                    visited[nx] = true;
                    q.offer(new int[]{nx, count+1});
                }
            }

        }

        return -1;
    }

}
