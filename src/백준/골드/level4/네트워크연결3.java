package 백준.골드.level4;

/*
프림 알고리즘 - 노드 중심
 */
import java.util.*;
import java.io.*;

public class 네트워크연결3 {
    static int N, M;
    static ArrayList<ArrayList<Edge>> graph;

    static class Edge implements Comparable<Edge>{
        int to, cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        //간선 입력
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, cost));
            graph.get(b).add(new Edge(a, cost));
        }

        System.out.println(prim(1));

    }

    static int prim(int start){
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        int result = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(visited[cur.to]) continue;
            visited[cur.to] = true;
            result += cur.cost;

            for(Edge next : graph.get(cur.to)){
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
        }
        return result;
    }

}
