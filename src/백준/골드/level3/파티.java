package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 파티 {
    static int N, M, X;

    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static ArrayList<ArrayList<Edge>> reverseEdges = new ArrayList<>();
    static final int inf = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        private int b;
        private int cost;

        public Edge(int b, int cost){
            this.b = b;
            this.cost = cost;
        }

        public int getB(){
            return this.b;
        }

        public int getCost(){
            return this.cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());   //정점의 수
            M = Integer.parseInt(st.nextToken());   //간선의 수
            X = Integer.parseInt(st.nextToken());   //?

            //d = new int[N+1];

            for(int i=0;i<N+1;i++){
                edges.add(new ArrayList<Edge>());
                reverseEdges.add(new ArrayList<Edge>());
            }
            //Arrays.fill(d, inf);

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges.get(a).add(new Edge(b, cost));
                reverseEdges.get(b).add(new Edge(a, cost));
            }

            int[] distFromX = dijkstra(X, edges);
            int[] distToX = dijkstra(X, reverseEdges);


            int result = 0;
            for(int i=1;i<=N;i++){
                result = Math.max(result, distFromX[i] + distToX[i]);
            }

            System.out.println(result);


    }

    static int[] dijkstra(int start, ArrayList<ArrayList<Edge>> edgess){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] d = new int[N+1];
        Arrays.fill(d, inf);
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.getB();
            int dist = cur.getCost();
            if(d[now] < dist) continue;

            for(int i=0;i<edgess.get(now).size();i++){
                int cost = d[now] + edgess.get(now).get(i).getCost();
                int next = edgess.get(now).get(i).getB();

                if(cost < d[next]){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }

        }

        return d;
    }



}
