package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숨바꼭질3 {

    static int N,K;
    static int[] dist;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        System.out.println(bfs(N));
    }


    static int bfs(int start){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(start);
        dist[start] = 0;

        while(!dq.isEmpty()){
            int now = dq.pollFirst();

            if(now == K) return dist[now];

            int[] d1 = {now-1, now+1};

            for(int i=0;i<d1.length;i++){
                if(d1[i] < 0 || d1[i] > 100000) continue;

                int newCost = dist[now] + 1;

                if(dist[d1[i]] > newCost){
                    dist[d1[i]] = newCost;
                    dq.addLast(d1[i]);
                }

            }

            int d2 = 2 * now;

            if(d2 < 0 || d2 > 100000) continue;

            int newCost = dist[now];

            if(dist[d2] > newCost){
                dist[d2] = newCost;
                dq.addFirst(d2);
            }
        }

        return dist[K];
    }

}
