package 백준.골드.level4;

import java.util.*;
import java.io.*;

/*
프림 알고리즘 이용 -> 밀집 그래프 (데이터 많을때?)
 */

public class 네트워크연결7 {
    static int N, M;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static boolean[] visited;
    static int result = 0;

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
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));

        }

        prim(1);


        System.out.println(result);


    }

    static void prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int cost = cur.cost;

            if(visited[now]) continue;
            visited[now] = true;
            result += cost;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost2 = edges.get(now).get(i).cost;

                if(!visited[next]){
                    pq.offer(new Edge(next, cost2));
                }

            }

        }
    }

}
