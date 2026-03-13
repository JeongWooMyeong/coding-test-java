package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 특정한최단경로 {
    static int v,e;
    static ArrayList<ArrayList<edge>> edges = new ArrayList<>();
    static final int inf = (int) 1e9;

    static class edge implements Comparable<edge>{
        private int b;
        private int cost;

        public edge(int b, int cost){
            this.b = b;
            this.cost = cost;
        }

        public int getB(){
            return this.b;
        }

        public int getCost(){
            return this.cost;
        }

        public int compareTo(edge other){
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i=0;i<=v;i++){
            edges.add(new ArrayList<edge>());
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //무방향
            edges.get(a).add(new edge(b, cost));
            edges.get(b).add(new edge(a, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distFrom1 = dijkstra(1);
        int[] distFromv1 = dijkstra(v1);
        int[] distFromv2 = dijkstra(v2);

        long path1 = (long)distFrom1[v1] + distFromv1[v2] + distFromv2[v];
        long path2 = (long)distFrom1[v2] + distFromv2[v1] + distFromv1[v];

        long result = Math.min(path1, path2);
        if(result >= inf) System.out.println(-1);
        else System.out.println(result);


    }

    public static int[] dijkstra(int start){
        PriorityQueue<edge> pq = new PriorityQueue<>();
        int[] dists = new int[v+1];
        Arrays.fill(dists, inf);
        pq.offer(new edge(start, 0));
        dists[start] = 0;

        while(!pq.isEmpty()){
            edge cur = pq.poll();
            int dist = cur.getCost();
            int now = cur.getB();
            if(dists[now] < dist) continue;
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i).getB();
                int cost = dists[now] + edges.get(now).get(i).getCost();
                if(dists[next] > cost){
                    dists[next] = cost;
                    pq.offer(new edge(next, cost));
                }

            }
        }

        return dists;
    }

}
