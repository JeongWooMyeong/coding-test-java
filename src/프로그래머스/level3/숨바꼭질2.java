package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숨바꼭질2 {

    static int N,K;
    static int[] dist;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    static int bfs(int start){
        Deque<Integer> q = new ArrayDeque<>();
        dist = new int[100001];
        Arrays.fill(dist, INF);
        q.addFirst(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int now = q.pollFirst();

            if(now == K) return dist[now];

            int[] d1 = {now + 1, now -1};

            for(int i=0;i<d1.length;i++){
                if(d1[i] < 0 || d1[i] > 100000) continue;

                int newcost = dist[now] + 1;
                if(dist[d1[i]] > newcost) {
                    dist[d1[i]] = newcost;
                    q.addLast(d1[i]);
                }
            }

            int d2 = now * 2;

            if(d2 < 0 || d2 > 100000) continue;

            int newcost = dist[now];

            if(dist[d2] > newcost) {
                dist[d2] = newcost;
                q.addFirst(d2);
            }
        }

        return -1;
    }

}
