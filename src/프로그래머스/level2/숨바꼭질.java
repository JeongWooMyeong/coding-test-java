package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 숨바꼭질 {

    static int N,K;
    static boolean[] visited = new boolean[100001];
    static int[] dist = new int[100001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0});


        int answer = 0;
        answer = bfs(N);

        System.out.println(answer);

    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        dist[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == K) return dist[now];

            int[] next = {now -1 ,now + 1, now * 2};

            for(int nx : next){
                if(nx < 0 || nx > 100000) continue;
                if(visited[nx]) continue;

                visited[nx] = true;
                q.offer(nx);
                dist[nx] = dist[now] + 1;
            }

        }

        return -1;
    }

}
