package 백준.실버.level1;

import java.util.*;
import java.io.*;

public class 숨바꼭질2 {
    static final int MAX = 100001;
    static int n,k;
    static boolean[] visited = new boolean[100001];
    static int[] dist = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.print(bfs(n, k));

    }

    static int bfs(int start, int m){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, -1);  //시간 배열
        dist[start] = 0;    //시간 0
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            int time = dist[cur];

            if(cur == m) return time;

            int[] nextTokens = {cur + 1, cur - 1, cur * 2};
            for(int i=0;i<nextTokens.length;i++){
                if(nextTokens[i] >= 0 && nextTokens[i] < MAX && !visited[nextTokens[i]]){
                    dist[nextTokens[i]] = time + 1;
                    visited[nextTokens[i]] = true;
                    q.offer(nextTokens[i]);
                }
            }

        }

        return -1;

    }


}
