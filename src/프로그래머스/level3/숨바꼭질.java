package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 숨바꼭질 {

    static int N,K;
    static int[] map;
    static boolean[] visited;
    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return Integer.compare(this.cost, other.cost);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[100001];
        visited = new boolean[100001];

        System.out.println(bfs(N));
    }

    static int bfs(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        visited[start] = true;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int time = cur.cost;

            if(now == K) return time;

            int[] dx = {now + 1, now -1};

            for(int i=0;i<dx.length;i++){
                if(dx[i] < 0 || dx[i] >= 100001) continue;
                if(visited[dx[i]]) continue;

                visited[dx[i]] = true;
                pq.offer(new Edge(dx[i], time+1));
            }


            int dx2 = now * 2;

            if(dx2 < 0 || dx2 >= 100001) continue;
            if(visited[dx2]) continue;

            visited[dx2] = true;
            pq.offer(new Edge(dx2, time));

        }

        return -1;
    }

}
