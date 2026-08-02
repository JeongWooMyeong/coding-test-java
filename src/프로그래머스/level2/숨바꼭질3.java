package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 숨바꼭질3 {

    static int N,K;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));

    }

    static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[100001];
        q.offer(new int[]{start,0});
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int count = cur[1];

            if(now == K) return count;

            int[] nextToken = {now+1, now-1, now*2};

            for(int next : nextToken){
                if(next < 0 || next > 100000) continue;
                if(visited[next]) continue;

                visited[next] = true;
                q.offer(new int[]{next, count+1});

            }


        }

        return -1;
    }


}
