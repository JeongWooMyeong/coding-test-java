package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
벨만포드 알고리즘 이용
간선기준
음수가중치
N-1 만큼 돌려서 확인
정렬해야하나? X
 */

public class 배달13 {
    static ArrayList<Edge> edges;
    static int[] d;
    static int INF = (int) 1e9;

    static class Edge{
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static int solution(int N, int[][] road, int K){
        int answer = 0;

        d = new int[N+1];
        Arrays.fill(d, INF);

        edges = new ArrayList<>();

        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            edges.add(new Edge(a,b,cost));
            edges.add(new Edge(b,a,cost));

        }
        //벨만포드
        d[1] = 0;

        for(int i=0;i<N-1;i++){
            for(Edge e : edges) {
                int from = e.from;
                int to = e.to;
                int cost = e.cost;

                if (d[from] != INF && d[to] > d[from] + cost) {
                    d[to] = d[from] + cost;
                }
            }

        }
        boolean negative = false;
        for(Edge e : edges){
            int from = e.from;
            int to = e.to;
            int cost = e.cost;

            if(d[from] != INF && d[to] > d[from] + cost){
                negative = true;
                break;
            }
        }

        if(negative){
            System.out.println("음수 가중치 존재");
        }

        for(int i=1;i<=N;i++){
            if(d[i] <= K) answer++;
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int[][] road = {{1,2,-1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        System.out.println(solution(N, road, K));
    }

}
