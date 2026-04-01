package 이것이코딩테스트다2.기출문제.최단경로;

import java.util.*;
import java.io.*;

public class 숨바꼭질 {
    static int N, M;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static int[] d;
    static final int INF = (int) 1e9;

    static class Edge implements Comparable<Edge>{
        private int b;
        private int cost;

        public Edge(int b, int cost){
            this.b = b;
            this.cost =cost;
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        d = new int[N+1];
        Arrays.fill(d, INF);
        for(int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Edge(b, 1));

        }

        dijkstra(1);

        int maxDistance = 0;
        int nodeIdx = 0;
        int count = 0;
        for(int i=1;i<=N;i++){
            if(d[i] != INF && maxDistance < d[i]){
                maxDistance = d[i];
                nodeIdx = i;
                count=1; //이거 있어야함 최대값 바뀔 수 있으므로...
            }else if(d[i] == maxDistance){
                count++;
            }
        }

        System.out.print(nodeIdx + " " + maxDistance +" " + count);




    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.getB();
            int dist = cur.getCost();
            if(d[now] > dist) continue;
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).getB();
                int cost = d[now] + edges.get(now).get(i).getCost();
                if(d[next] > cost){
                    d[next] = cost;
                    pq.offer(new Edge(next, cost));
                }
            }
        }
    }

}
