package 백준.골드.level5;

/*
bfs 버전
 */
import java.util.*;
import java.io.*;


public class 숨바꼭질2 {
    static int N, K;
    static int[] dist = new int[100001];
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.print(bfs(N, K));


    }

    static int bfs(int n, int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Arrays.fill(dist, INF);
        dist[n] = 0;
        pq.add(new int[]{n, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if(now == k) return cost;

            if(cost > dist[now]) continue;

            int[] nextToken = {now + 1, now -1, now * 2};

            for(int i=0;i<nextToken.length;i++){
                int next = nextToken[i];

                if(next < 0 || next > 100000) continue;

                int newCost = (i==2) ? cost : cost + 1;

                if(dist[next] > newCost){
                    dist[next] = newCost;
                    pq.offer(new int[]{next, newCost});
                }

            }

        }
        return -1;
    }

}
