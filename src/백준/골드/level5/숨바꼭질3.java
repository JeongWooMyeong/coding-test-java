package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 숨바꼭질3 {
    static int N, K;
    static int[] dist = new int[100001];
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.print(bfs(N, K));

    }

    static int bfs(int n, int k){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(n);
        Arrays.fill(dist, INF);
        dist[n] = 0;

        while(!q.isEmpty()){
            int cur = q.pollFirst();

            if(cur == k) return dist[cur];

            int[] nextToken = {cur+1, cur-1, cur*2};

            for(int i=0;i<nextToken.length;i++){
                int next = nextToken[i];

                if(next > 100000 || next < 0) continue;

                int newCost = (i==2) ? dist[cur] : dist[cur] + 1;

                if(dist[next] > newCost){
                    dist[next] = newCost;
                    if(i == 2) q.addFirst(next);
                    else q.addLast(next);
                }

            }


        }
        return -1;
    }
}
