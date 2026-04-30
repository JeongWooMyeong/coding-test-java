package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
벨만포드 알고리즘 (음수 가중치)
V-1 만큼 돔
 */

public class 배달5 {
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] d;
    static int INF = (int) 1e9;

    static class Edge{
        int from;
        int to;
        int cost;

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

        d[1] = 0;

        for(int i=1;i<=N-1;i++){
            for(int j=0;j<edges.size();j++){
                int from = edges.get(j).from;
                int to = edges.get(j).to;
                int cost = edges.get(j).cost;

                if(d[from] != INF && d[to] > d[from] + cost){
                    d[to] = d[from] + cost;
                }

            }
        }

        boolean negativeCycle = false;
        for(int i=0;i<edges.size();i++){
            int from = edges.get(i).from;
            int to = edges.get(i).to;
            int cost = edges.get(i).cost;
            if(d[from] != INF && d[to] > d[from] + cost){
                negativeCycle = true;
                break;
            }
        }

        for(int i=1;i<=N;i++){
            if(d[i] <= K) answer++;
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
