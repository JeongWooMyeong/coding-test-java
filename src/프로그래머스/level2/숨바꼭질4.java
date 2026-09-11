package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 숨바꼭질4 {

    static int N;
    static int K;
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
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int sec = cur[1];

            if(x == K) return sec;

            int[] d = {x+1, x-1, 2 * x};

            for(int i=0;i<d.length;i++){
                int nx = d[i];

                if(nx < 0 || nx > 100000) continue;
                if(visited[nx]) continue;

                visited[nx] = true;
                q.offer(new int[]{nx, sec+1});
            }

        }

        return -1;
    }

}
