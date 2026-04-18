package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
answer int로 하면 overflow 발생
 */

public class 택시합승요금 {
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        int next, cost;

        public Edge(int next, int cost){
            this.next = next;
            this.cost = cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static int solution(int n, int s, int a, int b, int[][] fares){

        long answer = INF;
        //간선 정보 초기화
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }
        //간선 정보 입력
        for(int i=0;i<fares.length;i++){
            int[] info = fares[i];
            int x = info[0];
            int y = info[1];
            int cost = info[2];
            //양방향
            edges.get(x).add(new Edge(y,cost));
            edges.get(y).add(new Edge(x,cost));
        }

        int[] distS = dijkstra(n,s);
        int[] distA = dijkstra(n,a);
        int[] distB = dijkstra(n,b);

        for(int k=1;k<=n;k++){
            //S에서 경유지, A에서 경유지 , B에서 경유지
            answer = Math.min(answer, (long) distS[k] + distA[k] + distB[k]);
        }


        return (int)answer;
    }

    static int[] dijkstra(int n, int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] d = new int[n+1];
        Arrays.fill(d, INF);
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur= pq.poll();
            int now = cur.next;
            int dist = cur.cost;
            if(d[now] < dist) continue;

            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).next;
                int cost = d[now] + edges.get(now).get(i).cost;
                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }

        }

        //비교
        //int answer = Math.min(d[end1] , d[end2]);

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
