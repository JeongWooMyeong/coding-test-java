package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
prim 알고리즘
 */

public class 도시분할계획2 {
    static int N,M;
    static ArrayList<ArrayList<Edge>> edges;
    static boolean[] visited;
    static int maxEdge = Integer.MIN_VALUE;
    static int[] d;
    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int answer = 0;

        edges = new ArrayList<>();
        visited = new boolean[N+1];
        d = new int[N+1];
        Arrays.fill(d, INF);

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(b).add(new Edge(a,cost));
            edges.get(a).add(new Edge(b,cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;
            if(visited[now]) continue;
            visited[now] = true;
            answer += dist;
            maxEdge = Math.max(maxEdge, dist);
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;
                if(d[next] > cost){
                    //maxEdge = Math.max(maxEdge, cost);
                    d[next] = cost;
                    //visited[next] = true;
                    pq.offer(new Edge(next, cost));
                }
            }
        }



        System.out.println(answer - maxEdge);

    }
    
}
