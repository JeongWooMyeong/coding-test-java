package 프로그래머스.level2;

import java.util.*;
import java.io.*;
/*
벨만포드 연습
간선기준
V-1만큼 돌리면서 간선 확인
간선돌면서 음수 사이클도 확인 가능
 */

public class 배달6 {
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] d;
    static int INF = (int) 1e9;
    //간선 어차피 V-1만큼 도므로 정렬 필요 X
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

        for(int[] r : road){
            int from = r[0];
            int to = r[1];
            int cost = r[2];

            edges.add(new Edge(from, to, cost));
            edges.add(new Edge(to, from, cost));
        }
        //시작점 거리 지정
        d[1] = 0;

        //간선 N-1 마큼 돌면서 모든 간선 확인
        for(int i=1;i<=N-1;i++){
            for(Edge e : edges){
                if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                    d[e.to] = d[e.from] + e.cost;
                }
            }
        }

        //음수 사이클 확인
        boolean negativeCycle = false;
        for(Edge e : edges){
            if(d[e.from] != INF && d[e.to] > d[e.from] + e.cost){
                negativeCycle = true;
                break;
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
