package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
프림 알고리즘
 */

public class 네트워크연결 {
    static int n,m;
    static ArrayList<ArrayList<Edge>> edges;
    static boolean[] visited;

    static class Edge implements Comparable<Edge>{
        int to, cost;
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
        StringTokenizer st;

        int answer= 0 ;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        edges = new ArrayList<>();

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b, cost));
            edges.get(b).add(new Edge(a, cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;
            if(visited[now]) continue;
            visited[now] = true;
            answer += dist;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;
                if(!visited[next]){
                    pq.offer(new Edge(next, cost));
                }
            }

        }
        System.out.println(answer);
    }

}
