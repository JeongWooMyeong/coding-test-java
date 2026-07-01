package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 등산코스정하기5 {

    static Set<Integer> gatesSet;
    static Set<Integer> summitsSet;
    static ArrayList<ArrayList<Edge>> edges;
    static int[] d;
    static int INF = (int) 1e9;

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

        gatesSet = new HashSet<>();
        summitsSet = new HashSet<>();
        edges = new ArrayList<>();

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int[] p : paths){
            int a = p[0];
            int b = p[1];
            int cost = p[2];

            edges.get(a).add(new Edge(b, cost));
            edges.get(b).add(new Edge(a, cost));
        }

        d = new int[n+1];
        Arrays.fill(d, INF);

        for(int x : gates){
            gatesSet.add(x);
        }

        for(int x : summits){
            summitsSet.add(x);
        }

        dijkstra();

        Arrays.sort(summits);

        int[] answer = new int[]{0, INF};
        for(int x : summits){
            if(d[x] < answer[1]){
                answer[0] = x;
                answer[1] = d[x];
            }
        }


        return answer;
    }

    static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int x : gatesSet) {
            pq.offer(new Edge(x, 0));
            d[x] = 0;
        }

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.to;
            int dist = cur.cost;
            if(summitsSet.contains(now)) continue;
            if(d[now] < dist) continue;
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).to;
                int cost = edges.get(now).get(i).cost;
                int newintensity = Math.max(d[now], cost);

                if(d[next] > newintensity){
                    d[next] = newintensity;
                    pq.offer(new Edge(next,newintensity));
                }

            }
        }

    }

    public static void main(String[] args) throws Exception{
        int n = 6;
        int[][] paths = {{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}};
        int[] gates = {1,3};
        int[] summits = {5};
        System.out.println(Arrays.toString(solution(n, paths, gates, summits)));
    }

}
