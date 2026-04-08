package 백준.실버.level1;

import java.util.*;
import java.io.*;

public class 숨바꼭질3 {
    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] dist = new int[100001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.print(bfs(N, K));
    }

    static int bfs(int n, int k ){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        //Arrays.fill(dist, -1);
        dist[n] = 0;
        visited[n] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            int time = dist[cur];
            if(cur == k) return time;

            int[] nextToken = {cur + 1, cur - 1, cur * 2};
            for(int i=0;i<nextToken.length;i++){
                if(nextToken[i] >= 0 && nextToken[i] <= 100000 && !visited[nextToken[i]]){
                    dist[nextToken[i]] = time + 1;
                    visited[nextToken[i]] = true;
                    q.offer(nextToken[i]);
                }
            }

        }

        return -1;
    }
}
