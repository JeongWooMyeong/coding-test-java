package 백준.골드.level4;

import java.util.*;
import java.io.*;

/*
정점기준 prim 알고리즘
 */

public class 최소스패닝트리7 {
    static int V,E;
    static int result = 0;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static boolean[] visited;

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

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[V+1];

        //간선 정보 입력 전 리스트 초기화
        for(int i=0;i<=V;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //무방향
            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        prim(1);

        System.out.println(result);

    }

    static void prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        //visited[start] = true;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int cost = cur.cost;

            if(visited[now]) continue;
            visited[now] = true;
            result += cost;

            //now 돌면서 방문하지 않은곳 큐에 담기
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
