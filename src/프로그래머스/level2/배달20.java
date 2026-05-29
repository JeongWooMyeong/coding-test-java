package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
벨만포드
- 간선중심
- N-1 만큼 진행하면서 거리 갱신
- 그리고 음수 가중치 확인
- 시작지점은1
 */

public class 배달20 {
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
        edges = new ArrayList<>();
        d = new int[N+1];
        Arrays.fill(d, INF);
        int answer = 0;

        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            edges.add(new Edge(a,b,cost));
            edges.add(new Edge(b,a,cost));
        }

        d[1] = 0;

        for(int i=0;i<N-1;i++){
            for(Edge e : edges){
                if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                    d[e.to] = d[e.from] + e.cost;
                }
            }
        }

        for(Edge e : edges){
            if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                System.out.println("음수 가중치 존재");
            }
        }


        for(int i=1;i<=N;i++){
            if(d[i] <= K) answer++;
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        int N = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int K = 4;

        System.out.println(solution(N, road, K));
    }

}
