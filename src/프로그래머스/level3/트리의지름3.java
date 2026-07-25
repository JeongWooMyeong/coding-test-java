package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 트리의지름3 {

    static int n;
    static ArrayList<ArrayList<Edge>> edges;
    static int maxDist, maxNode;
    static boolean[] visited;

    static class Edge {
        int num;
        int cost;

        public Edge(int num, int cost){
            this.num = num;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        maxDist = 0;
        bfs(1);

        maxDist = 0;
        bfs(maxNode);

        System.out.println(maxDist);


    }

    static void bfs(int start){
        Queue<Edge> q = new LinkedList<>();
        visited = new boolean[n+1];
        q.offer(new Edge(start, 0));
        visited[start] = true;

        while(!q.isEmpty()){
            Edge cur = q.poll();
            int now = cur.num;
            int dist = cur.cost;

            if(maxDist < dist){
                maxDist = dist;
                maxNode = now;
            }

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).num;
                int cost = edges.get(now).get(i).cost;

                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new Edge(next, cost + dist));
                }

            }

        }


    }

}
