package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
나는 시작점마다 dijkstra 돌렸는데
이렇게 돌리면 시간초과 남 X
 */

public class 등산코스정하기 {
    static ArrayList<ArrayList<Edge>> edges;
    static int[] d;
    static int INF = (int) 1e9;
    static int[] answer;
    static int n1;
    static Set<Integer> summitSet;
    static Set<Integer> gateSet;

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


    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits){
        edges = new ArrayList<>();
        answer = new int[]{0, INF};
        n1 = n;
        summitSet = new HashSet<>();
        gateSet = new HashSet<>();

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }


        for(int[] p : paths){
            int a = p[0];
            int b = p[1];
            int cost = p[2];

            edges.get(a).add(new Edge(b,cost));
            edges.get(b).add(new Edge(a,cost));
        }

        for(int x : gates) gateSet.add(x);
        for(int x : summits) summitSet.add(x);

        Arrays.sort(summits);
        for(int x : gates){
            int[] dd = dijkstra(x);
            for(int y : summits){
                if(dd[y] < answer[1]){
                    answer[0] = y;
                    answer[1] = dd[y];
                }else if(dd[y] == answer[1] && y < answer[0]){
                    answer[0] = y;
                }
            }
        }


        return answer;

    }

    static int[] dijkstra(int start){
        PriorityQueue<Edge> pq= new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d = new int[n1+1];
        Arrays.fill(d, INF);
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;

            if(summitSet.contains(now)) continue;
            if(d[now] < dist) continue;
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int nextcost = edges.get(now).get(i).cost;
                int newIntensity = Math.max(d[now],nextcost);

                if(gateSet.contains(next)) continue;

                if(d[next] > newIntensity){
                    d[next] = newIntensity;
                    pq.offer(new Edge(next, d[next]));
                }

            }
        }

        return d;
    }

    public static void main(String[] args) throws Exception{
        int n = 6;
        int[][] paths = {{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}};
        int[] gates = {1,3};
        int[] summits = {5};
        System.out.println(Arrays.toString(solution(n, paths, gates, summits)));
    }

}
