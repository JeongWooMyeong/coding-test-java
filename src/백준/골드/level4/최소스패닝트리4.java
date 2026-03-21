package 백준.골드.level4;

import java.util.*;
import java.io.*;

/*
프림 알고리즘
 */

public class 최소스패닝트리4 {
    static int N, M;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static boolean[] visited;

    static class Edge implements Comparable<Edge>{
        private int to;
        private int cost;

        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        public int getTo(){
            return this.to;
        }

        public int getCost(){
            return this.cost;
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

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b, cost));
            edges.get(b).add(new Edge(a, cost));
        }

        System.out.println(prim(1));

    }

    static int prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited = new boolean[N+1];
        pq.offer(new Edge(start, 0));
        int result = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int to = cur.getTo();
            int cost = cur.getCost();

            if(visited[to]) continue;
            visited[to] = true;
            result += cost;

            for(Edge next : edges.get(to)){
                if(!visited[next.getTo()]){
                    pq.add(new Edge(next.getTo(), result));

                }
            }

        }

        return result;
    }


}
