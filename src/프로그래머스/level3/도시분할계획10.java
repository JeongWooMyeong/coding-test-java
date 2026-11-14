package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 도시분할계획10 {

    static int N,M;
    static List<List<Edge>> edges;
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
    static int maxCost;
    static int answer;
    static int[] d;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maxCost = Integer.MIN_VALUE;
        answer = 0;

        edges = new ArrayList<>();

        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        visited = new boolean[N+1];
        d = new int[N+1];

        Arrays.fill(d, INF);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));

        }

        prim(1);

        System.out.println(answer - maxCost);

    }

    static void prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        //visited[start] = true;
        d[start] = 0;
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            int now = cur.to;
            int dist = cur.cost;

//            if(d[now] < dist){
//                continue;
//            }
            if(visited[now]) continue;

            visited[now] = true;
            answer += dist;
            maxCost = Math.max(maxCost, dist);

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;
                if(!visited[next]){
                    pq.offer(new Edge(next,cost));
                }
            }


        }

    }

}
