package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 도시분할계획9 {

    static int N,M;
    static List<List<Edge>> edges;
    static boolean[] visited;
    static int[] d;
    static int answer;
    static int maxValue;
    static int INF = (int) 1e9;
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
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }
        d = new int[N+1];
        Arrays.fill(d, INF);
        answer = 0;
        visited = new boolean[N+1];
        maxValue = Integer.MIN_VALUE;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        d[1] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;

            if(visited[now]) continue;
            visited[now] = true;
            answer += dist;
            maxValue = Math.max(maxValue, dist);

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;

                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }

            }

        }

        System.out.println(answer - maxValue);


    }

}
