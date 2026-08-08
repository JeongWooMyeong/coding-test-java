package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 노드사이의거리6 {

    static int N,M;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> edges;
    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i=0;i<=N;i++) edges.add(new ArrayList<>());

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
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];

            sb.append(bfs(start, end)).append("\n");
        }

        System.out.println(sb.toString());

    }

    static int bfs(int start, int end){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int dist = cur[1];

            if(now == end) return dist;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;

                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, dist + cost});
                }

            }
        }

        return -1;
    }

}
