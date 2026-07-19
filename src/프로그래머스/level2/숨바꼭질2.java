package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 숨바꼭질2 {

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
        q.offer(new int[]{start, 0});
        visited = new boolean[100001];
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int count = cur[1];

            if(now == K) return count;

            int[] next = {now + 1, now -1, 2 * now};

            for(int x : next){
                if(x < 0 || x > 100000) continue;
                if(visited[x]) continue;

                visited[x] = true;
                q.offer(new int[]{x, count+1});

            }

        }

        return -1;
    }

}
