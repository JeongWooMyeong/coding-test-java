package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 노드사이의거리3 {

    static int N, M;
    static ArrayList<ArrayList<Edge>> edges;
    static boolean[] visited;
    static class Edge implements Comparable<Edge>{
        int to, cost;

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

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            visited = new boolean[N+1];
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            visited[start] = true;
            sb.append(dfs(start, end, 0)).append("\n");
        }

        System.out.println(sb.toString());

    }

    static int dfs(int start, int end, int dist){
        if(start == end) return dist;

        for(int i=0;i<edges.get(start).size();i++){
            int next = edges.get(start).get(i).to;
            int cost = edges.get(start).get(i).cost;

            if(!visited[next]){
                visited[next] = true;
                int result = dfs(next, end, dist + cost);
                if(result != -1) return result;
            }
        }

        return -1;
    }

}
