package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
맨날 플로이드 워셜로 풀었는데 다익스트라로 한번 풀어봐야겠다.
 */

public class 택시합승요금6 {
    static ArrayList<ArrayList<Edge>> edges;
    static int[] d;
    static int INF = (int) 1e9;
    static int n1;

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

    public static int solution(int n, int s, int a, int b, int[][] fares){
        int answer = INF;
        n1 = n;

        edges= new ArrayList<>();
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }
        //d = new int[n+1];

        for(int[] f : fares){
            int a1 = f[0];
            int b1 = f[1];
            int cost = f[2];

            edges.get(a1).add(new Edge(b1, cost));
            edges.get(b1).add(new Edge(a1, cost));
        }

        int[] distS = dijkstra(s);
        int[] distA = dijkstra(a);
        int[] distB = dijkstra(b);

        for(int k=1;k<=n;k++){
            if(distA[k] != INF && distB[k] != INF && distS[k] != INF) {
                answer = Math.min(answer, distS[k] + distA[k] + distB[k]);
            }
        }

        return answer;
    }

    static int[] dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d = new int[n1+1];
        Arrays.fill(d, INF);
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;
            if(d[now]<dist) continue;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = d[now] + edges.get(now).get(i).cost;
                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }

        }

        return d;


    }

    public static void main(String[] args) throws Exception{
//        int n = 6;
//        int s = 4;
//        int a = 6;
//        int b = 2;
//        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
//

        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};


        System.out.println(solution(n,s,a,b,fares));

    }

}
