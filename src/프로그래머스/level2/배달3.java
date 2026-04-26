package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
이문제는 가중치가 다 양수라서 다익스트라로 풀면되지만
음수 일때는 벨만포드 알고리즘으로 풀어야함
그래서 알아둘겸 벨만포드 알고리즘으로 풀어봄
 */

public class 배달3 {
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
        edges = new ArrayList<>();
        d = new int[N+1];

        Arrays.fill(d, INF);

        for(int i=0;i<road.length;i++){
            int[] r = road[i];
            int from = r[0];
            int to = r[1];
            int cost = r[2];

            edges.add(new Edge(from, to, cost));
            edges.add(new Edge(to, from, cost));

        }
        //시작점 초기화
        d[1] = 0;

        //간선 중심으로 탐색
        for(int i=1;i<=N-1;i++){
            for(Edge e : edges){
                if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                    d[e.to] = d[e.from] + e.cost;
                }
            }
        }

        boolean negativeCycle = false;
        for(Edge e : edges){
            if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                negativeCycle = true;
                return -1;
            }
        }

        for(int i=1;i<=N;i++){
            if(d[i] <= K){
                answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        System.out.println(solution(N, road, K));
    }
}
